package com.coppermobile.coppermobileapp.network.apiinterface.apimanager;

import com.coppermobile.coppermobileapp.network.apiinterface.LoginService;

/*
   Name: LoginManager
   Purpose: class that extends NetworkManager for login service to create using retrofit
        */
public class LoginManager extends NetworkManager {

    public LoginService create() {
        return retrofit.create(LoginService.class);
    }

}
