package com.coppermobile.coppermobileapp.viewmodel;

import android.content.Context;
import android.databinding.Bindable;
import android.util.Log;

import com.coppermobile.coppermobileapp.MyAppController;
import com.coppermobile.coppermobileapp.model.ProfileResponse;
import com.coppermobile.coppermobileapp.network.GetProfileService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


    /*
   Name: Profile View Model
   Purpose: view model for profile activity
   */

public class ProfileViewModel extends BaseViewModel {

    private Context mContext;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ProfileResponse mProfileResponse;

    public ProfileViewModel(Context context) {
        this.mContext = context;
    }

    //method to get profile info
    public void getProfileInfo() {

        //call for profile service
        MyAppController appController = MyAppController.create();
        GetProfileService profileService = appController.getProfileService();

        Disposable disposable = profileService.getProfileInfo()
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProfileResponse>() {
                    @Override
                    public void accept(ProfileResponse profileResponse) throws Exception {
                        // adding dummy success response
                        mProfileResponse = new ProfileResponse("Tarala", "Nikitha", "nik@tara.com");
                        notifyChange();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // adding dummy response
                        mProfileResponse = new ProfileResponse("Tarala", "Nikitha", "nik@tara.com");
                        notifyChange();
                    }
                });

        compositeDisposable.add(disposable);
    }

    //method to fetch first name from profile response
    @Bindable
    public String getFirstName() {
        return mProfileResponse == null ? null : mProfileResponse.getFirstName();
    }

    //method to fetch last name from profile response
    @Bindable
    public String getLastName() {
        return mProfileResponse == null ? null : mProfileResponse.getLastName();
    }

    //method to fetch email frm profile response
    @Bindable
    public String getEmail() {
        return mProfileResponse == null ? null : mProfileResponse.getEmail();
    }
}
