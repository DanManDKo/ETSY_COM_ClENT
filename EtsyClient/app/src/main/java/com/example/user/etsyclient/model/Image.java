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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (imageId != image.imageId) return false;
        if (red != image.red) return false;
        if (green != image.green) return false;
        if (blue != image.blue) return false;
        if (hue != image.hue) return false;
        if (saturation != image.saturation) return false;
        if (brightness != image.brightness) return false;
        if (blackAndWhite != image.blackAndWhite) return false;
        if (creationTsz != image.creationTsz) return false;
        if (productId != image.productId) return false;
        if (rank != image.rank) return false;
        if (fullHeight != image.fullHeight) return false;
        if (fullWidth != image.fullWidth) return false;
        if (hexCode != null ? !hexCode.equals(image.hexCode) : image.hexCode != null) return false;
        if (url75x75 != null ? !url75x75.equals(image.url75x75) : image.url75x75 != null)
            return false;
        if (url170x135 != null ? !url170x135.equals(image.url170x135) : image.url170x135 != null)
            return false;
        if (url570xN != null ? !url570xN.equals(image.url570xN) : image.url570xN != null)
            return false;
        return urlFullxFull != null ? urlFullxFull.equals(image.urlFullxFull) : image.urlFullxFull == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (imageId ^ (imageId >>> 32));
        result = 31 * result + (hexCode != null ? hexCode.hashCode() : 0);
        result = 31 * result + red;
        result = 31 * result + green;
        result = 31 * result + blue;
        result = 31 * result + hue;
        result = 31 * result + saturation;
        result = 31 * result + brightness;
        result = 31 * result + (blackAndWhite ? 1 : 0);
        result = 31 * result + creationTsz;
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + rank;
        result = 31 * result + (url75x75 != null ? url75x75.hashCode() : 0);
        result = 31 * result + (url170x135 != null ? url170x135.hashCode() : 0);
        result = 31 * result + (url570xN != null ? url570xN.hashCode() : 0);
        result = 31 * result + (urlFullxFull != null ? urlFullxFull.hashCode() : 0);
        result = 31 * result + fullHeight;
        result = 31 * result + fullWidth;
        return result;
    }
}
