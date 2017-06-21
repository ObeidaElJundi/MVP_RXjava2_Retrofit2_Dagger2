package com.coding4fun.imgur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by coding4fun on 20-Jun-17.
 */

public class ImgurTagsResponse {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status")
    @Expose
    private int status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public class Data {

        @SerializedName("tags")
        @Expose
        private List<com.coding4fun.imgur.ImgurTags.ImgurTag> imgurTags = null;
        @SerializedName("featured")
        @Expose
        private String featured;
        @SerializedName("galleries")
        @Expose
        private List<Gallery> galleries = null;

        public List<com.coding4fun.imgur.ImgurTags.ImgurTag> getImgurTags() {
            return imgurTags;
        }

        public void setImgurTags(List<com.coding4fun.imgur.ImgurTags.ImgurTag> imgurTags) {
            this.imgurTags = imgurTags;
        }

        public String getFeatured() {
            return featured;
        }

        public void setFeatured(String featured) {
            this.featured = featured;
        }

        public List<Gallery> getGalleries() {
            return galleries;
        }

        public void setGalleries(List<Gallery> galleries) {
            this.galleries = galleries;
        }

    }

    class DescriptionAnnotations {
    }

    class DescriptionAnnotations_ {
    }

    class Gallery {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("topPost")
        @Expose
        private TopPost topPost;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public TopPost getTopPost() {
            return topPost;
        }

        public void setTopPost(TopPost topPost) {
            this.topPost = topPost;
        }

    }

