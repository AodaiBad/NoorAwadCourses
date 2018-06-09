package com.awad.noor.noorawadcourses.data;

/**
 * Created by aodai on 10/06/2018.
 */

public class Course {

    private String Phone;
    private String Location;
    private String Subject;
    private int Days;
    private double price;
    private String keyId;

    private String email;

    public Course() {
    }

    public Course(String phone, String location, String subject, int days, double price) {
        Phone = phone;
        Location = location;
        Subject = subject;
        Days = days;
        this.price = price;
        this.email = email;
    }

    public Course(String phone, String location, String subject, int days, double price, String keyId) {
        Phone = phone;
        Location = location;
        Subject = subject;
        Days = days;
        this.price = price;
        this.keyId = keyId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        Days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
