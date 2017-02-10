package com.iamwee.expensetracker.base;

import android.content.Context;

import com.iamwee.expensetracker.util.Contextor;

/**
 * Created by zeon on 2/2/17.
 */

public class BasePresenter<CV extends BaseViewImpl> {

    private CV view;

    public BasePresenter(CV view) {
        this.view = view;
    }

    public CV getView() {
        return view;
    }

    public void setView(CV view) {
        this.view = view;
    }

    public Context getContext(){
        return Contextor.getInstance().getContext();
    }
}
