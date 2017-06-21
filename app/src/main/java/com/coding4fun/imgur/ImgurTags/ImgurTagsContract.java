package com.coding4fun.imgur.ImgurTags;

import com.coding4fun.imgur.BasePresenter;
import com.coding4fun.imgur.BaseView;

import java.util.List;

/**
 * Created by coding4fun on 19-Jun-17.
 */

public interface ImgurTagsContract {

    interface View extends BaseView<Presenter> {

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showRecyclerView();

        void hideRecyclerView();

        void showTags(List<ImgurTag> tags);

        void openTagImagesActivity(ImgurTag tag);

    }



    interface Presenter extends BasePresenter {

        void openTagImages(ImgurTag tag);

    }

}