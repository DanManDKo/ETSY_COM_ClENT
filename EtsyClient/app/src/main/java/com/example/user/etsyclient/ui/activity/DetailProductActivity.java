package com.example.user.etsyclient.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.ParseException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.etsyclient.App;
import com.example.user.etsyclient.R;
import com.example.user.etsyclient.manager.DbManager;
import com.example.user.etsyclient.model.Image;
import com.example.user.etsyclient.model.Product;
import com.example.user.etsyclient.ui.adapter.ImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

/**
 * Created by User on 01.01.2017.
 */

public class DetailProductActivity extends AppCompatActivity implements ImageAdapter.OnItemClickCallBack {
    private DbManager mDbManager;
    private Product mProduct;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private ImageView mFavoriteImageView;
    private TextView mTitle;
    private TextView mDescription;
    private TextView mPrice;
    private TextView mCurrencyCode;
    private ImageAdapter mImageAdapter;
    private CirclePageIndicator mCirclePageIndicator;
    private final String ERROR_TAG = "DetailProduct";
    private final int OFF_SCREEN_PAGE_LIMIT = 1;
    public static final String POSITION = "position";
    public static final String IMAGES = "images";
    private static final int FIRST_IMAGE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product_activity);
        mProduct = getIntent().getParcelableExtra(ProductsListActivity.PRODUCT_EXTRA_KEY);
        mDbManager = App.getDbManager(this);
        initViews();

    }

    private void initViews() {
        initToolbar();
        initViewPager();
        initFavorite();
        mTitle = (TextView) findViewById(R.id.tv_title);
        mPrice = (TextView) findViewById(R.id.tv_price);
        mCurrencyCode = (TextView) findViewById(R.id.tv_currency_code);
        mDescription = (TextView) findViewById(R.id.tv_description);
        mTitle.setText(mProduct.getTitle());
        mPrice.setText(Double.toString(mProduct.getPrice()));
        mCurrencyCode.setText(mProduct.getCurrencyCode());
        mDescription.setText(mProduct.getDescription());

    }

    private void initFavorite() {
        mFavoriteImageView = (ImageView) findViewById(R.id.iv_favorite);
        mFavoriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDbManager.addProduct(mProduct);
                mDbManager.getAllProducts();
            }
        });
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);
        mViewPager.setOffscreenPageLimit(OFF_SCREEN_PAGE_LIMIT);
        mImageAdapter = new ImageAdapter();
        mImageAdapter.setItem(R.layout.item_view_pager_center_crop);
        mImageAdapter.addViews(mProduct.getImages());
        mImageAdapter.setOnItemClickCallBack(this);
        mViewPager.setAdapter(mImageAdapter);
        mCirclePageIndicator.setViewPager(mViewPager);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_product);
        Image image;
        if (mProduct != null && mProduct.getImages() != null && !mProduct.getImages().isEmpty()) {
            try {
                image = mProduct.getImages().get(FIRST_IMAGE);
                int colorOfToolbar = Color.rgb(
                        image.getRed(),
                        image.getGreen(),
                        image.getBlue());
                mToolbar.setBackgroundColor(colorOfToolbar);
            } catch (ParseException ex) {
                Log.e(ERROR_TAG, ex.getMessage());
            }
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.detail_product_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home):
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, GalleryActivity.class);
        ArrayList<Image> images = (ArrayList<Image>) mProduct.getImages();
        intent.putParcelableArrayListExtra(IMAGES, images);
        intent.putExtra(POSITION, position);
        startActivity(intent);
    }
}
