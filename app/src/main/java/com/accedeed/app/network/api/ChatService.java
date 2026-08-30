package com.accedeed.app.network.api;

import com.accedeed.app.model.ChatMessage;
import com.accedeed.app.network.dto.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChatService {
    @POST("chat/send")
    Call<ApiResponse<ChatMessage>> sendMessage(
            @Header("Authorization") String token,
            @Body ChatMessage message
    );

    @GET("chat/messages")
    Call<ApiResponse<List<ChatMessage>>> getMessages(
            @Header("Authorization") String token,
            @Query("limit") int limit
    );

    @POST("chat/ai-response")
    Call<ApiResponse<String>> getAIResponse(
            @Header("Authorization") String token,
            @Body String question
    );
}
