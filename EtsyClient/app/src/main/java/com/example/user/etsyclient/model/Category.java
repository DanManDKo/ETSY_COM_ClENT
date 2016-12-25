package com.example.user.etsyclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 25.12.2016.
 */

public class Category {
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("name")
    private String name;
    @SerializedName("meta_title")
    private String metaTitle;
    @SerializedName("meta_keywords")
    private String metaKeywords;
    @SerializedName("meta_description")
    private String metaDescription;
    @SerializedName("page_description")
    private String pageDescription;
    @SerializedName("page_title")
    private String pageTitle;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("short_name")
    private String shortName;
    @SerializedName("long_name")
    private String longName;
    @SerializedName("num_children")
    private String numChildren;

    public Category() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(String numChildren) {
        this.numChildren = numChildren;
    }

    @Override
    public String toString() {
        return longName;
    }
}
