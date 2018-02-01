package com.coppermobile.coppermobileapp.viewmodel;

import com.coppermobile.coppermobileapp.TestSchedulerProvider;
import com.coppermobile.coppermobileapp.model.LoginRequest;
import com.coppermobile.coppermobileapp.model.LoginResponse;
import com.coppermobile.coppermobileapp.network.apiinterface.LoginService;
import com.coppermobile.coppermobileapp.network.apiinterface.apimanager.LoginManager;
import com.coppermobile.coppermobileapp.view.login.LoginNavigator;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Name: LoginViewModelTest
 * Purpose: test class for login view model
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @Mock
    LoginNavigator mLoginCallback;

    LoginManager mLoginManager;

    @Mock
    LoginService mLoginService;

    private LoginViewModel mLoginViewModel;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginViewModel = new LoginViewModel(testSchedulerProvider);
        mLoginViewModel.setNavigator(mLoginCallback);
    }

    @Test
    public void testServerLoginSuccess() {

        String email = "dummy@gmail.com";
        String password = "password";

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken("dsadsad");
        //loginResponse.setStatusCode(200);

        mLoginManager = Mockito.mock(LoginManager.class);
        when(mLoginManager.create()).thenReturn(mLoginService);

        when(mLoginService.doLogin(new LoginRequest(email, password))).thenReturn(Observable.just(loginResponse));

        mLoginViewModel.login(email, password);

        mTestScheduler.triggerActions();

        verify(mLoginCallback).openProfileActivity();
        verify(mLoginCallback).openProfileActivity();

    }

    @After
    public void tearDown() throws Exception {
    }
}