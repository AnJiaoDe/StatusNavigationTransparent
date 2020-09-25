package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cy.translucentparent.StatusNavActivity;
import com.cy.translucentparent.StatusNavUtils;

public class Status00Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status00);
        StatusNavUtils.setStatusBarColor(this,0xfff2f2f2);
    }
}
