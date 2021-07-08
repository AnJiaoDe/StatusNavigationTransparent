package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavigationActivity;

public class Status00Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status00);
        //此行可不写，默认就是0xfff2f2f2
        setStatusBarColor(getStatusBarColorDefault());
    }
}
