package com.example.user.etsyclient.manager;

import android.content.Context;

import com.example.user.etsyclient.App;
import com.example.user.etsyclient.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.01.2017.
 */

public class FavoritesManager {
    private List<Product> mProducts;
    private DbManager mDbManager;

    public FavoritesManager(Context context) {
        mDbManager = App.getDbManager(context);
    }

    public List<Product> getProducts() {
        if (mProducts == null || mProducts.isEmpty())
            mProducts = mDbManager.getAllProducts();
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
}
