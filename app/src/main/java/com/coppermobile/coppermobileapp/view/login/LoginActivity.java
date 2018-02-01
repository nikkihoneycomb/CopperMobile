package com.coppermobile.coppermobileapp.view.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.coppermobile.coppermobileapp.R;
import com.coppermobile.coppermobileapp.databinding.ActivityLoginBinding;
import com.coppermobile.coppermobileapp.view.base.BaseActivity;
import com.coppermobile.coppermobileapp.view.profile.ProfileActivity;
import com.coppermobile.coppermobileapp.viewmodel.LoginViewModel;

/*
   Name: LoginActivity
   Purpose: class login activity to extend base activity and implement navigator
    */
public class LoginActivity extends BaseActivity implements LoginNavigator {
    ActivityLoginBinding mLoginActivityBinding;
    LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mLoginViewModel = new LoginViewModel();
        mLoginViewModel.setNavigator(this);
        mLoginActivityBinding.setViewModel(mLoginViewModel);

    }

    //method to navigate to profile screen
    @Override
    public void openProfileActivity() {
        startActivity(new Intent(this.getApplicationContext(), ProfileActivity.class));
    }

    //method to validate email and password
    @Override
    public void login() {
        String email = mLoginActivityBinding.etEmail.getText().toString().trim();
        String password = mLoginActivityBinding.etPassword.getText().toString().trim();

        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            mLoginViewModel.login(email, password);
        } else {
            Toast.makeText(this, "Please enter valid Email and Password", Toast.LENGTH_SHORT).show();
        }

    }

}
