package com.cy.statusnavigationtrans;

import android.os.Bundle;

import com.cy.translucentparent.StaNavUtils;

public class Navigation2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        StaNavUtils.setNavigationBarTransparent(this,false);
    }

}
