package com.coppermobile.coppermobileapp.network.apiinterface.apimanager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/*
   Name: NetworkManager
   Purpose: network layer with HTTP layer using Retrofit and GSON converter
        */
public abstract class NetworkManager {

    protected Retrofit retrofit;

    //constructor with base url and client as http
    public NetworkManager() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .client(getHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //GSON for converting JSON to java objects
    protected Gson getGson() {
        return new GsonBuilder()
                .serializeNulls()
                .create();
    }

    //http client with logging interceptor
    protected OkHttpClient getHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(5);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                .dispatcher(dispatcher)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        return builder.build();
    }
}
