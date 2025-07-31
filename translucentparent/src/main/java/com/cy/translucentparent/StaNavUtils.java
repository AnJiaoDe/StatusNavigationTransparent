package com.cy.translucentparent;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Insets;
import android.icu.text.IDNA;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.net.IDN;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by lenovo on 2017/4/25. 做安卓开发，至少有一半的时间都在折腾适配问题，垃圾安卓，垃圾就是垃圾，永远都是垃圾
 */

public class StaNavUtils {
    private static final @IdRes int ID_STATUSBAR = R.id.s_t_a_t_u_s_b_a_r;
    private static final @IdRes int ID_NAVIGATIONBAR = R.id.n_a_v_i_g_a_t_i_o_n_b_a_r;

    public static void edgeToEdge(ComponentActivity componentActivity) {
        EdgeToEdge.enable(componentActivity);

        ViewGroup decorView = (ViewGroup) componentActivity.getWindow().getDecorView();
        View decorChild = decorView.getChildAt(0);
        decorView.removeView(decorChild);

        LinearLayout linearLayout = new LinearLayout(componentActivity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        StatusBarView statusBarView = new StatusBarView(componentActivity);
        statusBarView.setId(ID_STATUSBAR);
//        statusBarView.setBackgroundColor(Color.WHITE);
//        setAppearanceLightStatusBars(componentActivity, true);
        setStatusBarColor(componentActivity, Color.WHITE);
        linearLayout.addView(statusBarView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        layoutParams.weight = 1;
        linearLayout.addView(decorChild, layoutParams);

        NavigationBarView navigationBarView = new NavigationBarView(componentActivity);
        navigationBarView.setId(ID_NAVIGATIONBAR);
        //这样会是半透明的，不好看
//            navigationBarView.setBackgroundColor(callback.setNavigationBarColor());
//        setAppearanceLightNavigationBars(componentActivity, isLightColor(callback.setNavigationBarColor()));
        setNavigationBarColor(componentActivity, Color.WHITE);
        linearLayout.addView(navigationBarView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        decorView.addView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    /**
     * @param activity
     * @param isLight  false,就是让文字图标变成亮色
     */
    public static void setAppearanceLightStatusBars(Activity activity, boolean isLight) {
        Window window = activity.getWindow();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
        controller.setAppearanceLightStatusBars(isLight);
    }

    /**
     * @param activity
     * @param isLight  false,就是让图标变成亮色
     */
    public static void setAppearanceLightNavigationBars(Activity activity, boolean isLight) {
        Window window = activity.getWindow();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
        controller.setAppearanceLightNavigationBars(isLight);
    }

    public static void showStatusBar(Activity activity, boolean show) {
        Window window = activity.getWindow();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
        View view_statusbar = null;
        try {
            view_statusbar = activity.findViewById(ID_STATUSBAR);
        } catch (Exception e) {

        }
        if (show) {
            controller.show(WindowInsetsCompat.Type.statusBars());
        } else {
            if (view_statusbar != null) view_statusbar.setVisibility(View.GONE);

            controller.hide(WindowInsetsCompat.Type.statusBars());
            // 用户滑动边缘拉出状态栏后，还能隐藏
            controller.setSystemBarsBehavior(
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            //防止14版本不灵
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                // 设置窗口占用刘海区
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
                activity.getWindow().setAttributes(lp);
            }

            final View decorView = activity.getWindow().getDecorView();
            int ui = decorView.getSystemUiVisibility();
            ui |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(ui);
        }
    }

    /**
     * 内容是否顶入状态栏
     *
     * @param activity
     * @param fill
     */
    public static void fillStatusBar(Activity activity, boolean fill) {
        View view_statusbar = null;
        try {
            view_statusbar = activity.findViewById(ID_STATUSBAR);
        } catch (Exception e) {

        }
        if (fill) {
            if (view_statusbar != null) view_statusbar.setVisibility(View.GONE);
        } else {
            if (view_statusbar != null) view_statusbar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 内容是否顶入状态栏
     *
     * @param activity
     * @param fill
     */
    public static void fillNavigationBar(Activity activity, boolean fill) {
        View view_navigarion = null;
        try {
            view_navigarion = activity.findViewById(ID_NAVIGATIONBAR);
        } catch (Exception e) {

        }
        if (fill) {
            if (view_navigarion != null) view_navigarion.setVisibility(View.GONE);
        } else {
            if (view_navigarion != null) view_navigarion.setVisibility(View.VISIBLE);
        }
    }

    public static void showNavigationBar(Activity activity, boolean show) {
        Window window = activity.getWindow();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
        View view_navigationbar = null;
        try {
            view_navigationbar = activity.findViewById(ID_NAVIGATIONBAR);
        } catch (Exception e) {

        }
        if (show) {
            controller.show(WindowInsetsCompat.Type.navigationBars());
        } else {
            if (view_navigationbar != null) view_navigationbar.setVisibility(View.GONE);

            controller.hide(WindowInsetsCompat.Type.navigationBars());
            // 用户滑动边缘拉出导航栏后，还能隐藏
            controller.setSystemBarsBehavior(
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            );
        }
    }

    public static void fullScreen(Activity activity, boolean fullScreen) {
        showStatusBar(activity, !fullScreen);
        showNavigationBar(activity, !fullScreen);
        //防止10版本不灵
        if (fullScreen) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                // 设置窗口占用刘海区
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
                activity.getWindow().setAttributes(lp);
            }

            View decorView = activity.getWindow().getDecorView();
            int ui = decorView.getSystemUiVisibility();
            ui |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(ui);
        }
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
     * * 导航栏全透明，布局会填充到导航栏底部，有些手机是半透明
     *
     * @param activity
     * @param isLightColor 使得导航栏图标颜色根据背景色修改颜色为亮或者暗
     */
    public static void setNavigationBarTransparent(Activity activity, boolean isLightColor) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        fillNavigationBar(activity, true);
        setAppearanceLightNavigationBars(activity, isLightColor);
    }

    /**
     * 状态栏自定义背景颜色,6.0以上可修改状态栏字体颜色，icon颜色
     *
     * @param activity
     * @param color
     */
    public static void setStatusBarColor(Activity activity, int color) {
        try {
            /**
             *  Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void androidx.appcompat.widget.ContentFrameLayout.setDecorPadding(int, int, int, int)' on a null object reference
             *  at androidx.appcompat.app.AppCompatDelegateImpl.applyFixedSizeWindow(AppCompatDelegateImpl.java:1085)
             * at androidx.appcompat.app.AppCompatDelegateImpl.ensureSubDecor(AppCompatDelegateImpl.java:879)
             * at androidx.appcompat.app.AppCompatDelegateImpl.findViewById(AppCompatDelegateImpl.java:667)
             */
            View view_statusbar = activity.findViewById(ID_STATUSBAR);
            if (view_statusbar != null) view_statusbar.setBackgroundColor(color);
        } catch (Exception e) {

        }
        boolean isLightColor = isLightColor(color);
        setAppearanceLightStatusBars(activity, isLightColor);
    }

    public static void setStatusBarColorOld(Activity activity, int color) {
        Window window = activity.getWindow();
        //去除statusbar不填充的标志
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int ui = window.getDecorView().getSystemUiVisibility();
        boolean isLightColor = isLightColor(color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightColor) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体的颜色为黑色
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
            }
        }
        window.getDecorView().setSystemUiVisibility(ui);
        window.setStatusBarColor(color);
        setAppearanceLightStatusBars(activity, isLightColor);
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
        boolean isLightColor = isLightColor(color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightColor) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR; //设置导航栏中字体的颜色为黑色
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR; //设置导航栏中字体颜色为白色
            }
        }
        window.getDecorView().setSystemUiVisibility(ui);
        window.setNavigationBarColor(color);
        setAppearanceLightNavigationBars(activity, isLightColor);
    }

