package com.coding4fun.imgur.ImgurTagImages;

import android.util.Log;

import com.coding4fun.imgur.model.ImgurService;
import com.coding4fun.imgur.model.ImgurTagImagesResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurTagImagesPresenter implements ImgurTagImagesContract.Presenter {

    private ImgurTagImagesContract.View mImgurTagImagesView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private List<ImgurImage> mImgurImages = new ArrayList<>();
    private String mTag;

    public ImgurTagImagesPresenter(ImgurTagImagesContract.View imgurTagImagesView, String tag) {
        this.mImgurTagImagesView = imgurTagImagesView;
        this.mTag = tag;
        mImgurTagImagesView.setPresenter(this);
    }

    @Override
    public void imageClicked(ImgurImage image) {
        mImgurTagImagesView.openImageDialog(image);
    }

    @Override
    public void subscribe() {
        Log.e("MVP_RX","ImgurTagImagesPresenter subscribe");
        mImgurTagImagesView.hideRecyclerView();
        mImgurTagImagesView.showLoadingIndicator();
        getImagesByTag();
    }

    private void getImagesByTag() {
        mCompositeDisposable.add(getTagImagesObservable()
                .map(new Function<ImgurTagImagesResponse, List<ImgurImage>>() { //convert API response to list of images
                    @Override
                    public List<ImgurImage> apply(@NonNull ImgurTagImagesResponse imgurTagImagesResponse) throws Exception {
                        //for simplicity & to save bandwidth & performance, get only first 10 images whose size is less than 1 MB
                        List<ImgurImage> newList = new ArrayList<>();
                        for(int i=0; i<imgurTagImagesResponse.getImages().size() && newList.size()<10; i++){
                            if(imgurTagImagesResponse.getImages().get(i).getSize() < 1000*1000) newList.add(imgurTagImagesResponse.getImages().get(i));
                        }
                        return newList;
                        //return imgurTagImagesResponse.getImages().subList(0,10);
                    }
                })
                .subscribeOn(Schedulers.io()) // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribe(new Consumer<List<ImgurImage>>() {
                    @Override
                    public void accept(@NonNull List<ImgurImage> imgurImages) throws Exception {
                        imagesAreReady(imgurImages); //hide loading & show list
                    }
                })
        );
    }

    private Observable<ImgurTagImagesResponse> getTagImagesObservable(){
        return ImgurService.getAPI().getImgurImagesByTag(mTag);
    }

    //hide loading & show list
    //called when images are retrieved successfully from Imgur API
    private void imagesAreReady(List<ImgurImage> images){
        Log.e("MVP_RX","imagesAreReady");
        mImgurImages = images;
        mImgurTagImagesView.hideLoadingIndicator();
        mImgurTagImagesView.showRecyclerView();
        mImgurTagImagesView.showImages(images);
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }


}