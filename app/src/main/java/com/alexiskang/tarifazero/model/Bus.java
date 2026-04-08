package com.alexiskang.tarifazero.model;

public class Bus {
    private String UUID;
    private String model;
    private String version;
    private String brand;
    private String plate;
    private int year;
    private int capacity;

    public Bus() {
    }

    public Bus(String UUID, String model, String version, String brand, String plate, int year, int capacity) {
        this.UUID = UUID;
        this.model = model;
        this.version = version;
        this.brand = brand;
        this.plate = plate;
        this.year = year;
        this.capacity = capacity;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + version + " " + year;
    }
}
