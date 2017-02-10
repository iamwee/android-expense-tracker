package com.iamwee.expensetracker.base;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by zeon on 2/2/17.
 */

public class BaseFragment<CP> extends Fragment {

    private CP presenter;



    public CP getPresenter() {
        return presenter;
    }

    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }

    protected void initView(View rootView){

    }

    protected void setupView(View rootView){

    }
}
