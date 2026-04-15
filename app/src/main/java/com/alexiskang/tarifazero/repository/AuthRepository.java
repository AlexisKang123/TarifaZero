package com.alexiskang.tarifazero.repository;

import android.util.Log;

import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.model.AuthRequest;
import com.alexiskang.tarifazero.model.User;
import com.google.gson.Gson;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private SupabaseService service;

    public AuthRepository() {
        service = SupabaseClient.getClient().create(SupabaseService.class);
    }

    // 🔥 REGISTER COMPLETO
    public void register(String email, String senha, String nome, String curso, AuthCallback callback){

        AuthRequest request = new AuthRequest(email, senha);

        service.register(
                SupabaseConfig.API_KEY,
                "application/json",
                request
        ).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                try {

                    if(response.errorBody() != null){
                        Log.e("REGISTER", response.errorBody().string());
                    }

                    if(response.isSuccessful()){

                        login(email, senha, new AuthCallback() {

                            @Override
                            public void onSuccess(String token) {

                                try {

                                    String jsonString = new com.google.gson.Gson().toJson(response.body());
                                    JSONObject json = new JSONObject(jsonString);
                                    JSONObject userJson = json.getJSONObject("user");

                                    String id = userJson.getString("id");

                                    User user = new User(id, nome, curso, email, null);

                                    service.insertUser(
                                            SupabaseConfig.API_KEY,
                                            "Bearer " + token,
                                            "application/json",
                                            user
                                    ).enqueue(new Callback<Void>() {

                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            Log.d("INSERT", "Sucesso: " + response.code());
                                            callback.onSuccess(token);
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            Log.e("INSERT", t.getMessage());
                                            callback.onError("Erro ao salvar no banco");
                                        }
                                    });

                                } catch (Exception e){
                                    callback.onError(e.getMessage());
                                }
                            }

                            @Override
                            public void onError(String erro) {
                                callback.onError("Erro no login automático");
                            }
                        });

                    } else {
                        callback.onError("Erro no cadastro");
                    }

                } catch (Exception e){
                    callback.onError(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // 🔥 LOGIN
    public void login(String email, String senha, AuthCallback callback){

        AuthRequest request = new AuthRequest(email, senha);

        service.login(
                SupabaseConfig.API_KEY,
                "application/json",
                request
        ).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                try {

                    if(response.isSuccessful() && response.body() != null){

                        String jsonString = new Gson().toJson(response.body());
                        JSONObject json = new JSONObject(jsonString);

                        String token = json.getString("access_token");

                        callback.onSuccess(token);

                    } else {
                        callback.onError("Email ou senha inválidos");
                    }

                } catch (Exception e){
                    callback.onError(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
