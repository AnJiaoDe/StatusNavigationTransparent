package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Navigation0Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation0);
        setNavigationBarColor(0xffff0000);
    }

    @Override
    public void onClick(View v) {

    }
}
