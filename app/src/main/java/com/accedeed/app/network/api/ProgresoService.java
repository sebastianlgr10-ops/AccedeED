package com.accedeed.app.network.api;

import com.accedeed.app.model.Progreso;
import com.accedeed.app.network.dto.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProgresoService {
    @GET("progresos/user/{uid}")
    Call<ApiResponse<List<Progreso>>> getProgresoByUser(
            @Path("uid") String uid,
            @Header("Authorization") String token
    );

    @GET("progresos/subject/{subject}")
    Call<ApiResponse<List<Progreso>>> getProgresoBySubject(@Path("subject") String subject);

    @GET("progresos/total/{uid}")
    Call<ApiResponse<Float>> getTotalProgreso(
            @Path("uid") String uid,
            @Header("Authorization") String token
    );

    @PUT("progresos/{id}")
    Call<ApiResponse<Progreso>> updateProgreso(
            @Path("id") int id,
            @Header("Authorization") String token
    );
}
