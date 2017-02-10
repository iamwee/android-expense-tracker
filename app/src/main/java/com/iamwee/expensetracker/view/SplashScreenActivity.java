package com.iamwee.expensetracker.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.iamwee.expensetracker.view.main.MainActivity;
import com.iamwee.expensetracker.base.BaseActivity;

public class SplashScreenActivity extends BaseActivity {

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                openActivity(new Intent(
                        SplashScreenActivity.this, MainActivity.class),
                        true,
                        false
                );
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (handler != null) handler.sendEmptyMessageDelayed(1, 500);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(handler != null) handler.removeMessages(1);
    }
}
