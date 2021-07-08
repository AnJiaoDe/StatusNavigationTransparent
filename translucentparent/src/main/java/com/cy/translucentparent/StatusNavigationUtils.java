package com.cy.translucentparent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lenovo on 2017/4/25.
 */

public class StatusNavigationUtils {
    private Map<String, ViewTreeObserver.OnWindowFocusChangeListener> mapFocusListener;
    private Map<String, View.OnAttachStateChangeListener> mapAttachListener;
    private Map<String, Boolean> mapHideStatusBar;
    private Map<String, Boolean> mapHideNavigationBar;
    private Map<String, Boolean> mapFullScreen;

    private StatusNavigationUtils() {
        mapFocusListener = new HashMap<>();
        mapAttachListener = new HashMap<>();
        mapHideStatusBar = new HashMap<>();
        mapHideNavigationBar = new HashMap<>();
        mapFullScreen = new HashMap<>();
    }

    private static class StatusNavigationUtilsHolder {
        private static StatusNavigationUtils instance = new StatusNavigationUtils();
    }

    public static StatusNavigationUtils getInstance() {
        return StatusNavigationUtilsHolder.instance;
    }

    private String getKey(Object obj) {
        return obj.getClass().getName() + obj.hashCode();
    }

    /**
     * 状态栏自定义背景颜色,6.0以上可修改状态栏字体颜色，icon颜色
     *
     * @param activity
     * @param color
     */
    public void setStatusBarColor(Activity activity, int color) {
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
    public boolean isLightColor(int color) {
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
    public void setStatusBarNoFill(Activity activity) {
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
    public void setNavigationBarTransparent(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    /**
     * 设置导航栏颜色，和setNavigationBarTransparent互斥，要么选择自定义导航栏颜色，要么选择导航栏全透明
     *
     * @param activity
     * @param color
     */

    public void setNavigationBarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        int ui = window.getDecorView().getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        window.getDecorView().setSystemUiVisibility(ui);
        window.setNavigationBarColor(color);
    }


    private void addListener(final Activity activity, ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener) {
        View decorView = activity.getWindow().getDecorView();
        mapFocusListener.put(getKey(activity), onWindowFocusChangeListener);
        decorView.getViewTreeObserver().addOnWindowFocusChangeListener(onWindowFocusChangeListener);

        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                mapFocusListener.remove(getKey(activity));
                mapAttachListener.remove(getKey(activity));
                mapHideStatusBar.remove(getKey(activity));
                mapHideNavigationBar.remove(getKey(activity));
                mapFullScreen.remove(getKey(activity));
            }
        };
        mapAttachListener.put(getKey(activity), onAttachStateChangeListener);
        decorView.addOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private void hideStatusBar(final Activity activity) {
        mapHideStatusBar.put(getKey(activity),true);
        final View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 隐藏状态栏
     *
     * @param activity
     */
    public void setHideStatusBar(final Activity activity) {
        hideStatusBar(activity);
        addListener(activity, new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                if(mapHideStatusBar.get(getKey(activity)))hideStatusBar(activity);
            }
        });
    }

    /**
     * 去除隐藏状态栏的标志
     *
     * @param activity
     */
    public void setClearHideStatusBar(Activity activity) {
        mapHideStatusBar.put(getKey(activity),false);
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                & View.SYSTEM_UI_FLAG_FULLSCREEN
                & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
    private void hideNavigationBar(Activity activity) {
        mapHideNavigationBar.put(getKey(activity),true);
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
    /**
     * 隐藏导航栏
     *
     * @param activity
     */
    public void setHideNavigationBar(final Activity activity) {
        hideNavigationBar(activity);
        addListener(activity, new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                if(mapHideNavigationBar.get(getKey(activity))) hideNavigationBar(activity);
            }
        });
    }

    /**
     * 去除隐藏导航栏的标志
     *
     * @param activity
     */
    public void setClearHideNavigationBar(Activity activity) {
        mapHideNavigationBar.put(getKey(activity),false);
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    public void fullScreen(Activity activity) {
        mapFullScreen.put(getKey(activity),true);
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
     * 隐藏状态栏、导航栏，全屏
     *
     * @param activity
     */
    public void setFullScreen(final Activity activity) {
        fullScreen(activity);
        addListener(activity, new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                if(mapFullScreen.get(getKey(activity)))fullScreen(activity);
            }
        });
    }
    /**
     * 去除隐藏状态栏、导航栏，全屏的标志
     *
     * @param activity
     */
    public void setClearFullScreen(Activity activity) {
        mapFullScreen.put(getKey(activity),false);
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_FULLSCREEN
                & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
}
