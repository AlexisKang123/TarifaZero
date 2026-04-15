package com.alexiskang.tarifazero.database;

import com.alexiskang.tarifazero.model.AuthRequest;
import com.alexiskang.tarifazero.model.Notification;
import com.alexiskang.tarifazero.model.User;
import com.alexiskang.tarifazero.model.UserAddress;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SupabaseService {

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

    @POST("rest/v1/rpc/set_selected_address")
    Call<Void> setSelectedAddress(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token,
            @Body Map<String, String> body
    );

    @GET("rest/v1/user_addresses?select=selected,address:addresses(*)")
    Call<List<UserAddress>> getUserAddresses(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token
    );

    @GET("rest/v1/users?select=*")
    Call<List<User>> getUser(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token
    );

    @GET("rest/v1/notification?select=*")
    Call<List<Notification>> getNotification(
            @Header("apikey") String apiKey,
            @Header("Authorization") String token
    );
}
