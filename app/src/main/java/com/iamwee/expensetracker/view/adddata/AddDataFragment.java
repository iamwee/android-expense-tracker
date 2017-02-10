package com.iamwee.expensetracker.view.adddata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamwee.expensetracker.R;
import com.iamwee.expensetracker.base.BaseFragment;

/**
 * Created by zeon on 2/3/17.
 */

public class AddDataFragment extends BaseFragment {

    public AddDataFragment() {
    }

    public static AddDataFragment newInstance() {
        Bundle args = new Bundle();
        AddDataFragment fragment = new AddDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_data, container, false);
        initView(rootView);
        setupView(rootView);
        return rootView;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void setupView(View rootView) {

    }
}
