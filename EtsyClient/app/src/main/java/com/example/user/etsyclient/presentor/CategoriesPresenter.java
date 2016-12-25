package com.example.user.etsyclient.presentor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.user.etsyclient.App;
import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.CategoriesContract;
import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Response;

import java.util.List;

import rx.Subscriber;

/**
 * Created by User on 25.12.2016.
 */

public class CategoriesPresenter implements CategoriesContract.Presenter {
    private CategoriesContract.View mView;

    public void loadCategoriesFromNetwork() {
        if (!isOnline()) {
            mView.onError(mView.getContext().getResources().getString(R.string.connection_absent));
            return;
        }
        App.getApiManager().loadCategories().subscribe(new Subscriber<retrofit2.Response<Response<Category>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(retrofit2.Response<Response<Category>> responseResponse) {
                List<Category> categories = responseResponse.body().getResults();
                mView.onCategoriesLoaded(categories);
            }
        });
    }

    @Override
    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) mView.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    @Override
    public void attachView(CategoriesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
