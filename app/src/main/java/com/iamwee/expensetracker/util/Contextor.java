package com.iamwee.expensetracker.util;

import android.content.Context;

/**
 * Created by zeon on 2/2/17.
 */

public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance(){
        if (instance == null) instance = new Contextor();
        return instance;
    }

    private Context context;

    public void init(Context context){
        this.context = context.getApplicationContext();
    }

    public Context getContext(){
        return this.context;
    }
}
