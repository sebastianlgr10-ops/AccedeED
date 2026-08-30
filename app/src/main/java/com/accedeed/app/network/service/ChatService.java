package com.accedeed.app.network.service;

import com.accedeed.app.model.Mensaje;
import com.accedeed.app.network.dto.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.DELETE;

public interface ChatService {
    @GET("chat/mensajes")
    Call<ApiResponse<List<Mensaje>>> getMensajes();

    @POST("chat/mensajes")
    Call<ApiResponse<Mensaje>> sendMensaje(@Body Mensaje mensaje);

    @DELETE("chat/mensajes/{id}")
    Call<ApiResponse<Void>> deleteMensaje(@Path("id") String id);

    @GET("chat/usuarios")
    Call<ApiResponse<List<String>>> getUsuariosEnLinea();
}
