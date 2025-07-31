package com.cy.statusnavigationtrans;

import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class HideStatusBarActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_status_bar);
        StaNavUtils.showStatusBar(this,false);
        StaNavUtils.setAppearanceLightStatusBars(this,false);
    }
}