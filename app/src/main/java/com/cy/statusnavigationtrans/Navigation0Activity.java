package com.cy.statusnavigationtrans;

import android.graphics.Color;
import android.os.Bundle;

public class Navigation0Activity extends BaseActivity {
    @Override
    public int setNavigationBarColor() {
        return Color.RED;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation0);
    }
}
