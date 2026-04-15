package com.alexiskang.tarifazero.model;

public class Notification {

    private String uuid;
    private String title;
    private String description;
    private String status;

    public Notification() {
    }

    public Notification(String UUID, String title, String describe, String status) {
        this.uuid = UUID;
        this.title = title;
        this.description = describe;
        this.status = status;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return description;
    }

    public void setDescribe(String describe) {
        this.description = describe;
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
                "UUID='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
