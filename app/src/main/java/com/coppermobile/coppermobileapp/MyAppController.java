package com.coppermobile.coppermobileapp;

import android.app.Application;

import com.coppermobile.coppermobileapp.network.GetProfileService;
import com.coppermobile.coppermobileapp.network.apiinterface.LoginService;
import com.coppermobile.coppermobileapp.network.apiinterface.apimanager.LoginManager;
import com.coppermobile.coppermobileapp.network.apiinterface.apimanager.ProfileManager;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

 /*
    Name: MyAppController
    Purpose: class at application level to access services globally
     */

public class MyAppController extends Application {
    private static MyAppController mInstance;
    private LoginService loginService;
    private GetProfileService profileService;
    private Scheduler scheduler;

    private static MyAppController get() {
        return mInstance == null ? new MyAppController() : mInstance;
    }

    public static MyAppController create() {
        return MyAppController.get();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //method for login service from login manager
    public LoginService getLoginService() {
        if (loginService == null) {
            LoginManager loginManager = new LoginManager();
            loginService = loginManager.create();
        }
        return loginService;
    }

    //method for profile service from profile manager
    public GetProfileService getProfileService() {
        if (profileService == null) {
            ProfileManager profileManager = new ProfileManager();
            profileService = profileManager.create();
        }
        return profileService;
    }


    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
