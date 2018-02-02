package com.coppermobile.coppermobileapp.viewmodel;

import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.coppermobile.coppermobileapp.MyAppController;
import com.coppermobile.coppermobileapp.Utils;
import com.coppermobile.coppermobileapp.model.LoginRequest;
import com.coppermobile.coppermobileapp.model.LoginResponse;
import com.coppermobile.coppermobileapp.network.AppSchedulerProvider;
import com.coppermobile.coppermobileapp.network.SchedulerProvider;
import com.coppermobile.coppermobileapp.network.apiinterface.login.LoginService;
import com.coppermobile.coppermobileapp.view.login.LoginNavigator;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;




    /*
   Name: LoginViewModel
   Purpose: view model for login activity
    */

public class LoginViewModel extends BaseViewModel {

    private final SchedulerProvider mSchedulerProvider;
    private LoginNavigator mNavigator;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private boolean isLoginFailed;


    public LoginViewModel() {
        this(new AppSchedulerProvider());
    }

    LoginViewModel(SchedulerProvider provider) {
        mSchedulerProvider = provider;
    }

    //method for login click
    public void onLoginClick() {
        mNavigator.login();
    }

    //method for email and password validations
    public boolean isEmailAndPasswordValid(String email, String password) {
        //validate email and password
        return !(email == null || email.isEmpty()) && Utils.isEmailValid(email) && !(password == null || password.isEmpty());
    }

    //method for login click and perform service call
    public void login(String email, String password) {

        //create service for login
        MyAppController appController = MyAppController.create();
        LoginService loginService = appController.getLoginService();

        //request with email and password as parameters
        final LoginRequest loginRequest = new LoginRequest(email, password);

        Disposable disposable = loginService.doLogin(loginRequest)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        if (loginResponse != null) {
                            isLoginFailed = false;
                            mNavigator.openProfileActivity();
                        } else {
                            isLoginFailed = true;
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Error", "eee");
                        isLoginFailed = true;
                        notifyChange();
                    }
                });

        compositeDisposable.add(disposable);
    }

    //method for error visibility
    @Bindable
    public int getErrorVisibility() {
        return isLoginFailed ? View.VISIBLE : View.GONE;
    }

    //method for navigator
    public void setNavigator(LoginNavigator mNavigator) {
        this.mNavigator = mNavigator;
    }
}
