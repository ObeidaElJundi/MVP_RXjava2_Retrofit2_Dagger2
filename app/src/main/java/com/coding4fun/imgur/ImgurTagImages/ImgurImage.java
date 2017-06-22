package com.coding4fun.imgur.ImgurTagImages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurImage {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("datetime")
    @Expose
    private long datetime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("animated")
    @Expose
    private boolean animated;
    @SerializedName("width")
    @Expose
    private long width;
    @SerializedName("height")
    @Expose
    private long height;
    @SerializedName("size")
    @Expose
    private long size;
    @SerializedName("views")
    @Expose
    private long views;
    @SerializedName("favorite")
    @Expose
    private boolean favorite;
    @SerializedName("nsfw")
    @Expose
    private boolean nsfw;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("is_ad")
    @Expose
    private boolean isAd;
    @SerializedName("in_most_viral")
    @Expose
    private boolean inMostViral;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("looping")
    @Expose
    private boolean looping;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isAd() {
        return isAd;
    }

    public void setAd(boolean ad) {
        isAd = ad;
    }

    public boolean isInMostViral() {
        return inMostViral;
    }

    public void setInMostViral(boolean inMostViral) {
        this.inMostViral = inMostViral;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }
}