    /**
     * 当手动调用了隐藏statusbar的方法，会再次回调onApplyWindowInsets，这时候 高度就是0，
     * statusbarview和navigationbarview中会收到回调，故而切换statusbar和naviagtionbar的显示和隐藏，无需remove statusbarview和navigationbarview
     *
     * @param view
     * @param callbackStatusBar
     */
    public static void getStatusBarHeight(View view, CallbackStatusBar callbackStatusBar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
            callbackStatusBar.onStatusBarHeightGeted(insets.getInsets(WindowInsetsCompat.Type.statusBars()).top);
            return insets;
        });
    }

    public static void getNavigationBarHeight(View view, CallbackNavigationBar callbackNavigationBar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
            callbackNavigationBar.onNavigationBarHeightGeted(insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
            return insets;
        });
    }
//垃圾安卓，都他妈不灵了，damn
//    public static int getStatusBarHeight(Activity activity) {
//        WindowInsetsCompat insets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
//        if (insets == null) return 0;
//        return insets.getInsets(WindowInsetsCompat.Type.statusBars()).top;
//        return insets.getSystemWindowInsetTop();
//    }
//
//    public static int getNavigationBarHeight(Activity activity) {
//        WindowInsetsCompat insets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
//        if (insets == null) return 0;
//        return insets.getInsets(WindowInsetsCompat.Type.navigationBars()).top;
//    }

    //安卓14不灵了
//    public static int getStatusBarHeight(Context context) {
//        Resources resources = context.getResources();
//        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
//        return resources.getDimensionPixelSize(resourceId);
//    }
//
//    public static int getNavigationBarHeight(Context context) {
//        Resources resources = context.getResources();
//        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
//        return resources.getDimensionPixelSize(resourceId);
//    }
    public static interface CallbackStatusBar {
        public void onStatusBarHeightGeted(int height);
    }

    public static interface CallbackNavigationBar {
        public void onNavigationBarHeightGeted(int height);
    }
}
