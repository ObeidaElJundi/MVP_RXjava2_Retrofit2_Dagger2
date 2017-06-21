package com.coding4fun.imgur.ImgurTags;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coding4fun.imgur.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by coding4fun on 20-Jun-17.
 */

public class ImgurTagsRVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ImgurTag> imgurTags;
    Context context;
    ImgurTagsContract.Presenter presenter;
    private int lastPosition = -1;
    private static final int EMPTY_VIEW = 10;
    private static final int IMGUR_TAG_VIEW = 11;

    public ImgurTagsRVadapter(Context context, ImgurTagsContract.Presenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    public void setImgurTags(List<ImgurTag> imgurTags){
        this.imgurTags = imgurTags;
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //describes an item view, and
    //Contains references for all views that are filled by the data of the entry
    public class ImgurTagViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.row_imgur_tag_name) TextView imgurTagName;
        @BindView(R.id.row_imgur_tag_background) ImageView imgurTagBackground;
        @BindView(R.id.row_imgur_tag_transparent_black_layer) View transparentBlackLayer;
        //private float initialTouchX=0, initialTouchY=0;
        //private Rect rect;

        public ImgurTagViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.row_imgur_tag_background)
        public void tagClicked(){
            presenter.openTagImages(imgurTags.get(getAdapterPosition()));
        }

        /*@OnTouch(R.id.row_imgur_tag_transparent_black_layer)
        public boolean onTagTouched(View v, MotionEvent me){
            if(me.getActionMasked() == MotionEvent.ACTION_DOWN) {
                transparentBlackLayer.setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent_transparent));
                initialTouchX = me.getRawX();
                initialTouchY = me.getRawY();
                rect = new Rect(transparentBlackLayer.getLeft(),transparentBlackLayer.getTop(),transparentBlackLayer.getRight(),transparentBlackLayer.getBottom());
            } else if(me.getActionMasked() == MotionEvent.ACTION_UP) {
                transparentBlackLayer.setBackgroundColor(ContextCompat.getColor(context,R.color.black_transparent));
                if(initialTouchX == me.getRawX() && initialTouchY == me.getRawY()) { //no move >> click
                    presenter.openTagImages(imgurTags.get(getAdapterPosition()));
                }
            } else if(me.getActionMasked() == MotionEvent.ACTION_OUTSIDE) { //touch got outside view
                transparentBlackLayer.setBackgroundColor(ContextCompat.getColor(context,R.color.black_transparent));
                Log.e("MVP_RX","ACTION_OUTSIDE");
            }  else if(me.getActionMasked() == MotionEvent.ACTION_HOVER_EXIT) { //touch got outside view
                Log.e("MVP_RX","ACTION_HOVER_EXIT");
            }
            /*} else if(rect != null && !rect.contains(transparentBlackLayer.getLeft() + (int)me.getX(), transparentBlackLayer.getTop() + (int)me.getY())) { //touch got outside view
            } else if(rect != null && !rect.contains(Math.round(transparentBlackLayer.getX()+me.getX()), Math.round(transparentBlackLayer.getY()+me.getY()))) { //touch got outside view
                transparentBlackLayer.setBackgroundColor(ContextCompat.getColor(context,R.color.black_transparent));
            }
            return true;
        }*/
    }

    // inflate the item (row) layout and create the holder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == EMPTY_VIEW) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty, viewGroup, false);
            return new EmptyViewHolder(v);
        }
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_imgur_tag, viewGroup, false);
        return new ImgurTagViewHolder(v);
    }

    // Return the size of the items list
    @Override
    public int getItemCount() {
        return imgurTags.size()>0 ? imgurTags.size() : 1;	//otherwise, even empty layout won't appear
    }

    @Override
    public int getItemViewType(int position) {
        return (imgurTags.size() == 0) ? EMPTY_VIEW : IMGUR_TAG_VIEW;
    }


    //display (update) the data at the specified position
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ImgurTagViewHolder) {
            ImgurTagViewHolder vh = (ImgurTagViewHolder) viewHolder;
            ImgurTag tag = imgurTags.get(position);
            vh.imgurTagName.setText(tag.getDisplayName().toUpperCase());
            Glide.with(context)
                    .load("http://i.imgur.com/" + tag.getBackgroundHash() + ".jpg")
                    .placeholder(R.drawable.placeholder)
                    //.centerCrop()
                    .fitCenter()
                    .crossFade()
                    .into(vh.imgurTagBackground);
            animate(vh.itemView,position);
        }
    }

    private void animate(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(500);
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }
}