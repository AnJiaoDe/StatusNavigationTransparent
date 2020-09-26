package com.cy.statusnavigationtrans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavActivity;
import com.cy.translucentparent.StatusNavUtils;

public class MainActivity extends StatusNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_00).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        StatusNavUtils.setStatusBarColor(this,0xfff2f2f2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_00:
                startActivity(new Intent(this,Status00Activity.class));
                break;
            case R.id.btn_0:
                startActivity(new Intent(this,Status0Activity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this,Status2Activity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(this,Status5Activity.class));
                break;
            case R.id.btn_6:
                startActivity(new Intent(this,Status6Activity.class));
                break;
            case R.id.btn_7:
                startActivity(new Intent(this,Navigation1Activity.class));
                break;
            case R.id.btn_8:
                startActivity(new Intent(this,Navigation2Activity.class));
                break;
        }
    }
}
