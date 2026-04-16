package com.alexiskang.tarifazero.model;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("id")
    private String id;
    private String street;
    private String number;
    private String district;
    @SerializedName("zip_code")
    private String zip_code;

    private double latitude;
    private double longitude;
    private String city;
    private String state;

    private String country;

    public Address() {
    }

    public Address(String id, String street, String number, String district, String zip_code, double latitude, double longitude, String city, String state, String country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.zip_code = zip_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
