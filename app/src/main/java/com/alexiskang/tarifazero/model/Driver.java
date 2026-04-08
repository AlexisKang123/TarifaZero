package com.alexiskang.tarifazero.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Driver {
    private String UUID;
    private String name;
    private LocalDate birth;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;

    public Driver() {
    }

    public Driver(String UUID, String name, LocalDate birth, LocalDateTime clockIn, LocalDateTime clockOut) {
        this.UUID = UUID;
        this.name = name;
        this.birth = birth;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDateTime getClockIn() {
        return clockIn;
    }

    public void setClockIn(LocalDateTime clockIn) {
        this.clockIn = clockIn;
    }

    public LocalDateTime getClockOut() {
        return clockOut;
    }

    public void setClockOut(LocalDateTime clockOut) {
        this.clockOut = clockOut;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "UUID='" + UUID + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                '}';
    }
}
