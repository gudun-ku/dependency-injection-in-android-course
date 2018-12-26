package com.techyourchance.journeytodependencyinjection.common.dependencyinjection;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.journeytodependencyinjection.networking.ImageLoader;
import com.techyourchance.journeytodependencyinjection.screens.common.mvcviews.ViewMvc;
import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsViewMvc;
import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;
    private final ImageLoader mImageLoader;

    public ViewMvcFactory(LayoutInflater layoutInflater,
                          ImageLoader imageLoader
                        ) {
        mLayoutInflater = layoutInflater;
        mImageLoader = imageLoader;
    }

    public <T extends ViewMvc> T newInstance(Class<T> mvcViewClass, @Nullable ViewGroup container) {
        ViewMvc viewMvc;

        if (mvcViewClass == QuestionsListViewMvc.class) {
            viewMvc = new QuestionsListViewMvcImpl(mLayoutInflater,container);
        }
        else if (mvcViewClass == QuestionDetailsViewMvc.class) {
            viewMvc = new QuestionDetailsViewMvcImpl(mLayoutInflater,container, mImageLoader);
        }
        else {
            throw new IllegalArgumentException("unsupported MVC view class: " + mvcViewClass);
        }

        return (T) viewMvc;
    }
}
