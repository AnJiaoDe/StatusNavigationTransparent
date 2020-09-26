package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Navigation2Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);


    }

    @Override
    protected int getNavigationColor() {
        return 0x00000000;
    }

    @Override
    public void onClick(View v) {

    }
}
