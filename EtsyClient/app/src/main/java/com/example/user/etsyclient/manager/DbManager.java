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
        long rowNumber = mDatabase.insert(DbContract.ProductsHelper.TABLE_PRODUCTS, null, contentValues);
        addImages(product.getImages());
        return rowNumber;
    }

    private void addImages(List<Image> images) {
        ContentValues contentValues;
        for (Image image : images) {
            contentValues = new ContentValues();
            contentValues.put(DbContract.ImagesHelper.COLUMN_IMAGE_ID, Integer.parseInt(image.getImageId()));
            if (image.getHexCode() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_HEX_CODE, image.getHexCode());
            if (image.getRed() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_RED, Integer.parseInt(image.getRed()));
            if (image.getGreen() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_GREEN, Integer.parseInt(image.getGreen()));
            if (image.getBlue() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_BLUE, Integer.parseInt(image.getBlue()));
            if (image.getHue() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_HUE, Integer.parseInt(image.getHue()));
            if (image.getSaturation() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_SATURATION, Integer.parseInt(image.getSaturation()));
            if (image.getBrightness() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_BRIGHTNESS, Integer.parseInt(image.getBrightness()));
            contentValues.put(DbContract.ImagesHelper.COLUMN_IS_BLACK_AND_WHITE, "true".equals(image.getBlackAndWhite()) ? 1 : 0);
            if (image.getCreationTsz() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_CREATION_TSZ, Integer.parseInt(image.getCreationTsz()));
            if (image.getRank() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_RANK, Integer.parseInt(image.getRank()));
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_75x75, image.getUrl75x75());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_170x135, image.getUrl170x135());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_570xN, image.getUrl570xN());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_FULLxFULL, image.getUrlFullxFull());
            if (image.getFullHeight() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_FULL_HEIGHT, Integer.parseInt(image.getFullHeight()));
            if (image.getFullWidth() != null)
                contentValues.put(DbContract.ImagesHelper.COLUMN_FULL_WIDTH, Integer.parseInt(image.getFullWidth()));
            mDatabase.insert(DbContract.ImagesHelper.TABLE_IMAGES, null, contentValues);
        }


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
