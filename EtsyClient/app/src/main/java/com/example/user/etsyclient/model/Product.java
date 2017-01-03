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
    private long productId;
    @SerializedName("state")
    private String state;
    @SerializedName("category_id")
    private long categoryId;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;
    @SerializedName("currency_code")
    private String currencyCode;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("item_weight")
    private double itemWeight;
    @SerializedName("Images")
    private List<Image> images;
    public Product(){}
    protected Product(Parcel in) {
        productId = in.readLong();
        state = in.readString();
        categoryId = in.readLong();
        title = in.readString();
        description = in.readString();
        price = in.readDouble();
        currencyCode = in.readString();
        quantity = in.readInt();
        itemWeight = in.readDouble();
        images = in.createTypedArrayList(Image.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(productId);
        dest.writeString(state);
        dest.writeLong(categoryId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeString(currencyCode);
        dest.writeInt(quantity);
        dest.writeDouble(itemWeight);
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (categoryId != product.categoryId) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (Double.compare(product.itemWeight, itemWeight) != 0) return false;
        if (state != null ? !state.equals(product.state) : product.state != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null)
            return false;
        if (currencyCode != null ? !currencyCode.equals(product.currencyCode) : product.currencyCode != null)
            return false;
        return images != null ? images.equals(product.images) : product.images == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(itemWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }
}
