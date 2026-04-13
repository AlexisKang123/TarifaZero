package com.alexiskang.tarifazero.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF_NAME = "app_session";
    private static final String KEY_TOKEN = "token";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context){
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveToken(String token){
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public String getToken(){
        return prefs.getString(KEY_TOKEN, null);
    }

    public boolean isLogged(){
        return getToken() != null;
    }

    public void logout(){
        editor.clear();
        editor.apply();
    }

    public void saveUserName(String name){
        editor.putString("user_name", name);
        editor.apply();
    }

    public String getUserName(){
        return prefs.getString("user_name", "");
    }

    public void saveAddress(String address){
        editor.putString("user_address", address);
        editor.apply();
    }

    public String getAddress(){
        return prefs.getString("user_address", "");
    }
}