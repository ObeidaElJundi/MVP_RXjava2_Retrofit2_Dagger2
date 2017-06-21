package com.coding4fun.imgur.ImgurTags;

import android.util.Log;

import com.coding4fun.imgur.model.ImgurService;
import com.coding4fun.imgur.model.ImgurTagsResponse;

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
 * Created by coding4fun on 19-Jun-17.
 */

public class ImgurTagsPresenter implements ImgurTagsContract.Presenter {

    private final ImgurTagsContract.View mImgurTagsView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public ImgurTagsPresenter(ImgurTagsContract.View imgurTagsView) {
        mImgurTagsView = imgurTagsView;
        mImgurTagsView.setPresenter(this);
    }

    @Override
    public void openTagImages(ImgurTag tag) {
        mImgurTagsView.openTagImagesActivity(tag);
    }

    @Override
    public void subscribe() {
        Log.e("MVP_RX","ImgurTagsPresenter subscribe");
        mImgurTagsView.hideRecyclerView();
        mImgurTagsView.showLoadingIndicator();
        getTags();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    private void getTags(){
        Log.e("MVP_RX","getting tags");
        mCompositeDisposable.add(getTagsObservable()
                .map(new Function<ImgurTagsResponse, List<ImgurTag>>() {
                    @Override
                    public List<ImgurTag> apply(@NonNull ImgurTagsResponse imgurTagsResponse) throws Exception {
                        Log.e("MVP_RX","mapping tags");
                        Log.e("MVP_RX","size: " + imgurTagsResponse.getData().getImgurTags().size());
                        List<ImgurTag> newList = new ArrayList<>();
                        for(ImgurTag tag : imgurTagsResponse.getData().getImgurTags()){
                            if(tag.getFollowers() >= 500) newList.add(tag);
                        }
                        Log.e("MVP_RX","new size: " + newList.size());
                        return newList;
                    }
                })
                .subscribeOn(Schedulers.io()) // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribe(new Consumer<List<ImgurTag>>() {
                    @Override
                    public void accept(@NonNull List<ImgurTag> imgurTags) throws Exception {
                        Log.e("MVP_RX","onNext");
                        mImgurTagsView.hideLoadingIndicator();
                        mImgurTagsView.showRecyclerView();
                        mImgurTagsView.showTags(imgurTags);
                    }
                })
                /*.subscribeWith(new DisposableObserver<List<ImgurTag>>() {
                    @Override
                    public void onNext(@NonNull List<ImgurTag> imgurTags) {
                        Log.e("MVP_RX","onNext");
                        mImgurTagsView.hideLoadingIndicator();
                        mImgurTagsView.showRecyclerView();
                        mImgurTagsView.showTags(imgurTags);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {}
                })*/
        );
    }

    private Observable<ImgurTagsResponse> getTagsObservable(){
        return ImgurService.getAPI().getImgurTags();
    }

}