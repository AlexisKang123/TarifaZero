package com.alexiskang.tarifazero.model;

import java.util.ArrayList;

public class Line {
    private String UUID;
    private Driver driver;
    private Bus bus;
    private ArrayList<BusStop> listBusStop;

    public Line() {
    }

    public Line(String UUID, Driver driver, Bus bus, ArrayList<BusStop> listBusStop) {
        this.UUID = UUID;
        this.driver = driver;
        this.bus = bus;
        this.listBusStop = listBusStop;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
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

    public ArrayList<BusStop> getListBusStop() {
        return listBusStop;
    }

    public void setListBusStop(ArrayList<BusStop> listBusStop) {
        this.listBusStop = listBusStop;
    }

    @Override
    public String toString() {
        return "Line{" +
                "UUID='" + UUID + '\'' +
                ", driver=" + driver +
                ", bus=" + bus +
                ", listBusStop=" + listBusStop +
                '}';
    }
}
