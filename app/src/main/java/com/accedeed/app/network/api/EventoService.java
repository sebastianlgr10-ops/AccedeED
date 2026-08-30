package com.accedeed.app.network.api;

import com.accedeed.app.model.Evento;
import com.accedeed.app.network.dto.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventoService {
    @GET("eventos")
    Call<ApiResponse<List<Evento>>> getAllEventos();

    @GET("eventos/{id}")
    Call<ApiResponse<Evento>> getEventoById(@Path("id") int id);

    @GET("eventos/subject/{subject}")
    Call<ApiResponse<List<Evento>>> getEventosBySubject(@Path("subject") String subject);

    @POST("eventos")
    Call<ApiResponse<Evento>> createEvento(
            @Header("Authorization") String token,
            @Body Evento evento
    );

    @PUT("eventos/{id}")
    Call<ApiResponse<Evento>> updateEvento(
            @Path("id") int id,
            @Header("Authorization") String token,
            @Body Evento evento
    );

    @DELETE("eventos/{id}")
    Call<ApiResponse<Void>> deleteEvento(
            @Path("id") int id,
            @Header("Authorization") String token
    );

    @POST("eventos/{id}/complete")
    Call<ApiResponse<Void>> completeEvento(
            @Path("id") int id,
            @Header("Authorization") String token
    );

    @GET("eventos/range")
    Call<ApiResponse<List<Evento>>> getEventosByDateRange(
            @Query("startDate") long startDate,
            @Query("endDate") long endDate
    );
}
