package com.example.user.etsyclient.presentor;

/**
 * Created by User on 25.12.2016.
 */

public interface BaseMvpPresenter <T> {
    void attachView(T view);
    void detachView();
}
