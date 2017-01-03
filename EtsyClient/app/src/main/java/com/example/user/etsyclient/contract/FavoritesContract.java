package com.example.user.etsyclient.contract;

import android.content.Context;

import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presenter.BaseMvpPresenter;

import java.util.List;

/**
 * Created by User on 03.01.2017.
 */

public class FavoritesContract {
    public interface Presenter extends BaseMvpPresenter<FavoritesContract.View> {
        void loadProducts();

    }
    public interface View {


        void onProductsLoaded(List<Product> products);


        Context getContext();

    }
}
