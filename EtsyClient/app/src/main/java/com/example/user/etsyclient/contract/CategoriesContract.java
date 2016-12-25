package com.example.user.etsyclient.contract;

import android.content.Context;

import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.presentor.BaseMvpPresenter;

import java.util.List;

/**
 * Created by User on 25.12.2016.
 */

public class CategoriesContract {

    public interface Presenter extends BaseMvpPresenter<View> {
        void loadCategoriesFromNetwork();

        boolean isOnline();
    }

    public interface View {
        void onError(String message);

        void onCategoriesLoaded(List<Category> categories);
        Context getContext();
    }
}
