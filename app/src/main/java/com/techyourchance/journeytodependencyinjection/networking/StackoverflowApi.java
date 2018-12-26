package com.techyourchance.journeytodependencyinjection.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackoverflowApi {

    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    Call<QuestionsListResponseSchema> lastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("/questions/{questionId}?site=stackoverflow&filter=!9YdnSJ*_T")
    Call<QuestionDetailsResponseSchema> questionDetails(@Path("questionId") String questionId);

}
