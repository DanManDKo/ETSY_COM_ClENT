package com.example.user.etsyclient.contract;

import android.content.Context;

import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presentor.BaseMvpPresenter;
import com.example.user.etsyclient.presentor.ProductsPresenter;

import java.util.List;

/**
 * Created by User on 29.12.2016.
 */

public class ProductsContract {
    public interface Presenter extends BaseMvpPresenter<View> {
        void loadProductsFromNetwork(String categoryName, String keyWords);

        boolean isOnline();
    }
    public interface View {

        void onError(String message);

        void onProductsLoaded(List<Product> products);


        Context getContext();

    }

}
