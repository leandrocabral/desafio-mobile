package com.leandroid.desafiomobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product {

    @SerializedName("Availability")
    private boolean availability;

    @SerializedName("Skus")
    private ArrayList<Sku> skus;

    @SerializedName("Name")
    private String name;

    @SerializedName("Id")
    private String Id;

    @SerializedName("Brand")
    private String Brand;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public ArrayList<Sku> getSkus() {
        return skus;
    }

    public void setSkus(ArrayList<Sku> skus) {
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }
}
