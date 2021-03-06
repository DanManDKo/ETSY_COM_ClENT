package com.example.user.etsyclient.ui.adapter;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 01.01.2017.
 */

public class ImageAdapter extends PagerAdapter {
    private List<Image> mImages;
    private OnItemClickCallBack mOnItemClickCallBack;
    private int item;
    public void addViews(List<Image> images) {
        mImages = images;
        notifyDataSetChanged();
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setOnItemClickCallBack(OnItemClickCallBack mOnItemClickCallBack) {
        this.mOnItemClickCallBack = mOnItemClickCallBack;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_item_view_pager);
        Picasso.with(container.getContext()).load(mImages.get(position).getUrlFullxFull()).into(imageView);
        container.addView(itemView);
        if (mOnItemClickCallBack != null)
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickCallBack.onItemClick(position);
                }
            });
        return itemView;
    }

    public interface OnItemClickCallBack {
        void onItemClick(int position);
    }
}
