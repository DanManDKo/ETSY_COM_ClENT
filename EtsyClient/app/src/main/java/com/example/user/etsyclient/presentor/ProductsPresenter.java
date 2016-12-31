package com.example.user.etsyclient.presentor;

import com.example.user.etsyclient.App;
import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.ProductsContract;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.model.Response;
import com.example.user.etsyclient.util.Network;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by User on 29.12.2016.
 */

public class ProductsPresenter implements ProductsContract.Presenter {
    private ProductsContract.View mView;
    public static final String CATEGORY = "category";
    public static final String KEY_WORDS = "keywords";
    public static final String PAGE = "page";

    public void loadProductsFromNetwork(String categoryName, String keyWords, Integer page) {
        if (!isOnline()) {
            mView.onError(mView.getContext().getString(R.string.no_connection));
            return;
        }
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(CATEGORY, categoryName);
        queryMap.put(PAGE, page.toString());
        if (keyWords != null && !keyWords.isEmpty())
            queryMap.put(KEY_WORDS, keyWords);
        App.getApiManager().loadProducts(queryMap).subscribe(new Subscriber<retrofit2.Response<Response<Product>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onNext(retrofit2.Response<Response<Product>> responseResponse) {
                List<Product> products = responseResponse.body().getResults();
                if (products == null || products.isEmpty()) {
                    mView.onError(mView.getContext().getString(R.string.bad_request));
                    return;
                }
                mView.onProductsLoaded(products);
            }
        });
    }

    @Override
    public boolean isOnline() {
        return Network.isOnline(mView.getContext());
    }

    @Override
    public void attachView(ProductsContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
