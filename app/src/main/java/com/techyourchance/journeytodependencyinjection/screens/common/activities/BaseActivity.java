package com.techyourchance.journeytodependencyinjection.screens.common.activities;

import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.journeytodependencyinjection.MyApplication;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.CompositionRoot;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.Injector;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.PresentationCompositionRoot;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.ViewMvcFactory;

public class BaseActivity extends AppCompatActivity {

    private boolean mIsInjectorUsed;

    @UiThread
    protected Injector getInjector() {
        if (mIsInjectorUsed) {
            throw new RuntimeException("There is no need to use injector more than once");
        }
        mIsInjectorUsed = true;
        return new Injector(getCompositionRoot());
    }


    private CompositionRoot getApplicationCompositionRoot() {
        return ((MyApplication) getApplication()).getCompositionRoot();
    }

    private PresentationCompositionRoot getCompositionRoot() {
        return new PresentationCompositionRoot(getApplicationCompositionRoot(),this);
    }


}
