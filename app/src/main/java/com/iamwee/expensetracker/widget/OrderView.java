package com.iamwee.expensetracker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.iamwee.expensetracker.R;
import com.iamwee.expensetracker.base.BaseCustomViewGroup;


public class OrderView extends BaseCustomViewGroup {

    private String title;
    private String value;

    public OrderView(Context context) {
        super(context);
        init();
    }

    public OrderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithStyleable(attrs);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithStyleable(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OrderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithStyleable(attrs);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        SavedState ss = new SavedState(parcelable);
        ss.title = title;
        ss.value = value;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            this.title = ss.title;
            this.value = ss.value;
        } else {
            super.onRestoreInstanceState(state);
        }
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.widget_order_view, this);
    }

    @Override
    protected void initWithStyleable(AttributeSet attr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attr, R.styleable.OrderView);

        title = typedArray.getString(R.styleable.OrderView_ov_title);
        value = typedArray.getString(R.styleable.OrderView_ov_value);
        setTitle();
        setValue();
        typedArray.recycle();
    }

    public void setTitle(String title) {
        this.title = title;
        setTitle();
    }

    public void setValue(String value) {
        this.value = value;
        setValue();
    }

    private void setTitle() {
        TextView tvTitle = (TextView) findViewById(R.id.ov_title);
        tvTitle.setText(title);
    }

    private void setValue() {
        TextView tvValue = (TextView) findViewById(R.id.ov_value);
        tvValue.setText(value);
    }

    private static class SavedState extends BaseSavedState {

        String title, value;

        SavedState(Parcel source) {
            super(source);
            title = source.readString();
            value = source.readString();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(title);
            out.writeString(value);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
