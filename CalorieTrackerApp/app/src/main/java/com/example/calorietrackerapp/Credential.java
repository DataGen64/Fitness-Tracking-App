package com.example.calorietrackerapp;


import java.util.Date;

public class Credential {

    private String username;

    private String password;

    private Date signupDate;

    private int userId;

    public Credential(String username, String password, Date currentTime) {
        this.username = username;
        this.password = password;
        this.signupDate= currentTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



}
