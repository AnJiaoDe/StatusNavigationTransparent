package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class HideStatusBarActivity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_status_bar);
        setHideStatusBar();
        setNavigationBarSystemNoFill();
        setNavigationBarColor(0x11000000);
    }

    @Override
    public void onClick(View v) {

    }
}
