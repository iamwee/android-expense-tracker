package com.iamwee.expensetracker.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class BaseCustomViewGroup extends FrameLayout {

    public BaseCustomViewGroup(Context context) {
        super(context);
    }

    public BaseCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected abstract void init();

    protected abstract void initWithStyleable(AttributeSet attrs);

    protected void setupView() {
    }
}
