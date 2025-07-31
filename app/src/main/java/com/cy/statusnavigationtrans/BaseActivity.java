package com.cy.statusnavigationtrans;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cy.translucentparent.StaNavUtils;

/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity   {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaNavUtils.edgeToEdge(this);
    }
}
