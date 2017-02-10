package com.iamwee.expensetracker.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.iamwee.expensetracker.R;


public class BaseActivity extends AppCompatActivity {

    private static final long ACTIVITY_DELAY = 200;
    private boolean delaying = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
    }

    protected void initView() {
    }

    protected void setupView() {
    }

    protected void openActivity(Intent intent) {
        openActivity(intent, false, true);
    }

    protected void openActivity(Intent intent, boolean finish) {
        openActivity(intent, finish, true);
    }

    protected void openActivity(final Intent intent, final boolean finish, boolean delay) {

        if (delaying) return;
        if (delay) {
            new Handler(getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    if (finish) finish();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    toggle();
                }
            }, ACTIVITY_DELAY);
            toggle();
        } else {
            startActivity(intent);
            if (finish) finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    private void toggle() {
        this.delaying = !this.delaying;
    }
}
