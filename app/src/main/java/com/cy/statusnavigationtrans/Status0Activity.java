package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;

public class Status0Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status0);
        setStatusBarColor(getResources().getColor(R.color.theme));
    }


    @Override
    public void onClick(View v) {

    }
}