    class ImgurTag {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("followers")
        @Expose
        private int followers;
        @SerializedName("total_items")
        @Expose
        private int totalItems;
        @SerializedName("following")
        @Expose
        private boolean following;
        @SerializedName("background_hash")
        @Expose
        private String backgroundHash;
        @SerializedName("background_is_animated")
        @Expose
        private boolean backgroundIsAnimated;
        @SerializedName("is_promoted")
        @Expose
        private boolean isPromoted;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("logo_hash")
        @Expose
        private Object logoHash;
        @SerializedName("logo_destination_url")
        @Expose
        private Object logoDestinationUrl;
        @SerializedName("description_annotations")
        @Expose
        private DescriptionAnnotations descriptionAnnotations;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(int totalItems) {
            this.totalItems = totalItems;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public String getBackgroundHash() {
            return backgroundHash;
        }

        public void setBackgroundHash(String backgroundHash) {
            this.backgroundHash = backgroundHash;
        }

        public boolean isBackgroundIsAnimated() {
            return backgroundIsAnimated;
        }

        public void setBackgroundIsAnimated(boolean backgroundIsAnimated) {
            this.backgroundIsAnimated = backgroundIsAnimated;
        }

        public boolean isIsPromoted() {
            return isPromoted;
        }

        public void setIsPromoted(boolean isPromoted) {
            this.isPromoted = isPromoted;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getLogoHash() {
            return logoHash;
        }

        public void setLogoHash(Object logoHash) {
            this.logoHash = logoHash;
        }

        public Object getLogoDestinationUrl() {
            return logoDestinationUrl;
        }

        public void setLogoDestinationUrl(Object logoDestinationUrl) {
            this.logoDestinationUrl = logoDestinationUrl;
        }

        public DescriptionAnnotations getDescriptionAnnotations() {
            return descriptionAnnotations;
        }

        public void setDescriptionAnnotations(DescriptionAnnotations descriptionAnnotations) {
            this.descriptionAnnotations = descriptionAnnotations;
        }

    }

    public class Tag {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("followers")
        @Expose
        private long followers;
        @SerializedName("total_items")
        @Expose
        private long totalItems;
        @SerializedName("following")
        @Expose
        private boolean following;
        @SerializedName("background_hash")
        @Expose
        private String backgroundHash;
        @SerializedName("background_is_animated")
        @Expose
        private boolean backgroundIsAnimated;
        @SerializedName("is_promoted")
        @Expose
        private boolean isPromoted;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("logo_hash")
        @Expose
        private Object logoHash;
        @SerializedName("logo_destination_url")
        @Expose
        private Object logoDestinationUrl;
        @SerializedName("description_annotations")
        @Expose
        private DescriptionAnnotations descriptionAnnotations;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public long getFollowers() {
            return followers;
        }

        public void setFollowers(long followers) {
            this.followers = followers;
        }

        public long getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(long totalItems) {
            this.totalItems = totalItems;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public String getBackgroundHash() {
            return backgroundHash;
        }

        public void setBackgroundHash(String backgroundHash) {
            this.backgroundHash = backgroundHash;
        }

        public boolean isBackgroundIsAnimated() {
            return backgroundIsAnimated;
        }

        public void setBackgroundIsAnimated(boolean backgroundIsAnimated) {
            this.backgroundIsAnimated = backgroundIsAnimated;
        }

        public boolean isIsPromoted() {
            return isPromoted;
        }

        public void setIsPromoted(boolean isPromoted) {
            this.isPromoted = isPromoted;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getLogoHash() {
            return logoHash;
        }

        public void setLogoHash(Object logoHash) {
            this.logoHash = logoHash;
        }

        public Object getLogoDestinationUrl() {
            return logoDestinationUrl;
        }

        public void setLogoDestinationUrl(Object logoDestinationUrl) {
            this.logoDestinationUrl = logoDestinationUrl;
        }

        public DescriptionAnnotations getDescriptionAnnotations() {
            return descriptionAnnotations;
        }

        public void setDescriptionAnnotations(DescriptionAnnotations descriptionAnnotations) {
            this.descriptionAnnotations = descriptionAnnotations;
        }

    }

    class Tag_ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("followers")
        @Expose
        private int followers;
        @SerializedName("total_items")
        @Expose
        private int totalItems;
        @SerializedName("following")
        @Expose
        private boolean following;
        @SerializedName("background_hash")
        @Expose
        private String backgroundHash;
        @SerializedName("background_is_animated")
        @Expose
        private boolean backgroundIsAnimated;
        @SerializedName("is_promoted")
        @Expose
        private boolean isPromoted;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("logo_hash")
        @Expose
        private Object logoHash;
        @SerializedName("logo_destination_url")
        @Expose
        private Object logoDestinationUrl;
        @SerializedName("description_annotations")
        @Expose
        private DescriptionAnnotations_ descriptionAnnotations;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(int totalItems) {
            this.totalItems = totalItems;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public String getBackgroundHash() {
            return backgroundHash;
        }

        public void setBackgroundHash(String backgroundHash) {
            this.backgroundHash = backgroundHash;
        }

        public boolean isBackgroundIsAnimated() {
            return backgroundIsAnimated;
        }

        public void setBackgroundIsAnimated(boolean backgroundIsAnimated) {
            this.backgroundIsAnimated = backgroundIsAnimated;
        }

        public boolean isIsPromoted() {
            return isPromoted;
        }

        public void setIsPromoted(boolean isPromoted) {
            this.isPromoted = isPromoted;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getLogoHash() {
            return logoHash;
        }

        public void setLogoHash(Object logoHash) {
            this.logoHash = logoHash;
        }

        public Object getLogoDestinationUrl() {
            return logoDestinationUrl;
        }

        public void setLogoDestinationUrl(Object logoDestinationUrl) {
            this.logoDestinationUrl = logoDestinationUrl;
        }

        public DescriptionAnnotations_ getDescriptionAnnotations() {
            return descriptionAnnotations;
        }

        public void setDescriptionAnnotations(DescriptionAnnotations_ descriptionAnnotations) {
            this.descriptionAnnotations = descriptionAnnotations;
        }

    }

    class TopPost {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("datetime")
        @Expose
        private long datetime;
        @SerializedName("cover")
        @Expose
        private String cover;
        @SerializedName("cover_width")
        @Expose
        private int coverWidth;
        @SerializedName("cover_height")
        @Expose
        private int coverHeight;
        @SerializedName("account_url")
        @Expose
        private String accountUrl;
        @SerializedName("account_id")
        @Expose
        private long accountId;
        @SerializedName("privacy")
        @Expose
        private String privacy;
        @SerializedName("layout")
        @Expose
        private String layout;
        @SerializedName("views")
        @Expose
        private int views;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("ups")
        @Expose
        private int ups;
        @SerializedName("downs")
        @Expose
        private int downs;
        @SerializedName("points")
        @Expose
        private int points;
        @SerializedName("score")
        @Expose
        private int score;
        @SerializedName("is_album")
        @Expose
        private boolean isAlbum;
        @SerializedName("vote")
        @Expose
        private Object vote;
        @SerializedName("favorite")
        @Expose
        private Object favorite;
        @SerializedName("nsfw")
        @Expose
        private boolean nsfw;
        @SerializedName("section")
        @Expose
        private String section;
        @SerializedName("comment_count")
        @Expose
        private int commentCount;
        @SerializedName("topic")
        @Expose
        private String topic;
        @SerializedName("topic_id")
        @Expose
        private long topicId;
        @SerializedName("images_count")
        @Expose
        private int imagesCount;
        @SerializedName("in_gallery")
        @Expose
        private boolean inGallery;
        @SerializedName("is_ad")
        @Expose
        private boolean isAd;
        @SerializedName("imgurTags")
        @Expose
        private List<Tag_> tags = null;
        @SerializedName("ad_type")
        @Expose
        private int adType;
        @SerializedName("ad_url")
        @Expose
        private String adUrl;
        @SerializedName("in_most_viral")
        @Expose
        private boolean inMostViral;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("animated")
        @Expose
        private boolean animated;
        @SerializedName("width")
        @Expose
        private int width;
        @SerializedName("height")
        @Expose
        private int height;
        @SerializedName("size")
        @Expose
        private int size;
        @SerializedName("bandwidth")
        @Expose
        private long bandwidth;

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

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getCoverWidth() {
            return coverWidth;
        }

        public void setCoverWidth(int coverWidth) {
            this.coverWidth = coverWidth;
        }

        public int getCoverHeight() {
            return coverHeight;
        }

        public void setCoverHeight(int coverHeight) {
            this.coverHeight = coverHeight;
        }

        public String getAccountUrl() {
            return accountUrl;
        }

        public void setAccountUrl(String accountUrl) {
            this.accountUrl = accountUrl;
        }

        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public String getPrivacy() {
            return privacy;
        }

        public void setPrivacy(String privacy) {
            this.privacy = privacy;
        }

        public String getLayout() {
            return layout;
        }

        public void setLayout(String layout) {
            this.layout = layout;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getUps() {
            return ups;
        }

        public void setUps(int ups) {
            this.ups = ups;
        }

        public int getDowns() {
            return downs;
        }

        public void setDowns(int downs) {
            this.downs = downs;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public boolean isIsAlbum() {
            return isAlbum;
        }

        public void setIsAlbum(boolean isAlbum) {
            this.isAlbum = isAlbum;
        }

        public Object getVote() {
            return vote;
        }

        public void setVote(Object vote) {
            this.vote = vote;
        }

        public Object getFavorite() {
            return favorite;
        }

        public void setFavorite(Object favorite) {
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

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public long getTopicId() {
            return topicId;
        }

        public void setTopicId(long topicId) {
            this.topicId = topicId;
        }

        public int getImagesCount() {
            return imagesCount;
        }

        public void setImagesCount(int imagesCount) {
            this.imagesCount = imagesCount;
        }

        public boolean isInGallery() {
            return inGallery;
        }

        public void setInGallery(boolean inGallery) {
            this.inGallery = inGallery;
        }

        public boolean isIsAd() {
            return isAd;
        }

        public void setIsAd(boolean isAd) {
            this.isAd = isAd;
        }

        public List<Tag_> getTags() {
            return tags;
        }

        public void setTags(List<Tag_> tags) {
            this.tags = tags;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public String getAdUrl() {
            return adUrl;
        }

        public void setAdUrl(String adUrl) {
            this.adUrl = adUrl;
        }

        public boolean isInMostViral() {
            return inMostViral;
        }

        public void setInMostViral(boolean inMostViral) {
            this.inMostViral = inMostViral;
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getBandwidth() {
            return bandwidth;
        }

        public void setBandwidth(long bandwidth) {
            this.bandwidth = bandwidth;
        }

    }

}