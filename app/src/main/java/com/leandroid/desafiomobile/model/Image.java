package com.leandroid.desafiomobile.model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("ImageUrl")
    private String ImageUrl;
    @SerializedName("ImageTag")
    private String ImageTag;
    @SerializedName("Label")
    private String Label;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageTag() {
        return ImageTag;
    }

    public void setImageTag(String imageTag) {
        ImageTag = imageTag;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
