package com.example.user.etsyclient.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.ProductsContract;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presentor.ProductsPresenter;
import com.example.user.etsyclient.ui.adapter.ProductsAdapter;
import com.example.user.etsyclient.ui.fragment.SearchFragment;

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
    private List<Product> mProducts;
    private ProgressBar mProgressBar;
    private ProductsAdapter mAdapter;
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
        mPresenter.loadProductsFromNetwork(mCategoryName, mKeyWords);

    }

    private void initViews() {
        initToolbar();
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }

    private void initRecycler() {
        mRecyclerView = (RecyclerView) findViewById(R.id.products_recycler);
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter = new ProductsAdapter(mProducts);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_products_list);
        mToolbar.setTitle(R.string.products_list);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onProductsLoaded(List<Product> products) {
        mProducts = products;
        mProgressBar.setVisibility(View.GONE);
        initRecycler();
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

    }
}
