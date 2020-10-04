package com.cy.statusnavigationtrans;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;
import com.cy.translucentparent.StatusNavUtils;

public class FullScreenActivity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        setFullScreen();
    }

    @Override
    public void onClick(View v) {

    }
}
