package com.alexiskang.tarifazero.database;

import com.alexiskang.tarifazero.model.AuthRequest;
import com.alexiskang.tarifazero.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SupabaseService {

    @GET("rest/v1/users?select=*")
    Call<Object> testarConexao(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token
    );
    @POST("auth/v1/signup")
    Call<Object> register(
            @Header("apikey") String apiKey,
            @Header("Content-Type") String contentType,
            @Body AuthRequest request
    );

    @POST("auth/v1/token?grant_type=password")
    Call<Object> login(
            @Header("apikey") String apiKey,
            @Header("Content-Type") String contentType, // 🔥 FALTAVA
            @Body AuthRequest request
    );

    @POST("rest/v1/users")
    Call<Void> insertUser(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token,
            @Header("Content-Type") String contentType,
            @Body User user
    );
}
