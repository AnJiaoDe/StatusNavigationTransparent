package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavUtils;

public class Navigation1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status7);

        StatusNavUtils.setNavigationBarColor(this,0x33000000);
    }

    @Override
    public void onClick(View v) {

    }
}
