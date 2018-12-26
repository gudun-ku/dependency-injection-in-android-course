package com.techyourchance.journeytodependencyinjection.networking;

import com.google.gson.annotations.SerializedName;
import com.techyourchance.journeytodependencyinjection.questions.QuestionDetails;

import java.util.Collections;
import java.util.List;

public class QuestionDetailsResponseSchema {

    @SerializedName("items")
    private final List<QuestionDetails> mQuestions;

    public QuestionDetailsResponseSchema(QuestionDetails question) {
        mQuestions = Collections.singletonList(question);
    }

    public QuestionDetails getQuestion() {
        return mQuestions.get(0);
    }
}
