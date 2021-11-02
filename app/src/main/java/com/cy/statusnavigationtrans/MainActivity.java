package com.cy.statusnavigationtrans;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StatusNavigationActivity;

public class MainActivity extends StatusNavigationActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNavigationBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_00).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
//        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_10).setOnClickListener(this);
        findViewById(R.id.btn_11).setOnClickListener(this);
        findViewById(R.id.btn_12).setOnClickListener(this);
        findViewById(R.id.btn_13).setOnClickListener(this);
//        StatusNavigationUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        setStatusBarColor(getResources().getColor(R.color.theme));
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
                startActivity(new Intent(this,Navigation0Activity.class));
                break;
//            case R.id.btn_8:
//                startActivity(new Intent(this,Navigation1Activity.class));
//                break;
            case R.id.btn_9:
                startActivity(new Intent(this,Navigation2Activity.class));
                break;
            case R.id.btn_10:
                startActivity(new Intent(this,HideStatusBarActivity.class));
                break;
            case R.id.btn_11:
                startActivity(new Intent(this,HideNavigationBarActivity.class));
                break;
            case R.id.btn_12:
                startActivity(new Intent(this,FullScreenActivity.class));
                break;
            case R.id.btn_13:
                startActivity(new Intent(this,StatusNavigationSwitchActivity.class));
                break;
        }
    }
}
