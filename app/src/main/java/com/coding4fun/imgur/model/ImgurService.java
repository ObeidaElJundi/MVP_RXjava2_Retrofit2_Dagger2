package com.coding4fun.imgur.model;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by coding4fun on 19-Jun-17.
 */

public class ImgurService {

    private static final String baseURL = "https://api.imgur.com/3/";

    public static ImgurAPI getAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ImgurAPI.class);
    }

    public interface ImgurAPI {

        @GET("tags/")
        @Headers("Authorization: Client-ID 01e88c6fa81118c")
        Observable<ImgurTagsResponse> getImgurTags();
        //Observable<List<ImgurTag>> getImgurTags();

        @GET("gallery/r/{tag}/top/year/1")
        @Headers("Authorization: Client-ID 01e88c6fa81118c")
        Observable<ImgurTagImagesResponse> getImgurImagesByTag(@Path("tag") String tag); //TODO

    }

}