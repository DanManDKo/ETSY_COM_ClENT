package com.example.user.etsyclient.db;

import android.provider.BaseColumns;

/**
 * Created by User on 02.01.2017.
 */

public final class DbContract {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "favorites.db";
    private static String CREATE_TABLE = "CREATE TABLE ";
    private static String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT,";
    public static final String DROP_PRODUCT_TABLE = "DROP TABLE IF EXISTS " + ProductsHelper.TABLE_PRODUCTS;
    public static final String DROP_IMAGE_TABLE = "DROP TABLE IF EXISTS " + ImagesHelper.TABLE_IMAGES;


    public static final class ProductsHelper implements BaseColumns {
        private static final String COLUMN_ID = "_id";
        public static final String TABLE_PRODUCTS = "products";
        public static final String COLUMN_PRODUCT_ID = "productId";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_CATEGORY_ID = "categoryId";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_CURRENCY_CODE = "currencyCode";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_ITEM_WEIGHT = "itemWeight";

        public static final String CREATE_PRODUCTS_TABLE = CREATE_TABLE + TABLE_PRODUCTS +
                " (" +
                COLUMN_ID + PRIMARY_KEY +
                COLUMN_PRODUCT_ID + " INTEGER," +
                COLUMN_STATE + " TEXT," +
                COLUMN_CATEGORY_ID + " INTEGER," +
                COLUMN_TITLE + " TEXT," +
                COLUMN_DESCRIPTION + " TEXT," +
                COLUMN_PRICE + " REAL," +
                COLUMN_CURRENCY_CODE + " TEXT," +
                COLUMN_QUANTITY + " INTEGER," +
                COLUMN_ITEM_WEIGHT + " REAL" +
                " )";
    }

    public static final class ImagesHelper {
        private static final String COLUMN_ID = "_id";
        public static final String TABLE_IMAGES = "images";
        public static final String COLUMN_IMAGE_ID = "imageId";
        public static final String COLUMN_HEX_CODE = "hexCode";
        public static final String COLUMN_RED = "red";
        public static final String COLUMN_GREEN = "green";
        public static final String COLUMN_BLUE = "blue";
        public static final String COLUMN_HUE = "hue";
        public static final String COLUMN_SATURATION = "saturation";
        public static final String COLUMN_BRIGHTNESS = "brightness";
        public static final String COLUMN_IS_BLACK_AND_WHITE = "isBlackAndWhite";
        public static final String COLUMN_CREATION_TSZ = "creationTsz";
        public static final String COLUMN_PRODUCT_ID = "productId";
        public static final String COLUMN_RANK = "rank";
        public static final String COLUMN_URL_75x75 = "url75x75";
        public static final String COLUMN_URL_170x135 = "url170x135";
        public static final String COLUMN_URL_570xN = "url570xN";
        public static final String COLUMN_URL_FULLxFULL = "urlFullxFull";
        public static final String COLUMN_FULL_HEIGHT = "fullHeight";
        public static final String COLUMN_FULL_WIDTH = "fullWidth";

        public static String CREATE_IMAGE_TABLE = CREATE_TABLE + TABLE_IMAGES +
                " (" +
                COLUMN_ID + PRIMARY_KEY +
                COLUMN_IMAGE_ID + " INTEGER," +
                COLUMN_HEX_CODE + " TEXT," +
                COLUMN_RED + " INTEGER," +
                COLUMN_GREEN + " INTEGER," +
                COLUMN_BLUE + " INTEGER," +
                COLUMN_HUE + " INTEGER," +
                COLUMN_SATURATION + " INTEGER," +
                COLUMN_BRIGHTNESS + " INTEGER," +
                COLUMN_IS_BLACK_AND_WHITE + " INTEGER," +
                COLUMN_CREATION_TSZ + " INTEGER," +
                COLUMN_PRODUCT_ID + " INTEGER," +
                COLUMN_RANK + " INTEGER," +
                COLUMN_URL_75x75 + " TEXT," +
                COLUMN_URL_170x135 + " TEXT," +
                COLUMN_URL_570xN + " TEXT," +
                COLUMN_URL_FULLxFULL + " TEXT," +
                COLUMN_FULL_HEIGHT + " INTEGER," +
                COLUMN_FULL_WIDTH + " INTEGER" +
                " )";

    }
}
