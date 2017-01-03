package com.example.user.etsyclient.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.contract.FavoritesContract;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.presenter.FavoritesPresenter;
import com.example.user.etsyclient.ui.activity.DetailProductActivity;
import com.example.user.etsyclient.ui.activity.ProductsListActivity;
import com.example.user.etsyclient.ui.adapter.ProductsAdapter;

import java.util.List;

/**
 * Created by User on 24.12.2016.
 */

public class FavoritesListFragment extends Fragment implements ProductsAdapter.OnProductClickCallBack, FavoritesContract.View {
    private RecyclerView mRecyclerView;
    private ProductsAdapter mAdapter;
    private Context mContext;
    private FavoritesPresenter mPresenter;
    private List<Product> mProducts;
    private final int SPAN_WIDTH = 100;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorites_list_fragment, container, false);
        mContext = getContext();
        mPresenter = new FavoritesPresenter();
        mPresenter.attachView(this);
        initViews(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadProducts();
        mAdapter.notifyDataSetChanged();
    }

    private void initAdapter() {
        mAdapter = new ProductsAdapter(mProducts);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, calculateSpanCount()));
        mAdapter.setOnClickCallBack(this);
    }


    private void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.favorite_recycler_view);
    }

    private int calculateSpanCount() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;
        return (int) dpWidth / SPAN_WIDTH;
    }

    @Override
    public void onItemClick(Product product) {
        Intent intent = new Intent(mContext, DetailProductActivity.class);
        intent.putExtra(ProductsListActivity.PRODUCT_EXTRA_KEY, product);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.commitData();
    }

    @Override
    public void onProductsLoaded(List<Product> products) {
        mProducts = products;
        if (mProducts != null)
            initAdapter();
    }
}
