package com.cy.translucentparent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.ParcelUuid;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by lenovo on 2017/4/25.
 */

public class StatusNavigationUtils {


    /**
     * 状态栏自定义背景颜色,6.0以上可修改状态栏字体颜色，icon颜色
     *
     * @param activity
     * @param color
     */
    public static void setStatusBarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        //去除statusbar不填充的标志
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int ui = window.getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightColor(color)) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体的颜色为黑色
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
            }
        }
        window.getDecorView().setSystemUiVisibility(ui);
        window.setStatusBarColor(color);
    }

    /**
     * 判断颜色是否为亮色
     *
     * @param color
     * @return
     */
    public static boolean isLightColor(int color) {
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        if (darkness < 0.5) {
            return true; // It's a light color
        } else {
            return false; // It's a dark color
        }
    }

    /**
     * * 状态栏不填充，布局会填充到状态栏底部，有些手机有阴影
     *
     * @param activity
     */
    public static void setStatusBarNoFill(Activity activity) {
        Window window = activity.getWindow();
        int ui = window.getDecorView().getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        window.getDecorView().setSystemUiVisibility(ui);
    }

    /**
     * * 导航栏全透明，布局会填充到导航栏底部，有些手机有阴影
     *
     * @param activity
     */
    public static void setNavigationBarTransparent(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    /**
     * 设置导航栏颜色，和setNavigationBarTransparent互斥，要么选择自定义导航栏颜色，要么选择导航栏全透明
     *
     * @param activity
     * @param color
     */

    public static void setNavigationBarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        int ui = window.getDecorView().getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        window.getDecorView().setSystemUiVisibility(ui);
        window.setNavigationBarColor(color);
    }

    /**
     * 隐藏状态栏、导航栏，全屏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 去除隐藏状态栏、导航栏，全屏的标志
     *
     * @param activity
     */
    public static void setClearFullScreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_FULLSCREEN
                & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 隐藏状态栏
     *
     * @param activity
     */
    public static void setHideStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 去除隐藏状态栏的标志
     *
     * @param activity
     */
    public static void setClearHideStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                & View.SYSTEM_UI_FLAG_FULLSCREEN
                & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 隐藏导航栏
     *
     * @param activity
     */
    public static void setHideNavigationBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 去除隐藏导航栏的标志
     *
     * @param activity
     */
    public static void setClearHideNavigationBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
}
