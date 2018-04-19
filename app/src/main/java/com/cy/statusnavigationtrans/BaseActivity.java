package com.cy.statusnavigationtrans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cy.translucentparent.StatusNavUtils;


/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusNavUtils.setStatusBarColor(this,0x00000000);
    }
    public void startAppcompatActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }


}
