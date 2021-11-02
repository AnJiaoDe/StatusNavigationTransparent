package com.cy.translucentparent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by lenovo on 2017/4/25.
 */

public abstract class StatusNavigationActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusNavigationUtils.getInstance().setStatusBarColor(this, getStatusBarColorDefault());
        StatusNavigationUtils.getInstance().setNavigationBarColor(this, getNavigationBarColorDefault());
    }
    public int getStatusBarColorDefault(){
        return 0xffffffff;
    }
    public int getNavigationBarColorDefault(){
        return 0xffffffff;
    }

    public void setStatusBarColor(int color) {
        StatusNavigationUtils.getInstance().setStatusBarColor(this, color);
    }
    public void setNavigationBarColor(int color) {
        StatusNavigationUtils.getInstance().setNavigationBarColor(this, color);
    }

    public void setFullScreen() {
        StatusNavigationUtils.getInstance().setFullScreen(this);
    }
    public void setClearFullScreen() {
        StatusNavigationUtils.getInstance().setClearFullScreen(this);
    }

    public void setHideStatusBar() {
        StatusNavigationUtils.getInstance().setHideStatusBar(this);
    }
    public void setClearHideStatusBar() {
        StatusNavigationUtils.getInstance().setClearHideStatusBar(this);
    }

    public void setHideNavigationBar() {
        StatusNavigationUtils.getInstance().setHideNavigationBar(this);
    }
    public void setClearHideNavigationBar() {
        StatusNavigationUtils.getInstance().setClearHideNavigationBar(this);
    }

    public void setStatusBarNoFill() {
        StatusNavigationUtils.getInstance().setStatusBarNoFill(this);
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
        StatusNavigationUtils.getInstance().setNavigationBarTransparent(this);
    }
}
