package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavUtils;

public class Navigation2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        StatusNavUtils.setNavigationBarColor(this,0x00000000);

    }

    @Override
    public void onClick(View v) {

    }
}
