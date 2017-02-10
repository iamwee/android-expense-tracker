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

/**
 * Created by zeon on 2/2/17.
 */

public class SectionView extends BaseCustomViewGroup {

    private String section;

    public SectionView(Context context) {
        super(context);
        init();
    }

    public SectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithStyleable(attrs);
    }

    public SectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithStyleable(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SectionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithStyleable(attrs);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        SavedState ss = new SavedState(parcelable);
        ss.section = section;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            section = ss.section;
        } else {
            super.onRestoreInstanceState(state);
        }
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.widget_section_view, this);
    }

    @Override
    protected void initWithStyleable(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SectionView);

        section = typedArray.getString(R.styleable.SectionView_sv_section);
        setSection();
        typedArray.recycle();
    }

    public void setSection(String section) {
        this.section = section;
    }

    private void setSection() {
        TextView tvSection = (TextView) findViewById(R.id.sv_section);
        tvSection.setText(section);
    }

    private static class SavedState extends BaseSavedState {

        String section;

        SavedState(Parcel source) {
            super(source);
            section = source.readString();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(section);
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
