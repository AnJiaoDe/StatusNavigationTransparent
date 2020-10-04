package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Status6Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status6);
        setStatusBarSystemNoFill();
        setStatusBarColor(0x00000000);
    }


    @Override
    public void onClick(View v) {

    }
}
