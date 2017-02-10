package com.iamwee.expensetracker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iamwee.expensetracker.R;
import com.iamwee.expensetracker.base.BaseCustomViewGroup;


public class ExpenseView extends BaseCustomViewGroup implements View.OnClickListener {

    private String title;
    private String amount;
    private String description;
    private boolean isExpenseList;
    private boolean canEditable;

    private OnExpenseActionClickListener listener;

    public ExpenseView(Context context) {
        super(context);
        init();
    }

    public ExpenseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithStyleable(attrs);
    }

    public ExpenseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithStyleable(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExpenseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithStyleable(attrs);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        SavedState ss = new SavedState(parcelable);
        ss.title = title;
        ss.amount = amount;
        ss.description = description;
        ss.isExpenseList = isExpenseList;
        ss.canEditable = canEditable;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            title = ss.title;
            amount = ss.amount;
            description = ss.description;
            isExpenseList = ss.isExpenseList;
            canEditable = ss.canEditable;
        } else {
            super.onRestoreInstanceState(state);
        }
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.widget_expense_view, this);
    }

    @Override
    protected void initWithStyleable(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ExpenseView);

        title = typedArray.getString(R.styleable.ExpenseView_ev_title);
        amount = typedArray.getString(R.styleable.ExpenseView_ev_amount);
        description = typedArray.getString(R.styleable.ExpenseView_ev_description);
        isExpenseList = typedArray.getBoolean(R.styleable.ExpenseView_ev_isExpenseList, true);
        canEditable = typedArray.getBoolean(R.styleable.ExpenseView_ev_expenseCanEditable, false);
        setupView();
        typedArray.recycle();
    }

    @Override
    protected void setupView() {
        setTitle();
        setAmount();
        setDescription();
        setCanEditable();
        setExpanseList();
    }

    public void setOnClickListener(OnExpenseActionClickListener listener) {
        this.listener = listener;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpenseList(boolean expenseList) {
        isExpenseList = expenseList;
    }

    public void setCanEditable(boolean canEditable) {
        this.canEditable = canEditable;
    }

    private void setTitle() {
        TextView tvTitle = (TextView) findViewById(R.id.ev_title);
        tvTitle.setText(title);
    }

    private void setAmount() {
        TextView tvAmount = (TextView) findViewById(R.id.ev_amount);
        tvAmount.setText(amount);
    }

    private void setDescription() {
        TextView tvDescription = (TextView) findViewById(R.id.ev_description);
        tvDescription.setText(description);
    }

    private void setExpanseList() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ev_section);
        int color;
        if (isExpenseList) {
            color = ContextCompat.getColor(getContext(), R.color.red);
        } else {
            color = ContextCompat.getColor(getContext(), R.color.green);
        }
        linearLayout.setBackgroundColor(color);
    }

    private void setCanEditable() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ev_action);
        if (canEditable) {
            linearLayout.setVisibility(VISIBLE);
            findViewById(R.id.ev_edit).setOnClickListener(this);
            findViewById(R.id.ev_delete).setOnClickListener(this);
        } else {
            linearLayout.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ev_edit) {
            if (listener != null) listener.onEditClick(this);
        } else if (id == R.id.ev_delete) {
            if (listener != null) listener.onDeleteClick(this);
        }
    }

    private static class SavedState extends BaseSavedState {

        String title;
        String amount;
        String description;
        boolean isExpenseList;
        boolean canEditable;

        SavedState(Parcel source) {
            super(source);
            title = source.readString();
            amount = source.readString();
            description = source.readString();
            isExpenseList = source.readByte() == 1;
            canEditable = source.readByte() == 1;
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(title);
            out.writeString(amount);
            out.writeString(description);
            out.writeByte((byte) (isExpenseList ? 1 : 0));
            out.writeByte((byte) (canEditable ? 1 : 0));
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[0];
            }
        };
    }

    public interface OnExpenseActionClickListener {

        void onEditClick(View view);

        void onDeleteClick(View view);
    }
}
