package com.accedeed.app.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.network.RetrofitClient;
import com.accedeed.app.network.api.ChatService;
import com.accedeed.app.network.dto.ApiResponse;
import com.accedeed.app.model.Mensaje;
import com.accedeed.app.ui.adapter.MensajeAdapter;
import com.accedeed.app.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatFragment extends Fragment {
    private RecyclerView rvMensajes;
    private EditText etMensaje;
    private Button btnEnviar;
    private ProgressBar progressBar;
    private MensajeAdapter mensajeAdapter;
    private List<Mensaje> mensajes = new ArrayList<>();
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferenceManager = new PreferenceManager(getContext());
        rvMensajes = view.findViewById(R.id.rv_mensajes);
        etMensaje = view.findViewById(R.id.et_mensaje);
        btnEnviar = view.findViewById(R.id.btn_enviar);
        progressBar = view.findViewById(R.id.progress_bar);

        setupRecyclerView();
        loadMensajes();
        setupListeners();
    }

    private void setupRecyclerView() {
        mensajeAdapter = new MensajeAdapter(mensajes);
        rvMensajes.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMensajes.setAdapter(mensajeAdapter);
    }

    private void setupListeners() {
        btnEnviar.setOnClickListener(v -> enviarMensaje());
    }

    private void enviarMensaje() {
        String texto = etMensaje.getText().toString().trim();
        if (texto.isEmpty()) return;

        Mensaje mensaje = new Mensaje(preferenceManager.getUserId(), texto, System.currentTimeMillis());
        mensajes.add(mensaje);
        mensajeAdapter.notifyDataSetChanged();
        etMensaje.setText("");

        ChatService chatService = RetrofitClient.getClient().create(ChatService.class);
        chatService.enviarMensaje(mensaje).enqueue(new Callback<ApiResponse<Mensaje>>() {
            @Override
            public void onResponse(Call<ApiResponse<Mensaje>> call, Response<ApiResponse<Mensaje>> response) {
                // Mensaje enviado
            }

            @Override
            public void onFailure(Call<ApiResponse<Mensaje>> call, Throwable t) {
                // Error al enviar
            }
        });
    }

    private void loadMensajes() {
        progressBar.setVisibility(View.VISIBLE);
        ChatService chatService = RetrofitClient.getClient().create(ChatService.class);

        chatService.getMensajes().enqueue(new Callback<ApiResponse<List<Mensaje>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Mensaje>>> call, Response<ApiResponse<List<Mensaje>>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<List<Mensaje>> apiResponse = response.body();
                    if (apiResponse.isSuccess()) {
                        mensajes.addAll(apiResponse.getData());
                        mensajeAdapter.notifyDataSetChanged();
                        rvMensajes.scrollToPosition(mensajes.size() - 1);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Mensaje>>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
