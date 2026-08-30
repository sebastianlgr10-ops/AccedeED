package com.accedeed.app.network.service;

import com.accedeed.app.network.dto.LoginRequest;
import com.accedeed.app.network.dto.LoginResponse;
import com.accedeed.app.network.dto.RegisterRequest;
import com.accedeed.app.network.dto.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("auth/login")
    Call<ApiResponse<LoginResponse>> login(@Body LoginRequest request);

    @POST("auth/register")
    Call<ApiResponse<LoginResponse>> register(@Body RegisterRequest request);

    @POST("auth/logout")
    Call<ApiResponse<Void>> logout();

    @POST("auth/refresh-token")
    Call<ApiResponse<LoginResponse>> refreshToken();
}
