package com.coppermobile.coppermobileapp.network.apiinterface.apimanager;

import com.coppermobile.coppermobileapp.network.GetProfileService;

/*
   Name: ProfileManager
   Purpose: class that extends NetworkManager for profile service to create using retrofit
        */
public class ProfileManager extends NetworkManager {

    public GetProfileService create() {
        return retrofit.create(GetProfileService.class);
    }

}
