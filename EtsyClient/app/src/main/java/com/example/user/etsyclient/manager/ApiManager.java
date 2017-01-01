package com.example.user.etsyclient.manager;

import com.example.user.etsyclient.api.ApiService;
import com.example.user.etsyclient.api.ApiSettings;
import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.model.Response;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 25.12.2016.
 */

public class ApiManager {
    private Retrofit mRetrofit;
    private ApiService mApiService;

    public void init() {
        initRetrofit();
        initServices();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiSettings.SERVER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .build();
    }

    private void initServices() {
        mApiService = mRetrofit.create(ApiService.class);
    }

    private GsonConverterFactory createGsonConverter() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        return GsonConverterFactory.create(builder.create());
    }

    public Observable<retrofit2.Response<Response<Category>>> loadCategories() {
        return mApiService.loadCategories(ApiSettings.ETSY_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<retrofit2.Response<Response<Product>>> loadProducts(Map<String, String> queryMap) {
        queryMap.put(ApiSettings.API_KEY, ApiSettings.ETSY_API_KEY);
        queryMap.put(ApiSettings.INCLUDES, ApiSettings.IMAGES);
        return mApiService.loadProducts(queryMap).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
