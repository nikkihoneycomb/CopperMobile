package com.coppermobile.coppermobileapp.network.apiinterface.profile;


import com.coppermobile.coppermobileapp.network.apiinterface.NetworkManager;

/*
   Name: ProfileManager
   Purpose: class that extends NetworkManager for profile service to create using retrofit
        */
public class ProfileManager extends NetworkManager {

    public GetProfileService create() {
        return retrofit.create(GetProfileService.class);
    }

}
