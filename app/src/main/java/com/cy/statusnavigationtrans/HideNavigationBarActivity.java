package com.cy.statusnavigationtrans;

import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class HideNavigationBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_navigation_bar);
        StaNavUtils.setAppearanceLightNavigationBars(this,false);
        StaNavUtils.showNavigationBar(this,false);
    }
}
