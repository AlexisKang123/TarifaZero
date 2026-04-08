package com.alexiskang.tarifazero.model;

public class User {

    private String id;
    private String name;
    private String course;
    private String email;

    public User() {
    }

    public User(String id, String name, String course, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setUUID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }
}