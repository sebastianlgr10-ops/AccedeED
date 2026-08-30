package com.accedeed.app.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.network.RetrofitClient;
import com.accedeed.app.network.api.ContentService;
import com.accedeed.app.network.dto.ApiResponse;
import com.accedeed.app.model.Recurso;
import com.accedeed.app.ui.adapter.RecursoAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecursosFragment extends Fragment {
    private RecyclerView rvRecursos;
    private ProgressBar progressBar;
    private RecursoAdapter recursoAdapter;
    private List<Recurso> recursos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recursos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRecursos = view.findViewById(R.id.rv_recursos);
        progressBar = view.findViewById(R.id.progress_bar);

        setupRecyclerView();
        loadRecursos();
    }

    private void setupRecyclerView() {
        recursoAdapter = new RecursoAdapter(recursos);
        rvRecursos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRecursos.setAdapter(recursoAdapter);
    }

    private void loadRecursos() {
        progressBar.setVisibility(View.VISIBLE);
        ContentService contentService = RetrofitClient.getClient().create(ContentService.class);

        contentService.getRecursos().enqueue(new Callback<ApiResponse<List<Recurso>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Recurso>>> call, Response<ApiResponse<List<Recurso>>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<List<Recurso>> apiResponse = response.body();
                    if (apiResponse.isSuccess()) {
                        recursos.addAll(apiResponse.getData());
                        recursoAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Recurso>>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
