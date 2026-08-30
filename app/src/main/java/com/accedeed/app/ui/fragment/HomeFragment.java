package com.accedeed.app.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.network.RetrofitClient;
import com.accedeed.app.network.api.ContentService;
import com.accedeed.app.network.dto.ApiResponse;
import com.accedeed.app.model.Evento;
import com.accedeed.app.ui.adapter.EventoAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView rvEventos;
    private ProgressBar progressBar;
    private EventoAdapter eventoAdapter;
    private List<Evento> eventos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvEventos = view.findViewById(R.id.rv_eventos);
        progressBar = view.findViewById(R.id.progress_bar);

        setupRecyclerView();
        loadEventos();
    }

    private void setupRecyclerView() {
        eventoAdapter = new EventoAdapter(eventos);
        rvEventos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEventos.setAdapter(eventoAdapter);
    }

    private void loadEventos() {
        progressBar.setVisibility(View.VISIBLE);
        ContentService contentService = RetrofitClient.getClient().create(ContentService.class);

        contentService.getEventos().enqueue(new Callback<ApiResponse<List<Evento>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Evento>>> call, Response<ApiResponse<List<Evento>>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<List<Evento>> apiResponse = response.body();
                    if (apiResponse.isSuccess()) {
                        eventos.addAll(apiResponse.getData());
                        eventoAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Evento>>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
