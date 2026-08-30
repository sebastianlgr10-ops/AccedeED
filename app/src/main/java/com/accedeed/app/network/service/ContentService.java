package com.accedeed.app.network.service;

import com.accedeed.app.model.Evento;
import com.accedeed.app.model.Recurso;
import com.accedeed.app.network.dto.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface ContentService {
    @GET("eventos")
    Call<ApiResponse<List<Evento>>> getEventos();

    @GET("eventos/{id}")
    Call<ApiResponse<Evento>> getEvento(@Path("id") String id);

    @POST("eventos")
    Call<ApiResponse<Evento>> createEvento(@Body Evento evento);

    @GET("recursos")
    Call<ApiResponse<List<Recurso>>> getRecursos();

    @GET("recursos")
    Call<ApiResponse<List<Recurso>>> getRecursosByCategoria(@Query("categoria") String categoria);

    @GET("recursos/{id}")
    Call<ApiResponse<Recurso>> getRecurso(@Path("id") String id);

    @POST("recursos")
    Call<ApiResponse<Recurso>> createRecurso(@Body Recurso recurso);
}
