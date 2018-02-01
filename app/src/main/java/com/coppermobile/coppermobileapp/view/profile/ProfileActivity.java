package com.coppermobile.coppermobileapp.view.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.coppermobile.coppermobileapp.R;
import com.coppermobile.coppermobileapp.databinding.ActivityProfileBinding;
import com.coppermobile.coppermobileapp.view.base.BaseActivity;
import com.coppermobile.coppermobileapp.viewmodel.ProfileViewModel;


/*
   Name: Profile Activity
   Purpose: profile screen with details like name, email and lastname
    */
public class ProfileActivity extends BaseActivity {
    ActivityProfileBinding mProfileActivityBinding;
    ProfileViewModel mProfileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        mProfileViewModel = new ProfileViewModel(ProfileActivity.this);
        mProfileActivityBinding.setViewModel(mProfileViewModel);

        //get profile info
        mProfileViewModel.getProfileInfo();
    }


}
