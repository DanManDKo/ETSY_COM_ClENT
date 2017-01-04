package com.example.user.etsyclient.presentor;


import com.example.user.etsyclient.App;
import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.CategoriesContract;
import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Response;
import com.example.user.etsyclient.util.Network;

import java.util.List;

import rx.Subscriber;

/**
 * Created by User on 25.12.2016.
 */

public class CategoriesPresenter implements CategoriesContract.Presenter {
    private CategoriesContract.View mView;

    @Override
    public void loadCategoriesFromNetwork() {
        if (!isOnline()) {
            mView.onError(mView.getContext().getString(R.string.no_connection));
            return;
        }
        App.getApiManager().loadCategories().subscribe(new Subscriber<retrofit2.Response<Response<Category>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onNext(retrofit2.Response<Response<Category>> responseResponse) {
                List<Category> categories = responseResponse.body().getResults();
                if (categories == null || categories.isEmpty()) {
                    mView.onError(mView.getContext().getString(R.string.bad_request));
                    return;
                }
                mView.onCategoriesLoaded(categories);
            }
        });
    }

    public void loadProduct(Category category, String keyWords) {
        if (!isOnline()) {
            mView.onError(mView.getContext().getResources().getString(R.string.no_connection));
            return;
        }
        String correctedKeyWords;
        if (keyWords != null && !keyWords.isEmpty()) {
            correctedKeyWords = keyWords.trim().toLowerCase().replace(' ', '_');
        }
    }

    @Override
    public boolean isOnline() {
        return Network.isOnline(mView.getContext());
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
