package com.alexiskang.tarifazero.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Route {
    private String id;
    @SerializedName("id_bus_stop_initial")
    private String BusStopInitial;
    @SerializedName("id_bus_stop_final")
    private String busStopFinal;
    @SerializedName("duration")
    private int duration;
    @SerializedName("id_lines")
    private String idLines;

    public Route() {
    }

    public Route(String id, String busStopInitial, String busStopFinal, int duration, String idLines) {
        this.id = id;
        BusStopInitial = busStopInitial;
        this.busStopFinal = busStopFinal;
        this.duration = duration;
        this.idLines = idLines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusStopInitial() {
        return BusStopInitial;
    }

    public void setBusStopInitial(String busStopInitial) {
        BusStopInitial = busStopInitial;
    }

    public String getBusStopFinal() {
        return busStopFinal;
    }

    public void setBusStopFinal(String busStopFinal) {
        this.busStopFinal = busStopFinal;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIdLines() {
        return idLines;
    }

    public void setIdLines(String idLines) {
        this.idLines = idLines;
    }
}
