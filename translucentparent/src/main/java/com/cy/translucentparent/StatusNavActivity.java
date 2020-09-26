package com.cy.translucentparent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class StatusNavActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusNavUtils.setStatusNavBarColor(this,getStatusBarColor(),getNavigationColor());
    }

    protected  int getStatusBarColor(){
        return 0xfff2f2f2;
    }
    protected  int getNavigationColor(){
        return 0xff000000;
    }
}
