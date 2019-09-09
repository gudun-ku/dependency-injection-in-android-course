package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application;


import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    public FetchQuestionsListUseCase getFetchQuestionsListUseCase();
    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase();
}
