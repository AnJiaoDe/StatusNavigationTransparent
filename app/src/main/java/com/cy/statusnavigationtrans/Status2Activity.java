package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import androidx.core.view.ViewCompat;

import com.cy.translucentparent.StatusNavigationActivity;

public class Status2Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status2);
        setStatusBarNoFillAndTransParentHalf();
    }

}
