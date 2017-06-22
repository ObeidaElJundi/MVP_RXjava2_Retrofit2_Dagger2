package com.coding4fun.imgur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.coding4fun.imgur.ImgurTags.ImgurTagsActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by coding4fun on 21-Jun-17.
 */

public class Splash extends AppCompatActivity {

    @BindView(R.id.splash_icon) ImageView splashIcon;
    @BindView(R.id.splash_text) TextView splashText;
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);

        animateLogoIn();
        animateTextIn();
        disposable = Observable
                .timer(3, TimeUnit.SECONDS) // emits 0L after a specified delay (3 seconds in this case)
                //.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) //needed for Timer runs on computation thread by default
                // (see: http://reactivex.io/documentation/scheduler.html). So to update UI, go back to mainThread.
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        animateLogoOutThenExitActivity();
                    }
                });
    }

    private void animateLogoIn(){
        TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_PARENT, -1f,
                Animation.RELATIVE_TO_SELF, 0f);
        anim.setDuration(1000);
        anim.setStartOffset(111);
        anim.setInterpolator(new DecelerateInterpolator());
        splashIcon.startAnimation(anim);
    }

    private void animateLogoOutThenExitActivity(){
        RotateAnimation rotate = new RotateAnimation(0f,360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ScaleAnimation scale = new ScaleAnimation(1f, 5f,
                1f, 5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.setDuration(1111);
        set.setFillAfter(true);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(Splash.this, ImgurTagsActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        splashIcon.startAnimation(set);
    }

    private void animateTextIn(){
        TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 1,
                Animation.RELATIVE_TO_SELF, 0);
        anim.setDuration(1000);
        anim.setStartOffset(222);
        anim.setInterpolator(new DecelerateInterpolator());
        splashText.startAnimation(anim);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //do nothing
    }

    @Override
    protected void onDestroy() {
        if(disposable != null && !disposable.isDisposed()){
            disposable.dispose(); //unsubscribe
        }
        super.onDestroy();
    }
}