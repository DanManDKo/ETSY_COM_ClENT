package com.example.user.etsyclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 25.12.2016.
 */

public class Response<T> {
    @SerializedName("count")
    private String mCount;
    @SerializedName("results")
    private List<T> mResults;

    @SerializedName("type")
    private String mType;

    public String getCount() {
        return mCount;
    }

    public void setCount(String count) {
        mCount = count;
    }

    public List<T> getResults() {

        return mResults;
    }

    public void setResults(List<T> results) {
        mResults = results;
    }


    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
