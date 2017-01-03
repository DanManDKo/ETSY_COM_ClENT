package com.example.user.etsyclient;

import android.app.Application;
import android.content.Context;

import com.example.user.etsyclient.manager.ApiManager;
import com.example.user.etsyclient.manager.DbManager;
import com.example.user.etsyclient.manager.FavoritesManager;

/**
 * Created by User on 24.12.2016.
 */

public class App extends Application {
    private static ApiManager sApiManager;
    private static DbManager sDbManager;
    private static FavoritesManager sFavoritesManager;

    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init();
        }
        return sApiManager;
    }

    public static DbManager getDbManager(Context context) {
        if (sDbManager == null)
            sDbManager = new DbManager(context);
        return sDbManager;
    }

    public static FavoritesManager getFavoritesManager(Context context) {
        if (sFavoritesManager == null) {
            sFavoritesManager = new FavoritesManager(context);
        }
        return sFavoritesManager;
    }
}
