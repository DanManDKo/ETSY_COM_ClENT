package com.example.user.etsyclient.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.user.etsyclient.db.DbContract;
import com.example.user.etsyclient.db.DbHandler;
import com.example.user.etsyclient.db.DbHelper;
import com.example.user.etsyclient.model.Image;
import com.example.user.etsyclient.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02.01.2017.
 */

public class DbManager implements DbHandler {
    private DbHelper mDbHelper;
    private SQLiteDatabase mDatabase;
    Cursor mCursor;
    private final String ERROR_TAG = "sqlite";

    public DbManager(Context context) {
        mDbHelper = new DbHelper(context);

    }

    @Override
    public List<Product> getAllProducts() {
        try {
            mDatabase = mDbHelper.getWritableDatabase();
            mCursor = mDatabase.query(DbContract.ProductsHelper.TABLE_PRODUCTS,
                    null, null, null, null, null, null);
            List<Product> products = new ArrayList<>();
            if (mCursor.moveToFirst()) {
                do {
                    products.add(getProduct(mCursor));
                } while (mCursor.moveToNext());

            }

            return products;
        } catch (SQLException ex) {
            Log.e(ERROR_TAG, ex.getMessage());
        } finally {
            if (mCursor != null)
                mCursor.close();
            if (mDbHelper != null)
                mDbHelper.close();
        }
        return null;
    }

    private List<Image> getImagesOfCurrentProduct(long productId) {
        try {
            mDatabase = mDbHelper.getReadableDatabase();
            List<Image> images = new ArrayList<>();
            String query = Long.toString(productId);
            mCursor = mDatabase.query(DbContract.ImagesHelper.TABLE_IMAGES, null,
                    DbContract.ImagesHelper.COLUMN_PRODUCT_ID + " = ?",
                    new String[]{query},
                    null,
                    null,
                    null
            );
            if (mCursor.moveToFirst()) {
                do {
                    images.add(getImage(mCursor));
                } while (mCursor.moveToNext());
            }
            return images;
        } catch (SQLException ex) {
            Log.e(ERROR_TAG, ex.getMessage());
        } finally {
            if (mCursor != null)
                mCursor.close();
            if (mDbHelper != null)
                mDbHelper.close();

        }
        return null;
    }

