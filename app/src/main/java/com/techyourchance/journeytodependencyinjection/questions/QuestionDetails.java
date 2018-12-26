package com.techyourchance.journeytodependencyinjection.questions;

import com.google.gson.annotations.SerializedName;

public class QuestionDetails {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("question_id")
    private final String mId;

    @SerializedName("body")
    private final String mBody;

    @SerializedName("body_markdown")
    private final String mBodyMarkdown;

    @SerializedName("owner")
    private final QuestionOwner mOwner;

    public QuestionDetails(String title, String id, String body,String bodyMarkdown, QuestionOwner owner) {
        mTitle = title;
        mId = id;
        mBody = body;
        mBodyMarkdown = bodyMarkdown;
        mOwner = owner;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }

    public String getBody() {
        return mBody;
    }

    public String getBodyMarkdown() {
        return mBodyMarkdown;
    }

    public QuestionOwner getOwner() { return mOwner; }
}
