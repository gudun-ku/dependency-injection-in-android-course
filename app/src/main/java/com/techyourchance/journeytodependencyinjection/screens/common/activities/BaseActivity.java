package com.techyourchance.journeytodependencyinjection.screens.common.activities;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.journeytodependencyinjection.MyApplication;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.CompositionRoot;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.Injector;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.PresentationCompositionRoot;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.ViewMvcFactory;

public class BaseActivity extends AppCompatActivity {

    private CompositionRoot getApplicationCompositionRoot() {
        return ((MyApplication) getApplication()).getCompositionRoot();
    }

    private PresentationCompositionRoot getCompositionRoot() {
        return new PresentationCompositionRoot(((MyApplication) getApplication()).getCompositionRoot(),
                this);
    }

    private ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(this.getLayoutInflater(), getCompositionRoot().getImageLoader(this));
    }


    protected Injector getInjector() {
        return new Injector(getCompositionRoot());
    }


}
