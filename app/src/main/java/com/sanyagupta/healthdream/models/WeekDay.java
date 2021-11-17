package com.sanyagupta.healthdream.models;

public class WeekDay {
    private String medicine_name;
    private String time,day;

    public WeekDay() {
        time=null;
    }

    public WeekDay(String medicine_name, String time1) {
        this.medicine_name = medicine_name;
        this.time = time1;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time1) {
        this.time = time1;
    }


}
