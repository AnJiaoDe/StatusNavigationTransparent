package com.cy.translucentparent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class StatusNavigationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusNavigationUtils.setStatusBarColor(this, getStatusBarColorDefault());
        StatusNavigationUtils.setNavigationBarColor(this, getNavigationBarColorDefault());
    }
    public int getStatusBarColorDefault(){
        return 0xfff2f2f2;
    }
    public int getNavigationBarColorDefault(){
        return 0xDD000000;
    }

    public void setStatusBarColor(int color) {
        StatusNavigationUtils.setStatusBarColor(this, color);
    }
    public void setNavigationBarColor(int color) {
        StatusNavigationUtils.setNavigationBarColor(this, color);
    }

    public void setFullScreen() {
        StatusNavigationUtils.setFullScreen(this);
    }
    public void setClearFullScreen() {
        StatusNavigationUtils.setClearFullScreen(this);
    }

    public void setHideStatusBar() {
        StatusNavigationUtils.setHideStatusBar(this);
    }
    public void setClearHideStatusBar() {
        StatusNavigationUtils.setClearHideStatusBar(this);
    }

    public void setHideNavigationBar() {
        StatusNavigationUtils.setHideNavigationBar(this);
    }
    public void setClearHideNavigationBar() {
        StatusNavigationUtils.setClearHideNavigationBar(this);
    }

    public void setStatusBarNoFill() {
        StatusNavigationUtils.setStatusBarNoFill(this);
    }

    public void setStatusBarNoFillAndTransParent() {
        setStatusBarNoFill();
        setStatusBarColor(0x00000000);
    }

    public void setStatusBarNoFillAndTransParentHalf() {
        setStatusBarNoFill();
        setStatusBarColor(0x33000000);
    }

    public  void setNavigationBarTransparent() {
        StatusNavigationUtils.setNavigationBarTransparent(this);
    }
}
