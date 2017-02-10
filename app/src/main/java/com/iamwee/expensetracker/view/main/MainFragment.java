package com.iamwee.expensetracker.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamwee.expensetracker.R;
import com.iamwee.expensetracker.base.BaseFragment;
import com.iamwee.expensetracker.event.OpenActivity;

import org.greenrobot.eventbus.EventBus;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView(rootView);
        setupView(rootView);
        return rootView;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void setupView(View rootView) {
        rootView.findViewById(R.id.fab_add).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab_add){
            EventBus.getDefault().post(new OpenActivity(OpenActivity.ADD_DATA_ACTIVITY));
        }
    }
}
