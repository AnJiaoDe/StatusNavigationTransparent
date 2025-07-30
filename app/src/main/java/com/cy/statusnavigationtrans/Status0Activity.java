package com.cy.statusnavigationtrans;

import android.graphics.Color;
import android.os.Bundle;

public class Status0Activity extends BaseActivity {
    @Override
    public int setStatusBarColor() {
        return Color.RED;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status0);
    }
}
