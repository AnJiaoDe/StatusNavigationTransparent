package com.cy.translucentparent;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class StatusNavActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout rootView;
    private StatusBarView statusBarView;
    private NavigationBarView navigationBarView;
    private boolean statusBarSystemFill = true;
    private boolean navigationBarSystemFill = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.translucentparent_base_activity);
        rootView = findViewById(R.id.translucentparent_cy_ll);
        StatusNavUtils.setStatusBarColor(this, 0xfff2f2f2);
        StatusNavUtils.setNavigationBarColor(this, 0x00000000);
        statusBarView = findViewById(R.id.translucentparent_cy_sbv);
        navigationBarView = findViewById(R.id.translucentparent_cy_nbv);
        statusBarView.setBackgroundColor(0xfff2f2f2);
        navigationBarView.setBackgroundColor(0xff000000);
    }

    @Override
    public void setContentView(View view) {
        rootView.addView(view, 1, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
    }

    @Override
    public void setContentView(int layoutResID) {
        rootView.addView(LayoutInflater.from(this).inflate(layoutResID, rootView, false)
                , 1, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        rootView.addView(view, 1, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
    }

    public void setStatusBarColor(int color) {
        if (statusBarSystemFill) {
            statusBarView.setBackgroundColor(color);
        }
        StatusNavUtils.setStatusBarColor(this, color);
    }

    public void setNavigationBarColor(int color) {
        if (navigationBarSystemFill) {
            navigationBarView.setBackgroundColor(color);
        } else {
            StatusNavUtils.setNavigationBarColor(this, color);
        }
    }

    public boolean isStatusBarSystemFill() {
        return statusBarSystemFill;
    }

    public boolean isNavigationBarSystemFill() {
        return navigationBarSystemFill;
    }

    public void setStatusBarSystemFill() {
        this.statusBarSystemFill = true;
        statusBarView.setVisibility(View.VISIBLE);
        statusBarView.setBackgroundColor(0xfff2f2f2);
    }

    public void setStatusBarSystemNoFill() {
        this.statusBarSystemFill = false;
        statusBarView.setVisibility(View.GONE);
    }

    public void setNavigationBarSystemFill() {
        this.navigationBarSystemFill = true;
        navigationBarView.setVisibility(View.VISIBLE);
        navigationBarView.setBackgroundColor(0xff000000);
    }

    public void setNavigationBarSystemNoFill() {
        this.navigationBarSystemFill = false;
        navigationBarView.setVisibility(View.GONE);
    }

    public LinearLayout getRootView() {
        return rootView;
    }

    public StatusBarView getStatusBarView() {
        return statusBarView;
    }

    public NavigationBarView getNavigationBarView() {
        return navigationBarView;
    }

    public  void setFullScreen() {
        setStatusBarSystemNoFill();
        setNavigationBarSystemNoFill();
        StatusNavUtils.setFullScreen(this);
    }
    public  void setHideStatusBar() {
        setStatusBarSystemNoFill();
        StatusNavUtils.setHideStatusBar(this);
    }
    public  void setHideNavigationBar() {
        setNavigationBarSystemNoFill();
        StatusNavUtils.setHideNavigationBar(this);
    }

}