    private Image getImage(Cursor cursor) throws SQLException {
        Image image = new Image();
        image.setImageId(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_IMAGE_ID)));
        image.setHexCode(cursor.getString(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_IMAGE_ID)));
        image.setRed(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_RED)));
        image.setGreen(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_GREEN)));
        image.setBlue(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_BLUE)));
        image.setHue(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_HUE)));
        image.setSaturation(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_SATURATION)));
        image.setBrightness(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_BRIGHTNESS)));
        image.setBrightness(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_BRIGHTNESS)));
        image.setBlackAndWhite(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_BRIGHTNESS)) == 1 ? true : false);
        image.setCreationTsz(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_CREATION_TSZ)));
        image.setProductId(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_PRODUCT_ID)));
        image.setRank(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_RANK)));
        image.setRank(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_RANK)));
        image.setUrl75x75(cursor.getString(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_URL_75x75)));
        image.setUrl170x135(cursor.getString(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_URL_170x135)));
        image.setUrl570xN(cursor.getString(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_URL_570xN)));
        image.setUrlFullxFull(cursor.getString(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_URL_FULLxFULL)));
        image.setFullHeight(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_FULL_HEIGHT)));
        image.setFullWidth(cursor.getInt(cursor.getColumnIndex(DbContract.ImagesHelper.COLUMN_FULL_WIDTH)));

        return image;
    }

    private Product getProduct(Cursor cursor) throws SQLException {
        Product product = new Product();

        product.setProductId(cursor.getInt(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_PRODUCT_ID)));
        product.setState(cursor.getString(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_STATE)));
        product.setCategoryId(cursor.getInt(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_CATEGORY_ID)));
        product.setTitle(cursor.getString(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_TITLE)));
        product.setDescription(cursor.getString(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_DESCRIPTION)));
        product.setPrice(cursor.getDouble(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_PRICE)));
        product.setCurrencyCode(cursor.getString(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_CURRENCY_CODE)));
        product.setQuantity(cursor.getInt(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_QUANTITY)));
        product.setItemWeight(cursor.getInt(cursor.getColumnIndex(DbContract.ProductsHelper.COLUMN_ITEM_WEIGHT)));
        product.setImages(getImagesOfCurrentProduct(product.getProductId()));

        return product;
    }

    @Override
    public long addProduct(Product product) throws SQLException {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DbContract.ProductsHelper.COLUMN_PRODUCT_ID, (int) product.getProductId());
        contentValues.put(DbContract.ProductsHelper.COLUMN_STATE, product.getState());
        contentValues.put(DbContract.ProductsHelper.COLUMN_CATEGORY_ID, (int) product.getCategoryId());
        contentValues.put(DbContract.ProductsHelper.COLUMN_TITLE, product.getTitle());
        contentValues.put(DbContract.ProductsHelper.COLUMN_DESCRIPTION, product.getDescription());
        contentValues.put(DbContract.ProductsHelper.COLUMN_PRICE, product.getPrice());
        contentValues.put(DbContract.ProductsHelper.COLUMN_CURRENCY_CODE, product.getCurrencyCode());
        contentValues.put(DbContract.ProductsHelper.COLUMN_QUANTITY, product.getQuantity());
        contentValues.put(DbContract.ProductsHelper.COLUMN_ITEM_WEIGHT, product.getItemWeight());

        long rowNumber = mDatabase.insert(DbContract.ProductsHelper.TABLE_PRODUCTS, null, contentValues);
        addImages(product.getImages());
        return rowNumber;
    }

    private synchronized void addImages(List<Image> images) throws SQLException {
        ContentValues contentValues;
        for (Image image : images) {
            contentValues = new ContentValues();

            contentValues.put(DbContract.ImagesHelper.COLUMN_IMAGE_ID, (int) image.getImageId());
            contentValues.put(DbContract.ImagesHelper.COLUMN_PRODUCT_ID, (int) image.getProductId());
            contentValues.put(DbContract.ImagesHelper.COLUMN_HEX_CODE, image.getHexCode());
            contentValues.put(DbContract.ImagesHelper.COLUMN_RED, image.getRed());
            contentValues.put(DbContract.ImagesHelper.COLUMN_GREEN, image.getGreen());
            contentValues.put(DbContract.ImagesHelper.COLUMN_BLUE, image.getBlue());
            contentValues.put(DbContract.ImagesHelper.COLUMN_HUE, image.getHue());
            contentValues.put(DbContract.ImagesHelper.COLUMN_SATURATION, image.getSaturation());
            contentValues.put(DbContract.ImagesHelper.COLUMN_BRIGHTNESS, image.getBrightness());
            contentValues.put(DbContract.ImagesHelper.COLUMN_IS_BLACK_AND_WHITE, image.getBlackAndWhite() ? 1 : 0);
            contentValues.put(DbContract.ImagesHelper.COLUMN_CREATION_TSZ, image.getCreationTsz());
            contentValues.put(DbContract.ImagesHelper.COLUMN_RANK, image.getRank());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_75x75, image.getUrl75x75());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_170x135, image.getUrl170x135());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_570xN, image.getUrl570xN());
            contentValues.put(DbContract.ImagesHelper.COLUMN_URL_FULLxFULL, image.getUrlFullxFull());
            contentValues.put(DbContract.ImagesHelper.COLUMN_FULL_HEIGHT, image.getFullHeight());
            contentValues.put(DbContract.ImagesHelper.COLUMN_FULL_WIDTH, image.getFullWidth());
            mDatabase.insert(DbContract.ImagesHelper.TABLE_IMAGES, null, contentValues);
        }


    }


}
