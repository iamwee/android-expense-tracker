package com.iamwee.expensetracker;

import android.app.Application;

import com.iamwee.expensetracker.util.Contextor;

/**
 * Created by zeon on 2/2/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
    }
}
