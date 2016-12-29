package com.example.user.etsyclient.api;

import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.model.Response;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by User on 25.12.2016.
 */

public interface ApiService {
    @GET(ApiSettings.CATEGORY_REQUEST)
    Observable<retrofit2.Response<Response<Category>>> loadCategories(@Query(ApiSettings.API_KEY) String apiKey);

    @GET(ApiSettings.PRODUCT_REQUEST)
    Observable<retrofit2.Response<Response<Product>>> loadProducts(@QueryMap Map<String,String> fieldMap);
}
