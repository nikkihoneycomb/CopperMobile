package com.coppermobile.coppermobileapp.network;

import android.database.Observable;

import com.coppermobile.coppermobileapp.model.ProfileResponse;

import retrofit2.http.GET;

/*
   Name: GetProfileService
   Purpose: interface for GetProfileService to add calls annotated with @POST, @GET etc., by passing request as parameter
    */
public interface GetProfileService {

    @GET("api/getprofile")
    Observable<ProfileResponse> getProfileInfo();
}
