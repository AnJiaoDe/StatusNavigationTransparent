package com.cy.statusnavigationtrans;

import android.graphics.Color;
import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class Navigation0Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation0);
        StaNavUtils.setNavigationBarColor(this,Color.RED);
    }
}
