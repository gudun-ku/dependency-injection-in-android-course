package com.techyourchance.journeytodependencyinjection.common.dependencyinjection;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;
import com.techyourchance.journeytodependencyinjection.screens.common.dialogs.DialogsManager;


public class PresentationCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final AppCompatActivity mActivity;

    public PresentationCompositionRoot(CompositionRoot compositionRoot,
                                        AppCompatActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public Context getContext() {
        return mActivity;
    }

    public DialogsManager getDialogsManager() {
        return new DialogsManager(getActivity().getSupportFragmentManager());
    }

    public FetchQuestionsListUseCase getFetchQuestionsListUseCase() {
        return mCompositionRoot.getFetchQuestionsListUseCase();
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return mCompositionRoot.getFetchQuestionDetailsUseCase();
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getActivity().getLayoutInflater());
    }


}
