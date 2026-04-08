package com.alexiskang.tarifazero.model;

public class Adress {

    private String UUID;
    private String street;
    private String number;
    private String district;
    private String zip_code;

    private boolean selected;

    public Adress() {
    }

    public Adress(String zip_code, String district, String number, String street, String UUID, boolean selected) {
        this.zip_code = zip_code;
        this.district = district;
        this.number = number;
        this.street = street;
        this.UUID = UUID;
        this.selected = selected;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "UUID='" + UUID + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", selected=" + selected +
                '}';
    }
}
