package com.sanyagupta.healthdream.models;

public class User {
    private String name;
    private String phone;
    private String gender;
    private String area;
    private String email;
    private int age;

    public User(String name, String phone, String gender, String area, String email, int age) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.area = area;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
