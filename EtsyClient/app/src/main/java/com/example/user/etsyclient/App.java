package com.example.user.etsyclient;

import android.app.Application;

import com.example.user.etsyclient.manager.ApiManager;

/**
 * Created by User on 24.12.2016.
 */

public class App extends Application {
    private static ApiManager sApiManager;
    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init();
        }
        return sApiManager;
    }
}
