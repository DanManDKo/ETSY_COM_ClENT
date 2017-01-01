package com.example.user.etsyclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 29.12.2016.
 */

public class Image implements Parcelable {
    @SerializedName("listing_image_id")
    private String listingImageId;
    @SerializedName("hex_code")
    private String hexCode;
    @SerializedName("red")
    private String red;
    @SerializedName("green")
    private String green;
    @SerializedName("blue")
    private String blue;
    @SerializedName("hue")
    private String hue;
    @SerializedName("saturation")
    private String saturation;
    @SerializedName("brightness")
    private String brightness;
    @SerializedName("is_black_and_white")
    private String blackAndWhite;
    @SerializedName("creation_tsz")
    private String creationTsz;
    @SerializedName("listing_id")
    private String productId;
    @SerializedName("rank")
    private String rank;
    @SerializedName("url_75x75")
    private String url75x75;
    @SerializedName("url_170x135")
    private String url170x135;
    @SerializedName("url_570xN")
    private String url570xN;
    @SerializedName("url_fullxfull")
    private String urlFullxFull;
    @SerializedName("full_height")
    private String fullHeight;
    @SerializedName("full_width")
    private String fullWidth;

    protected Image(Parcel in) {
        listingImageId = in.readString();
        hexCode = in.readString();
        red = in.readString();
        green = in.readString();
        blue = in.readString();
        hue = in.readString();
        saturation = in.readString();
        brightness = in.readString();
        blackAndWhite = in.readString();
        creationTsz = in.readString();
        productId = in.readString();
        rank = in.readString();
        url75x75 = in.readString();
        url170x135 = in.readString();
        url570xN = in.readString();
        urlFullxFull = in.readString();
        fullHeight = in.readString();
        fullWidth = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(listingImageId);
        dest.writeString(hexCode);
        dest.writeString(red);
        dest.writeString(green);
        dest.writeString(blue);
        dest.writeString(hue);
        dest.writeString(saturation);
        dest.writeString(brightness);
        dest.writeString(blackAndWhite);
        dest.writeString(creationTsz);
        dest.writeString(productId);
        dest.writeString(rank);
        dest.writeString(url75x75);
        dest.writeString(url170x135);
        dest.writeString(url570xN);
        dest.writeString(urlFullxFull);
        dest.writeString(fullHeight);
        dest.writeString(fullWidth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getListingImageId() {
        return listingImageId;
    }

    public void setListingImageId(String listingImageId) {
        this.listingImageId = listingImageId;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getHue() {
        return hue;
    }

    public void setHue(String hue) {
        this.hue = hue;
    }

    public String getSaturation() {
        return saturation;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public String getBlackAndWhite() {
        return blackAndWhite;
    }

    public void setBlackAndWhite(String blackAndWhite) {
        this.blackAndWhite = blackAndWhite;
    }

    public String getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(String creationTsz) {
        this.creationTsz = creationTsz;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUrl75x75() {
        return url75x75;
    }

    public void setUrl75x75(String url75x75) {
        this.url75x75 = url75x75;
    }

    public String getUrl170x135() {
        return url170x135;
    }

    public void setUrl170x135(String url170x135) {
        this.url170x135 = url170x135;
    }

    public String getUrl570xN() {
        return url570xN;
    }

    public void setUrl570xN(String url570xN) {
        this.url570xN = url570xN;
    }

    public String getUrlFullxFull() {
        return urlFullxFull;
    }

    public void setUrlFullxFull(String urlFullxFull) {
        this.urlFullxFull = urlFullxFull;
    }

    public String getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(String fullHeight) {
        this.fullHeight = fullHeight;
    }

    public String getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(String fullWidth) {
        this.fullWidth = fullWidth;
    }
}
