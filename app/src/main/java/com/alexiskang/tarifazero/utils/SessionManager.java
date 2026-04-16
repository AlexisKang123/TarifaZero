package com.alexiskang.tarifazero.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF_NAME = "app_session";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LON = "lon";
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

    public void saveLat(double lat) {
        editor.putFloat(KEY_LAT, (float) lat);
        editor.apply();
    }

    public void saveLon(double lon) {
        editor.putFloat(KEY_LON, (float) lon);
        editor.apply();
    }

    public double getLat() {
        return prefs.getFloat(KEY_LAT, 0f);
    }

    public double getLon() {
        return prefs.getFloat(KEY_LON, 0f);
    }
}