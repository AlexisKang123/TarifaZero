package com.alexiskang.tarifazero.model;

public class AuthRequest {
    String email;
    String password;

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
