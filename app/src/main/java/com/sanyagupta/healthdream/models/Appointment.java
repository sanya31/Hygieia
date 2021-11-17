package com.sanyagupta.healthdream.models;

public class Appointment {
    private String doctor;
    private String date;
    private String time;

    public Appointment() {
    }

    public Appointment(String doctor, String date, String time) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Appointment(String doctor, String date) {
        this.doctor = doctor;
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
