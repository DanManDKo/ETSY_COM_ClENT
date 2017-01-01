package com.example.user.etsyclient.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.etsyclient.R;
import com.example.user.etsyclient.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 29.12.2016.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> mProducts;
    private final int FIRST_IMAGE = 0;
    private OnProductClickCallBack mOnClickCallBack;

    public ProductsAdapter(@NonNull List<Product> products) {
        mProducts = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(holder.itemView.getContext())
                .load(mProducts.get(position)
                        .getImages().get(FIRST_IMAGE)
                        .getUrlFullxFull())
                .resize(100, 100)
                .into(holder.mPreview);
        holder.mName.setText(mProducts.get(position).getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickCallBack.onItemClick(mProducts.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPreview;
        private TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mPreview = (ImageView) itemView.findViewById(R.id.preview_iv);
            mName = (TextView) itemView.findViewById(R.id.product_name_tv);

        }
    }

    public interface OnProductClickCallBack {
        void onItemClick(Product product);
    }

    public void setOnClickCallBack(OnProductClickCallBack onClickCallBack) {
        mOnClickCallBack = onClickCallBack;
    }
}
