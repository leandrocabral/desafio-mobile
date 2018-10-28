package com.leandroid.desafiomobile.model;

import com.google.gson.annotations.SerializedName;

public class BestInstallment {

    @SerializedName("Count")
    private int count;

    @SerializedName("Value")
    private Double value;

    @SerializedName("Total")
    private Double total;

    @SerializedName("Rate")
    private int rate;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
