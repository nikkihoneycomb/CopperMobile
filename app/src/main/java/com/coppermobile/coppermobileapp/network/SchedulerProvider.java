package com.coppermobile.coppermobileapp.network;

import io.reactivex.Scheduler;

/*
   Name: SchedulerProvider
   Purpose: interface for app scheduler provider
    */
public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
