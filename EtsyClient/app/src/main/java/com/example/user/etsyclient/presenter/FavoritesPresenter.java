package com.example.user.etsyclient.presenter;

import android.content.Context;

import com.example.user.etsyclient.contract.FavoritesContract;
import com.example.user.etsyclient.manager.FavoritesManager;


/**
 * Created by User on 03.01.2017.
 */

public class FavoritesPresenter implements FavoritesContract.Presenter {
    private FavoritesContract.View mView;
    private Context mContext;
    private FavoritesManager mFavoritesManager;


    public void loadProducts() {
        mView.onProductsLoaded(mFavoritesManager.getProducts());
    }

    public void commitData() {
        mFavoritesManager.commitData();
    }

    @Override
    public void attachView(FavoritesContract.View view) {
        mView = view;
        mContext = view.getContext();
        mFavoritesManager = new FavoritesManager(mContext);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
