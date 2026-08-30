package com.accedeed.app.network.api;

import com.accedeed.app.network.dto.LoginRequest;
import com.accedeed.app.network.dto.RegisterRequest;
import com.accedeed.app.network.dto.ApiResponse;
import com.accedeed.app.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AuthService {
    @POST("auth/login")
    Call<ApiResponse<User>> login(@Body LoginRequest request);

    @POST("auth/register")
    Call<ApiResponse<User>> register(@Body RegisterRequest request);

    @POST("auth/logout")
    Call<ApiResponse<Void>> logout(@Header("Authorization") String token);

    @GET("auth/profile")
    Call<ApiResponse<User>> getProfile(@Header("Authorization") String token);

    @PUT("auth/profile")
    Call<ApiResponse<User>> updateProfile(@Header("Authorization") String token, @Body User user);

    @POST("auth/refresh-token")
    Call<ApiResponse<String>> refreshToken(@Body String refreshToken);
}
