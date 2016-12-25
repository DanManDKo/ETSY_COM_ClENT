package com.example.user.etsyclient.api;

import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by User on 25.12.2016.
 */

public interface ApiService {
    @GET(ApiSettings.CATEGORY_REQUEST)
    Observable<retrofit2.Response<Response<Category>>> loadCategories(@Query(ApiSettings.API_KEY) String apiKey);
}
