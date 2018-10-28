package com.leandroid.desafiomobile.service.request;

import com.google.gson.annotations.SerializedName;

public class ProductRequest {

    @SerializedName("Query")
    private String query;
    @SerializedName("Offset")
    private int offset;
    @SerializedName("Size")
    private int size;

    public ProductRequest(String query,int offset,int size ){
        this.query    = query;
        this.offset   = offset;
        this.size     = size;
    }
}
