package com.accedeed.app.network.api;

import com.accedeed.app.model.Recurso;
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

public interface RecursoService {
    @GET("recursos")
    Call<ApiResponse<List<Recurso>>> getAllRecursos();

    @GET("recursos/subject/{subject}")
    Call<ApiResponse<List<Recurso>>> getRecursosBySubject(@Path("subject") String subject);

    @GET("recursos/{id}")
    Call<ApiResponse<Recurso>> getRecursoById(@Path("id") int id);

    @POST("recursos")
    Call<ApiResponse<Recurso>> createRecurso(
            @Header("Authorization") String token,
            @Body Recurso recurso
    );

    @PUT("recursos/{id}")
    Call<ApiResponse<Recurso>> updateRecurso(
            @Path("id") int id,
            @Header("Authorization") String token,
            @Body Recurso recurso
    );

    @DELETE("recursos/{id}")
    Call<ApiResponse<Void>> deleteRecurso(
            @Path("id") int id,
            @Header("Authorization") String token
    );

    @GET("recursos/search")
    Call<ApiResponse<List<Recurso>>> searchRecursos(@Query("q") String query);

    @POST("recursos/{id}/favorite")
    Call<ApiResponse<Void>> toggleFavorite(
            @Path("id") int id,
            @Header("Authorization") String token
    );
}
