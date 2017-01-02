package com.example.user.etsyclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 29.12.2016.
 */

public class Image implements Parcelable {
    @SerializedName("listing_image_id")
    private long imageId;
    @SerializedName("hex_code")
    private String hexCode;
    @SerializedName("red")
    private int red;
    @SerializedName("green")
    private int green;
    @SerializedName("blue")
    private int blue;
    @SerializedName("hue")
    private int hue;
    @SerializedName("saturation")
    private int saturation;
    @SerializedName("brightness")
    private int brightness;
    @SerializedName("is_black_and_white")
    private boolean blackAndWhite;
    @SerializedName("creation_tsz")
    private int creationTsz;
    @SerializedName("listing_id")
    private long productId;
    @SerializedName("rank")
    private int rank;
    @SerializedName("url_75x75")
    private String url75x75;
    @SerializedName("url_170x135")
    private String url170x135;
    @SerializedName("url_570xN")
    private String url570xN;
    @SerializedName("url_fullxfull")
    private String urlFullxFull;
    @SerializedName("full_height")
    private int fullHeight;
    @SerializedName("full_width")
    private int fullWidth;
    public Image(){}
    protected Image(Parcel in) {
        imageId = in.readLong();
        hexCode = in.readString();
        red = in.readInt();
        green = in.readInt();
        blue = in.readInt();
        hue = in.readInt();
        saturation = in.readInt();
        brightness = in.readInt();
        blackAndWhite = in.readByte() != 0;
        creationTsz = in.readInt();
        productId = in.readLong();
        rank = in.readInt();
        url75x75 = in.readString();
        url170x135 = in.readString();
        url570xN = in.readString();
        urlFullxFull = in.readString();
        fullHeight = in.readInt();
        fullWidth = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(imageId);
        dest.writeString(hexCode);
        dest.writeInt(red);
        dest.writeInt(green);
        dest.writeInt(blue);
        dest.writeInt(hue);
        dest.writeInt(saturation);
        dest.writeInt(brightness);
        dest.writeByte((byte) (blackAndWhite ? 1 : 0));
        dest.writeInt(creationTsz);
        dest.writeLong(productId);
        dest.writeInt(rank);
        dest.writeString(url75x75);
        dest.writeString(url170x135);
        dest.writeString(url570xN);
        dest.writeString(urlFullxFull);
        dest.writeInt(fullHeight);
        dest.writeInt(fullWidth);
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

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean getBlackAndWhite() {
        return blackAndWhite;
    }

    public void setBlackAndWhite(boolean blackAndWhite) {
        this.blackAndWhite = blackAndWhite;
    }

    public int getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(int creationTsz) {
        this.creationTsz = creationTsz;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
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

    public int getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(int fullHeight) {
        this.fullHeight = fullHeight;
    }

    public int getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(int fullWidth) {
        this.fullWidth = fullWidth;
    }
}
