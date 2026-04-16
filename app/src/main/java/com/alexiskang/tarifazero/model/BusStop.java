package com.alexiskang.tarifazero.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class BusStop {
    private String UUID;
    private String title;
    @SerializedName("addresses")
    private BusStopAddress address;
    private LocalDateTime time;

    public BusStop() {
    }

    public BusStop(String UUID, String title, BusStopAddress address, LocalDateTime time) {
        this.UUID = UUID;
        this.title = title;
        this.address = address;
        this.time = time;
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

    public BusStopAddress getAddress() {
        return address;
    }

    public void setAddress(BusStopAddress address) {
        this.address = address;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "UUID='" + UUID + '\'' +
                ", title='" + title + '\'' +
                ", address=" + address +
                ", time=" + time +
                '}';
    }
}
