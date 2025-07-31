package com.cy.statusnavigationtrans;

import android.graphics.Color;
import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class Status0Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaNavUtils.setStatusBarColor(this,Color.RED);
        setContentView(R.layout.activity_status0);
    }
}
