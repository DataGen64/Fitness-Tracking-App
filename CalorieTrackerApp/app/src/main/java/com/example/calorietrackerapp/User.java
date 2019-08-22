package com.example.calorietrackerapp;

import java.util.Date;

public class User {

    private Integer userid;
    private String fname;
    private String lname;
    private String email;
    private int height;
    private int weight;
    private String address;
    private String postcode;
    private int activityLevel;
    private int stepsPerMile;
    private String gender;
    private Date dob;


    public User(Integer userid, String fname, String lname, String email, int height, int weight, String address, String postcode, int activityLevel, int stepsPerMile, Date dob, String gender) {
        this.userid = userid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.postcode = postcode;
        this.activityLevel = activityLevel;
        this.stepsPerMile = stepsPerMile;
        this.dob = dob;
        this.gender = gender;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getStepsPerMile() {
        return stepsPerMile;
    }

    public void setStepsPerMile(int stepsPerMile) {
        this.stepsPerMile = stepsPerMile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
