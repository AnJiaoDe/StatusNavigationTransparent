package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;
import com.cy.translucentparent.StatusNavUtils;

public class Status00Activity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status00);
        //此行可不写，默认就是0xfff2f2f2
        setStatusBarColor(0xfff2f2f2);
    }

    @Override
    public void onClick(View v) {

    }
}
