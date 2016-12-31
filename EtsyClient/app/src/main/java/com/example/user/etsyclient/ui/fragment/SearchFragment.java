package com.example.user.etsyclient.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.CategoriesContract;
import com.example.user.etsyclient.model.Category;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presentor.CategoriesPresenter;
import com.example.user.etsyclient.ui.activity.ProductsListActivity;

import java.util.List;

/**
 * Created by User on 24.12.2016.
 */

public class SearchFragment extends Fragment implements CategoriesContract.View {
    private FloatingActionButton mFab;
    private CategoriesPresenter mCategoriesPresenter;
    private CoordinatorLayout mCoordinatorLayout;
    private List<Category> mCategories;
    private Spinner mSpinner;
    private Context mContext;
    private EditText mKeyWordsET;
    public static final String CATEGORY_EXTRA_KEY = "category";
    public static final String KEYWORD_EXTRA_KEY = "keywords";
    public static final String BUNDLE_EXTRA_KEY = "bundle";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        initViews(view);
        mCategoriesPresenter = new CategoriesPresenter();
        mCategoriesPresenter.attachView(this);
        mCategoriesPresenter.loadCategoriesFromNetwork();
        return view;
    }

    private void initViews(View view) {
        mSpinner = (Spinner) view.findViewById(R.id.spinner);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
        mKeyWordsET = (EditText) view.findViewById(R.id.key_words_edit_text);
        initFab(view);

    }


    private void initFab(View view) {
        mFab = (FloatingActionButton) view.findViewById(R.id.fab_search);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSpinner.getCount() == 0)
                    return;
                startActivity(prepareIntent());

            }
        });
    }

    private Intent prepareIntent() {
        String categoryName = ((Category) mSpinner.getSelectedItem()).getName();
        String keyWord = mKeyWordsET.getText().toString();
        Bundle extras = new Bundle();
        extras.putString(CATEGORY_EXTRA_KEY, categoryName);
        extras.putString(KEYWORD_EXTRA_KEY, keyWord);
        Intent intent = new Intent(mContext, ProductsListActivity.class);
        intent.putExtra(BUNDLE_EXTRA_KEY, extras);
        return intent;
    }

    @Override
    public void onError(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onCategoriesLoaded(List<Category> categories) {
        mCategories = categories;
        ArrayAdapter<Category> arrayAdapter = new ArrayAdapter<Category>(mContext,
                android.R.layout.simple_spinner_item, mCategories);
        mSpinner.setAdapter(arrayAdapter);
    }


    @Override
    public Context getContext() {
        mContext = super.getContext();
        return mContext;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mCategoriesPresenter.detachView();
    }
}
