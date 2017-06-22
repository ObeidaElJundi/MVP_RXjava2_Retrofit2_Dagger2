package com.coding4fun.imgur.ImgurTagImages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coding4fun.imgur.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurTagImagesRVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ImgurImage> imgurImages;
    private Context context;
    private ImgurTagImagesContract.Presenter presenter;
    private int lastPosition = -1;
    private static final int EMPTY_VIEW = 10;
    private static final int IMGUR_TAG_VIEW = 11;

    public ImgurTagImagesRVadapter(Context context, ImgurTagImagesContract.Presenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    public void setImgurTagImages(List<ImgurImage> imgurImages){
        this.imgurImages = imgurImages;
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //describes an item view, and
    //Contains references for all views that are filled by the data of the entry
    public class ImgurTagImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_imgur_image_name)
        TextView imgurImageName;
        @BindView(R.id.row_imgur_image_size)
        TextView imgurImageSize;
        @BindView(R.id.row_imgur_image)
        ImageView imgurImage;

        public ImgurTagImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.row_imgur_image)
        public void imageClicked() {
            presenter.imageClicked(imgurImages.get(getAdapterPosition()));
            //Toast.makeText(context, imgurImages.get(getAdapterPosition()).getTitle() + " clicked :)", Toast.LENGTH_SHORT).show();
        }
    }

    // inflate the item (row) layout and create the holder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == EMPTY_VIEW) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty, viewGroup, false);
            return new ImgurTagImagesRVadapter.EmptyViewHolder(v);
        }
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_imgur_image, viewGroup, false);
        return new ImgurTagImagesRVadapter.ImgurTagImageViewHolder(v);
    }

    // Return the size of the items list
    @Override
    public int getItemCount() {
        return imgurImages.size()>0 ? imgurImages.size() : 1;	//otherwise, even empty layout won't appear
    }

    @Override
    public int getItemViewType(int position) {
        return (imgurImages.size() == 0) ? EMPTY_VIEW : IMGUR_TAG_VIEW;
    }

    //display (update) the data at the specified position
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ImgurTagImagesRVadapter.ImgurTagImageViewHolder) {
            ImgurTagImagesRVadapter.ImgurTagImageViewHolder vh = (ImgurTagImagesRVadapter.ImgurTagImageViewHolder) viewHolder;
            ImgurImage image = imgurImages.get(position);
            String title = (image.getTitle() != null && image.getTitle().length() > 0) ? image.getTitle() : "No name!";
            vh.imgurImageName.setText(title);
            vh.imgurImageSize.setText(getSize(image.getSize()));
            Glide.with(context)
                    //.load("http://i.imgur.com/" + tag.getBackgroundHash() + ".jpg")
                    .load(image.getLink())
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //load full-size image from cache, if existed, resize, display, and then re-cache the resized image.
                    .placeholder(R.drawable.placeholder)
                    //.centerCrop()
                    .fitCenter()
                    .crossFade()
                    .into(vh.imgurImage);
            animate(vh.itemView,position);
        }
    }

    private String getSize(long size){
        if(size < 1000) return size + " Byte";
        else if(size < 1000 * 1000) return (size/1000) + " KB";
        else if(size < 1000 * 1000 * 1000) return (size/(1000*1000)) + " MB";
        else  return size+"";
    }

    private void animate(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, (position%2==0) ? -1f : 1f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f);
            AlphaAnimation alpha = new AlphaAnimation(0f, 1f);
            AnimationSet set = new AnimationSet(true);
            set.addAnimation(translate);
            set.addAnimation(alpha);
            set.setDuration(444);
            set.setInterpolator(new DecelerateInterpolator());
            viewToAnimate.startAnimation(set);
            lastPosition = position;
        }
    }

}