package com.techyourchance.journeytodependencyinjection.screens.common.activities;

import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.journeytodependencyinjection.MyApplication;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.Injector;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application.ApplicationComponent;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation.DaggerPresentationComponent;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation.PresentationComponent;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation.PresentationModule;

public class BaseActivity extends AppCompatActivity {

    private boolean mIsInjectorUsed;

    @UiThread
    protected Injector getInjector() {
        if (mIsInjectorUsed) {
            throw new RuntimeException("There is no need to use injector more than once");
        }
        mIsInjectorUsed = true;
        return new Injector(getPresentationComponent());
    }


    private ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    private PresentationComponent getPresentationComponent() {
        return DaggerPresentationComponent.builder()
                .presentationModule(new PresentationModule(this, getApplicationComponent()))
                .build();

    }

}
