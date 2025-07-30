package com.cy.statusnavigationtrans;

import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class Status6Activity extends BaseActivity {

    @Override
    public boolean addStatusBarView() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status6);
        StaNavUtils.setAppearanceLightStatusBars(this,false);
    }
}
