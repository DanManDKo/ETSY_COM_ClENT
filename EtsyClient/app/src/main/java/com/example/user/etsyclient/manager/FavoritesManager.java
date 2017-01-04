package com.example.user.etsyclient.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user.etsyclient.App;
import com.example.user.etsyclient.model.Product;

import java.util.List;

/**
 * Created by User on 03.01.2017.
 */

public class FavoritesManager {
    private List<Product> mProducts;
    private DbManager mDbManager;
    private final String ERROR_TAG = "FavoriteManager";

    public FavoritesManager(Context context) {
        mDbManager = App.getDbManager(context);
        GetAllDataTask getData = new GetAllDataTask();
        try {
            getData.execute();
            mProducts = getData.get();
        } catch (Exception ex) {
            Log.e(ERROR_TAG, ex.getMessage());
        }
    }

    public List<Product> getProducts() {

        return mProducts;
    }

    public void addProduct(Product product) {
        mProducts.add(product);
    }

    public void removeProduct(Product product) {
        mProducts.remove(product);
    }

    public void commitData() {
        mDbManager.deleteAll();
        mDbManager.addAllProducts(mProducts);
    }

    public boolean isFavorite(Product product) {
        if (mProducts != null)
            return mProducts.contains(product);
        return false;
    }

    private class GetAllDataTask extends AsyncTask<Void, Void, List<Product>> {

        @Override
        protected List<Product> doInBackground(Void... params) {
            return mDbManager.getAllProducts();
        }
    }
}
