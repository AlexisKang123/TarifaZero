package com.alexiskang.tarifazero.repository;

public interface AuthCallback {
    void onSuccess(String token);
    void onError(String erro);
}
