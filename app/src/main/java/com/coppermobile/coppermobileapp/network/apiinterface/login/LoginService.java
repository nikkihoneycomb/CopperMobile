package com.coppermobile.coppermobileapp.network.apiinterface.login;



import com.coppermobile.coppermobileapp.model.LoginRequest;
import com.coppermobile.coppermobileapp.model.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/*
   Name: LoginService
   Purpose: interface for loginservice to add calls annotated with @POST, @GET etc., by passing request as parameter
    */
public interface LoginService {

    @POST("api/login")
    Observable<LoginResponse> doLogin(@Body LoginRequest loginRequest);
}
