package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.bumptech.glide.request.RequestOptions;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.ViewMvcFactory;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application.ApplicationComponent;
import com.techyourchance.journeytodependencyinjection.networking.ImageLoader;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;
import com.techyourchance.journeytodependencyinjection.screens.common.dialogs.DialogsManager;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    private final FragmentActivity mActivity;
    private final ApplicationComponent mApplicationComponent;

    public PresentationModule(FragmentActivity mActivity, ApplicationComponent mApplicationComponent) {
        this.mActivity = mActivity;
        this.mApplicationComponent = mApplicationComponent;
    }


    @Provides
    public Context getContext() {
        return mActivity;
    }

    @Provides
    public DialogsManager getDialogsManager(FragmentManager fragmentManager) {
        return new DialogsManager(fragmentManager);
    }

    @Provides
    FragmentManager getFragmentManager()  {
        return mActivity.getSupportFragmentManager();
    }

    @Provides
    LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    @Provides
    Activity getActivity() {
        return mActivity;
    }

    @Provides
    FetchQuestionsListUseCase getFetchQuestionsListUseCase() {
        return mApplicationComponent.getFetchQuestionsListUseCase();
    }

    @Provides
    FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return mApplicationComponent.getFetchQuestionDetailsUseCase();
    }

    @Provides
    ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getActivity().getLayoutInflater(),
                new ImageLoader(getActivity(),new RequestOptions()));
    }

    @Provides
    ImageLoader getImageLoader(Activity activity) {
        return new ImageLoader(activity, new RequestOptions());
    }

}
