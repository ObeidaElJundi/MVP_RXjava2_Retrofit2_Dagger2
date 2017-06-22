package com.coding4fun.imgur.ImgurTagImages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.coding4fun.imgur.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurTagImagesActivity extends AppCompatActivity implements ImgurTagImagesContract.View {

    private ImgurTagImagesContract.Presenter mPresenter;
    private ImgurTagImagesRVadapter adapter;
    @BindView(R.id.toolbar)
    Toolbar tb;
    @BindView(R.id.imgur_tags_RV)
    RecyclerView rv;
    @BindView(R.id.imgur_tags_PB)
    ProgressBar pb;
    public static final String EXTRA_IMGUR_TAG = "tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgur_tags_activity); //same layout contents
        ButterKnife.bind(this);

        String tag = getIntent().getStringExtra(EXTRA_IMGUR_TAG);
        initToolbar(tag);
        initRV();

        new ImgurTagImagesPresenter(this,tag); //to automatically set presenter
        mPresenter.subscribe();
    }

    private void initToolbar(String tag){
        setSupportActionBar(tb);
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setTitle(tag.toUpperCase());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initRV(){
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubscribe();
        super.onDestroy();
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
    public void showImages(List<ImgurImage> images) {
        adapter = new ImgurTagImagesRVadapter(this,mPresenter);
        adapter.setImgurTagImages(images);
        rv.setAdapter(adapter);
    }

    @Override
    public void setPresenter(ImgurTagImagesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void openImageDialog(ImgurImage image) {
        View v = getLayoutInflater().inflate(R.layout.dialog_image,null);
        Glide.with(this)
                .load(image.getLink())
                .placeholder(R.drawable.placeholder)
                //.centerCrop()
                .fitCenter()
                .crossFade()
                .into((ImageView) v.findViewById(R.id.dialog_imgur_image));
        new AlertDialog.Builder(this)
                .setCancelable(true)
                .setView(v)
                .create()
                .show();
    }
}