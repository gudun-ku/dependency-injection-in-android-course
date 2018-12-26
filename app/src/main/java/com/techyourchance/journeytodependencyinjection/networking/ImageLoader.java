package com.techyourchance.journeytodependencyinjection.networking;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {

    private final AppCompatActivity mActivity;

    private final RequestOptions mDefaultRequestOptions;

    public ImageLoader(AppCompatActivity activity, RequestOptions defaultRequestOptions) {
        mActivity = activity;
        mDefaultRequestOptions = new RequestOptions().centerCrop();
    }

    public void loadImage(String url, ImageView target) {
        Glide.with(mActivity).load(url).apply(mDefaultRequestOptions).into(target);
    }
}
