package com.alexiskang.tarifazero.model;

import java.util.ArrayList;

public class User {

    private String id;
    private String name;
    private String course;
    private String email;

    private ArrayList<UserAddress> adresses;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<UserAddress> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<UserAddress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", adresses=" + adresses +
                '}';
    }
}