package com.alexiskang.tarifazero.model;

import java.time.LocalDateTime;

public class BusStop {
    private String UUID;
    private String title;
    private Adress adress;
    private LocalDateTime time;

    public BusStop() {
    }

    public BusStop(String UUID, String title, Adress adress, LocalDateTime time) {
        this.UUID = UUID;
        this.title = title;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
                ", adress=" + adress +
                ", time=" + time +
                '}';
    }
}
