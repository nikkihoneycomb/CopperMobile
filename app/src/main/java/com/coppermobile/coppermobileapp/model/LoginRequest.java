package com.coppermobile.coppermobileapp.model;

import com.google.gson.annotations.SerializedName;


    /*
    Name: LoginRequest
    Purpose: POJO class for LoginRequest with email and password as request parameters
     */
public class LoginRequest {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    //constructor for login request
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //getter and setter methods
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
