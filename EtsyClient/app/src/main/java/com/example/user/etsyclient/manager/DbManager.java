package com.example.user.etsyclient.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.etsyclient.db.DbContract;
import com.example.user.etsyclient.db.DbHandler;
import com.example.user.etsyclient.db.DbHelper;
import com.example.user.etsyclient.model.Image;
import com.example.user.etsyclient.model.Product;

import java.util.List;

/**
 * Created by User on 02.01.2017.
 */

public class DbManager implements DbHandler {
    private DbHelper mDbHelper;
    private SQLiteDatabase mDatabase;

    public DbManager(Context context) {
        mDbHelper = new DbHelper(context);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public long addProduct(Product product) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.ProductsHelper.COLUMN_PRODUCT_ID, Integer.parseInt(product.getProductId()));
        contentValues.put(DbContract.ProductsHelper.COLUMN_STATE, product.getState());
        contentValues.put(DbContract.ProductsHelper.COLUMN_CATEGORY_ID, Integer.parseInt(product.getCategoryId()));
        contentValues.put(DbContract.ProductsHelper.COLUMN_TITLE, product.getTitle());
        contentValues.put(DbContract.ProductsHelper.COLUMN_DESCRIPTION, product.getDescription());
        contentValues.put(DbContract.ProductsHelper.COLUMN_PRICE, Double.parseDouble(product.getPrice()));
        contentValues.put(DbContract.ProductsHelper.COLUMN_CURRENCY_CODE, product.getCurrencyCode());
        if (product.getQuantity() != null)
            contentValues.put(DbContract.ProductsHelper.COLUMN_QUANTITY, Integer.parseInt(product.getQuantity()));
        if (product.getItemWeight() != null)
            contentValues.put(DbContract.ProductsHelper.COLUMN_ITEM_WEIGHT, Double.parseDouble(product.getItemWeight()));
        return mDatabase.insert(DbContract.ProductsHelper.TABLE_PRODUCTS, null, contentValues);
    }

    @Override
    public boolean isFavorite(Product product) {
        return false;
    }

    @Override
    public List<Image> getImages(Product product) {
        return null;
    }
}
