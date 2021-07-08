package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavigationActivity;

public class Status5Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status5);
        setStatusBarNoFillAndTransParentHalf();
        //或者写2行
//        setStatusBarNoFill();
//        setStatusBarColor(0x33000000);
    }
}
