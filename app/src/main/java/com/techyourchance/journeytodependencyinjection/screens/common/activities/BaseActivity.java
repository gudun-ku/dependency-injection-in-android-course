package com.techyourchance.journeytodependencyinjection.screens.common.activities;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.journeytodependencyinjection.MyApplication;
import com.techyourchance.journeytodependencyinjection.common.dependencyinjection.PresentationCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    protected PresentationCompositionRoot getCompositionRoot() {
        return ((MyApplication) getApplication()).getCompositionRoot().getPresentationCompositionRoot(this);
    }
}
