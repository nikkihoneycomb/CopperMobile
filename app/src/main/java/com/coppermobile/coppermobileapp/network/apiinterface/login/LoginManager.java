package com.coppermobile.coppermobileapp.network.apiinterface.login;


/*
   Name: LoginManager
   Purpose: class that extends NetworkManager for login service to create using retrofit
        */
public class LoginManager extends com.coppermobile.coppermobileapp.network.apiinterface.NetworkManager {

    public LoginService create() {
        return retrofit.create(LoginService.class);
    }

}
