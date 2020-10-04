package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Navigation1Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav1);
        setStatusBarSystemNoFill();
        setStatusBarColor(0x00000000);
        setNavigationBarSystemNoFill();
        setNavigationBarColor(0x33000000);
    }



    @Override
    public void onClick(View v) {

    }
}
