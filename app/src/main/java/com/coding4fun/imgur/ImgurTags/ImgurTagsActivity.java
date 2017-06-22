package com.coding4fun.imgur.ImgurTags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.coding4fun.imgur.ImgurTagImages.ImgurTagImagesActivity;
import com.coding4fun.imgur.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coding4fun on 19-Jun-17.
 */

public class ImgurTagsActivity extends AppCompatActivity implements ImgurTagsContract.View {

    private ImgurTagsContract.Presenter mPresenter;
    private ImgurTagsRVadapter adapter;
    @BindView(R.id.toolbar) Toolbar tb;
    @BindView(R.id.imgur_tags_RV) RecyclerView rv;
    @BindView(R.id.imgur_tags_PB) ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgur_tags_activity);
        ButterKnife.bind(this);

        initToolbar();
        initRV();

        new ImgurTagsPresenter(this); //to automatically set presenter
        mPresenter.subscribe();
    }

    private void initToolbar(){
        //tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setTitle(R.string.tags_toolbar_title);
    }

    private void initRV(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        DefaultItemAnimator anim = new DefaultItemAnimator();
        anim.setAddDuration(500);
        anim.setRemoveDuration(500);
        rv.setItemAnimator(anim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mPresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void setPresenter(ImgurTagsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLoadingIndicator() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView() {
        rv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecyclerView() {
        rv.setVisibility(View.GONE);
    }

    @Override
    public void showTags(List<ImgurTag> tags) {
        Log.e("MVP_RX","showing tags");
        adapter = new ImgurTagsRVadapter(this,mPresenter);
        adapter.setImgurTags(tags);
        rv.setAdapter(adapter);
    }

    @Override
    public void openTagImagesActivity(ImgurTag tag) {
        //Toast.makeText(this, tag.getName() + " clicked :)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ImgurTagImagesActivity.class);
        intent.putExtra(ImgurTagImagesActivity.EXTRA_IMGUR_TAG,tag.getName());
        startActivity(intent);
    }

}