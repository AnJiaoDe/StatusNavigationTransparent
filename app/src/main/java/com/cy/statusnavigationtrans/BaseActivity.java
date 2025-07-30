package com.cy.statusnavigationtrans;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cy.translucentparent.StaNavUtils;

/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity  implements StaNavUtils.Callback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaNavUtils.edgeToEdge(this,this);
    }
    @Override
    public boolean addStatusBarView() {
        return true;
    }

    @Override
    public boolean addNavigationBarView() {
        return true;
    }

    @Override
    public int setStatusBarColor() {
        return 0xffffffff;
    }

    @Override
    public int setNavigationBarColor() {
        return 0xffffffff;
    }
}
