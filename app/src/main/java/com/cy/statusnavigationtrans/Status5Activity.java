package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Status5Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status5);
        setStatusBarSystemNoFill();
        setStatusBarColor(0x33000000);
    }

    @Override
    public void onClick(View v) {

    }
}
