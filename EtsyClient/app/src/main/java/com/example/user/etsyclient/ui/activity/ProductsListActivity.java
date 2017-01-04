package com.example.user.etsyclient.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ProgressBar;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.castoms.EndlessRecyclerViewScrollListener;
import com.example.user.etsyclient.contract.ProductsContract;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presentor.ProductsPresenter;
import com.example.user.etsyclient.ui.adapter.ProductsAdapter;
import com.example.user.etsyclient.ui.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 29.12.2016.
 */

public class ProductsListActivity extends AppCompatActivity implements ProductsContract.View, ProductsAdapter.OnProductClickCallBack {
    private String mCategoryName;
    private String mKeyWords;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ProductsPresenter mPresenter;
    private List<Product> mProducts = new ArrayList<>();
    private ProgressBar mProgressBar;
    private ProductsAdapter mAdapter;
    private final int FIRST_PAGE = 1;
    private final int SPAN_WIDTH = 100;
    public static final String PRODUCT_EXTRA_KEY = "product";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_list_activity);
        Bundle bundle = getIntent().getBundleExtra(SearchFragment.BUNDLE_EXTRA_KEY);
        mCategoryName = bundle.getString(SearchFragment.CATEGORY_EXTRA_KEY);
        mKeyWords = bundle.getString(SearchFragment.KEYWORD_EXTRA_KEY);
        mPresenter = new ProductsPresenter();
        mPresenter.attachView(this);
        initViews();
        mPresenter.loadProductsFromNetwork(mCategoryName, mKeyWords, FIRST_PAGE);

    }

    private void initViews() {
        initToolbar();
        initRecycler();
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }

    private void initRecycler() {
        mRecyclerView = (RecyclerView) findViewById(R.id.products_recycler);
        mAdapter = new ProductsAdapter(mProducts);
        mAdapter.setOnClickCallBack(this);
        mRecyclerView.setAdapter(mAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, calculateSpanCount());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                showSnackbar(getString(R.string.loading));
                mPresenter.loadProductsFromNetwork(mCategoryName, mKeyWords, page);
            }
        });

    }

    private void showSnackbar(String str) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.products_list_layout), str, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    private int calculateSpanCount() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;
        return (int) dpWidth / SPAN_WIDTH;
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_products_list);
        mToolbar.setTitle(R.string.products_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onError(String message) {
        showSnackbar(message);
    }

    @Override
    public void onProductsLoaded(List<Product> products) {
        mProducts.addAll(products);
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onItemClick(Product product) {
        Intent intent = new Intent(this,DetailProductActivity.class);
        intent.putExtra(PRODUCT_EXTRA_KEY,product);
        startActivity(intent);
    }
}
