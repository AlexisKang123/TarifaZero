package com.alexiskang.tarifazero.model;

import java.time.LocalDateTime;

public class Notification {

    private String UUID;
    private String title;
    private String describe;
    private String status;

    public Notification() {
    }

    public Notification(String UUID, String title, String describe, String status) {
        this.UUID = UUID;
        this.title = title;
        this.describe = describe;
        this.status = status;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "UUID='" + UUID + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
