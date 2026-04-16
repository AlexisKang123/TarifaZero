package com.alexiskang.tarifazero.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Line {
    private String UUID;
    private String title;
    private Driver driver;
    private Bus bus;
    @SerializedName("routes")
    private ArrayList<Route> listRoute;

    public Line() {
    }

    public Line(String UUID, String title, Driver driver, Bus bus, ArrayList<Route> listRoute) {
        this.UUID = UUID;
        this.title = title;
        this.driver = driver;
        this.bus = bus;
        this.listRoute = listRoute;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public ArrayList<Route> getListRoute() {
        return listRoute;
    }

    public void setListRoute(ArrayList<Route> listRoute) {
        this.listRoute = listRoute;
    }
}
