package com.accedeed.app.network.client;

import com.accedeed.app.network.service.AuthService;
import com.accedeed.app.network.service.ContentService;
import com.accedeed.app.network.service.ChatService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.accedeed.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static AuthService getAuthService() {
        return getRetrofitClient().create(AuthService.class);
    }

    public static ContentService getContentService() {
        return getRetrofitClient().create(ContentService.class);
    }

    public static ChatService getChatService() {
        return getRetrofitClient().create(ChatService.class);
    }
}
