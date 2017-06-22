package com.coding4fun.imgur.ImgurTagImages;

import com.coding4fun.imgur.BasePresenter;
import com.coding4fun.imgur.BaseView;

import java.util.List;

/**
 * Created by coding4fun on 22-Jun-17.
 */

public class ImgurTagImagesContract {

    interface View extends BaseView<ImgurTagImagesContract.Presenter> {

        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showRecyclerView();

        void hideRecyclerView();

        void showImages(List<ImgurImage> images);

        void openImageDialog(ImgurImage image);

    }



    interface Presenter extends BasePresenter {

        void imageClicked(ImgurImage image);

    }

}