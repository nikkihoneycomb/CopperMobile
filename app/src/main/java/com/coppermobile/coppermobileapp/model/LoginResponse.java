package com.coppermobile.coppermobileapp.model;

import com.google.gson.annotations.SerializedName;

 /*
    Name: LoginResponse
    Purpose: POJO class for LoginResponse with status code as response parameter
 */

public class LoginResponse {

    @SerializedName("token")
    private String token;

    @SerializedName("statusCode")
    private int statusCode;

    //getter and setter methods
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
