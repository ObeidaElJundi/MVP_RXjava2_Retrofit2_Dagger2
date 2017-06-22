package com.coding4fun.imgur.model;

import com.coding4fun.imgur.ImgurTagImages.ImgurImage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurTagImagesResponse {

    @SerializedName("data")
    @Expose
    private List<ImgurImage> images = null;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status")
    @Expose
    private long status;

    public List<ImgurImage> getImages() {
        return images;
    }

    public void setImages(List<ImgurImage> images) {
        this.images = images;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


}