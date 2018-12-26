package com.techyourchance.journeytodependencyinjection.questions;

import com.google.gson.annotations.SerializedName;

public class QuestionOwner {

    @SerializedName("display_name")
    private final String mUserDisplayName;

    @SerializedName("profile_image")
    private final String mUserAvatarUrl;

    public QuestionOwner(String userDisplayName, String userAvatarUrl) {
        mUserDisplayName = userDisplayName;
        mUserAvatarUrl = userAvatarUrl;
    }

    public String getUserDisplayName() {
        return mUserDisplayName;
    }

    public String getUserAvatarUrl() {
        return mUserAvatarUrl;
    }
}
