package com.example.user.etsyclient.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.model.Image;
import com.example.user.etsyclient.ui.adapter.ImageAdapter;

import java.util.ArrayList;

/**
 * Created by User on 01.01.2017.
 */

public class GalleryActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ArrayList<Image> mImages;
    private int mCurentPosition;
    private final int DEFAULT_VALUE = 0;
    private final int PAGE_LIMIT = 1;
    private ViewPager mViewPager;
    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        mImages = getIntent().getParcelableArrayListExtra(DetailProductActivity.IMAGES);
        mCurentPosition = getIntent().getIntExtra(DetailProductActivity.POSITION, DEFAULT_VALUE);
        initViews();

    }

    private void initViews() {
        initToolbar();
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.pager_gallery);
        mViewPager.setOffscreenPageLimit(PAGE_LIMIT);
        mImageAdapter = new ImageAdapter();
        mImageAdapter.setItem(R.layout.item_view_pager_fit_center);
        mImageAdapter.addViews(mImages);
        mViewPager.setAdapter(mImageAdapter);
        mViewPager.setCurrentItem(mCurentPosition);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_gallery);
        mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.gallery);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home):
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
