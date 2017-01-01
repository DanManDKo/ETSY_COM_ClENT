package com.example.user.etsyclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 29.12.2016.
 */

public class Product implements Parcelable {
    @SerializedName("listing_id")
    private String productId;
    @SerializedName("state")
    private String state;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private String price;
    @SerializedName("currency_code")
    private String currencyCode;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("item_weight")
    private String itemWeight;
    @SerializedName("Images")
    private List<Image> images;

    protected Product(Parcel in) {
        productId = in.readString();
        state = in.readString();
        categoryId = in.readString();
        title = in.readString();
        description = in.readString();
        price = in.readString();
        currencyCode = in.readString();
        quantity = in.readString();
        itemWeight = in.readString();
        images = in.createTypedArrayList(Image.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(state);
        dest.writeString(categoryId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeString(currencyCode);
        dest.writeString(quantity);
        dest.writeString(itemWeight);
        dest.writeTypedList(images);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
