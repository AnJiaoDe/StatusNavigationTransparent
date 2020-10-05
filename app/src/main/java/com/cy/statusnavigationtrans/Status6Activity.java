package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavigationActivity;

public class Status6Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status6);
        setStatusBarNoFillAndTransParent();
    }


    @Override
    public void onClick(View v) {

    }
}
