package com.example.user.etsyclient.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 02.01.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, DbContract.DATABASE_NAME, null, DbContract.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL(DbContract.ProductsHelper.CREATE_PRODUCTS_TABLE);
            db.execSQL(DbContract.ImagesHelper.CREATE_IMAGE_TABLE);
        }catch (Exception ex){
            Log.e("db",ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(DbContract.DROP_PRODUCT_TABLE);
            db.execSQL(DbContract.DROP_IMAGE_TABLE);
            onCreate(db);
        }
    }
}
