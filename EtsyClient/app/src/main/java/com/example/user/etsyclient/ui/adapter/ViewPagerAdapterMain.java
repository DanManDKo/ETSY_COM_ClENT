package com.example.user.etsyclient.ui.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.etsyclient.R;

import java.util.List;

/**
 * Created by User on 24.12.2016.
 */

public class ViewPagerAdapterMain extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private Context mContext;

    public ViewPagerAdapterMain(FragmentManager fm, @NonNull List<Fragment> fragments, Context context) {
        super(fm);
        mFragments = fragments;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return mContext.getResources().getString(R.string.search);
        return mContext.getResources().getString(R.string.favorites);
    }
}
