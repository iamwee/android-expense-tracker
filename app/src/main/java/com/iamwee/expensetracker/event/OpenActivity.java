package com.iamwee.expensetracker.event;

/**
 * Created by zeon on 2/2/17.
 */

public class OpenActivity {

    public static final int ADD_DATA_ACTIVITY = 1;
    private int status;

    public OpenActivity(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
