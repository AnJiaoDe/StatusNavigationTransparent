package com.cy.translucentparent;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/11/20 0020.
 */

public class ScreenUtils {

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT <= 17) {
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static int setYStart(Context context, float y) {

//        if (isGroove(context)) {

        return (int) (y * getScreenHeight(context)) + getStatusBarHeight(context);
//        } else {
//            return (int) (y * getScreenHeight(context));
//
//
//        }
    }

    /**
     * 获取当前界面可视区域的高度
     *
     * @param activity
     * @return
     */
    public static int getVisibleFrameHeight(Activity activity) {
        Rect r = new Rect();
        //获取当前界面可视部分
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);

//        if (isGroove(activity)) {

//            return r.bottom - r.top - getStatusBarHeight(activity);
//        } else {
        return r.bottom - r.top;
//
//        }
    }

    /**
     * 获取当前界面可视区域的宽度
     *
     * @param activity
     * @return
     */
    public static int getVisibleFrameWidth(Activity activity) {
        Rect r = new Rect();
        //获取当前界面可视部分
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
        return r.right - r.left;
    }


    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static float getWidthDp(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.widthPixels / displayMetrics.density;
    }

    public static float getHeightDp(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.heightPixels / displayMetrics.density;
    }

    /**
     * @param context
     * @param dp
     * @return
     */
    public static float dpTrans(Context context, float dp, float widthDpBase) {
        return getWidthDp(context) / widthDpBase * dp;
    }

    /**
     * @param context
     * @param dp
     * @return
     */
    public static float dpTrans(Context context, float dp) {
        return getWidthDp(context) / 360 * dp;
    }

    /**
     * 将dp值转换为px值，保证尺寸大小不变
     *
     * @return
     */
    public static int dpAdapt(Context context, float dp) {
        return dpAdapt(context, dp, 360);
    }

    public static int dpAdapt(Context context, float dp, float widthDpBase) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;//高的像素
        int widthPixels = dm.widthPixels;//宽的像素
//        int densityDpi = dm.densityDpi;//dpi
//        float xdpi = dm.xdpi;//xdpi
//        float ydpi = dm.ydpi;//ydpi
        float density = dm.density;//density=dpi/160,密度比
//        float scaledDensity = dm.scaledDensity;//scaledDensity=dpi/160 字体缩放密度比
        float heightDP = heightPixels / density;//高度的dp
        float widthDP = widthPixels / density;//宽度的dp
        float w = Math.min(widthDP, heightDP);
//        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (dp * w / widthDpBase * density + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证尺寸大小不变
     *
     * @return
     */
    public static int spAdapt(Context context, float sp) {
        return spAdapt(context, sp, 360);
    }

    public static int spAdapt(Context context, float sp, float widthDpBase) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;//高的像素
        int widthPixels = dm.widthPixels;//宽的像素
//        int densityDpi = dm.densityDpi;//dpi
//        float xdpi = dm.xdpi;//xdpi
//        float ydpi = dm.ydpi;//ydpi
        float density = dm.density;//density=dpi/160,密度比
//        float scaledDensity = dm.scaledDensity;//scaledDensity=dpi/160 字体缩放密度比
        float heightDP = heightPixels / density;//高度的dp
        float widthDP = widthPixels / density;//宽度的dp
        float w = Math.min(widthDP, heightDP);
//        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (sp * w / widthDpBase * dm.scaledDensity + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float sp) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scaledDensity + 0.5f);
    }

    /**
     * px转sp
     */
    public static int px2sp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / scaledDensity + 0.5f);
    }

    /**
     * 计算指定的 View 在屏幕中的坐标。
     */
    public static int[] getViewScreenLocation(View view) {
        int[] location = new int[2];
        // 获取控件在屏幕中的位置，返回的数组分别为控件左顶点的 x、y 的值
        view.getLocationOnScreen(location);
        return location;
    }

    /**
     * 计算指定的 View 在屏幕中的范围。
     */
    public static RectF getViewScreenRectF(View view) {
        int[] location = new int[2];
        // 获取控件在屏幕中的位置，返回的数组分别为控件左顶点的 x、y 的值
        view.getLocationOnScreen(location);
        return new RectF(location[0], location[1], location[0] + view.getWidth(),
                location[1] + view.getHeight());
    }

    /**
     * 判断触摸点是否在控件内
     */
    public static boolean isInViewRange(View view, float rawX, float rawY) {
        // View view;
        RectF rect = getViewScreenRectF(view);
        return rect.contains(rawX, rawY);
    }

    /**
     * 判断触摸点是否在控件内
     */
    public static boolean isInViewRange(View view, MotionEvent event) {

        // MotionEvent event;
        // event.getX(); 获取相对于控件自身左上角的 x 坐标值
        // event.getY(); 获取相对于控件自身左上角的 y 坐标值
        float x = event.getRawX(); // 获取相对于屏幕左上角的 x 坐标值
        float y = event.getRawY(); // 获取相对于屏幕左上角的 y 坐标值

        // View view;
        RectF rect = getViewScreenRectF(view);
        return rect.contains(x, y);
    }

    /**
     * * 判断是否有长按动作发生 * @param lastX 按下时X坐标 * @param lastY 按下时Y坐标 *
     *
     * @param thisX         移动时X坐标 *
     * @param thisY         移动时Y坐标 *
     * @param lastDownTime  按下时间 *
     * @param thisEventTime 移动时间 *
     * @param longPressTime 判断长按时间的阀值
     */
    public static boolean isLongPressed(float lastX, float lastY, float thisX,
                                        float thisY, long lastDownTime, long thisEventTime,
                                        long longPressTime) {
        float offsetX = Math.abs(thisX - lastX);
        float offsetY = Math.abs(thisY - lastY);
        long intervalTime = thisEventTime - lastDownTime;
        if (offsetX <= 10 && offsetY <= 10 && intervalTime >= longPressTime) {
            return true;
        }
        return false;
    }


    public static float getDPWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT <= 17) {
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        int widthPixels = displayMetrics.widthPixels;//宽的像素
        float density = displayMetrics.density;//density=dpi/160,密度比
        float widthDP = widthPixels / density;//宽度的dp

        return widthDP;
    }

    public static float getDPHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT <= 17) {
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        int heightPixels = displayMetrics.heightPixels;//高的像素
        float density = displayMetrics.density;//density=dpi/160,密度比
        float heightDP = heightPixels / density;//高度的dp
        return heightDP;
    }


    //判断是否是华为刘海屏
    public static boolean isHuaweiScreenHasGroove(Context context) {
        boolean ret = false;
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");
            ret = (boolean) get.invoke(HwNotchSizeUtil);
        } catch (Exception e) {

        } finally {
            return ret;
        }
    }

    //获取华为刘海的高宽
    public static int[] getHuaweiNotchSize(Context context) {
        int[] ret = new int[]{0, 0};
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("getNotchSize");
            ret = (int[]) get.invoke(HwNotchSizeUtil);
        } catch (Exception e) {

        } finally {
            return ret;
        }
    }

    //判断手机是否是oppo有刘海
    public static boolean isOppoScreenHasGroove(Context context) {
        boolean isHasGroove = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        return isHasGroove;
    }

    //判断是否是voio刘海屏
    public static final int NOTCH_IN_SCREEN_VOIO = 0x00000020;//是否有凹槽
    public static final int ROUNDED_IN_SCREEN_VOIO = 0x00000008;//是否有圆角

    public static boolean isVoioScreenHasGroove(Context context) {
        boolean ret = false;
        try {
            ClassLoader cl = context.getClassLoader();
            Class FtFeature = cl.loadClass("com.util.FtFeature");
            Method get = FtFeature.getMethod("isFeatureSupport", int.class);
            ret = (boolean) get.invoke(FtFeature, NOTCH_IN_SCREEN_VOIO);
        } catch (Exception e) {

        } finally {
            return ret;
        }
    }

    public static boolean isGroove(Context context) {
        if (ScreenUtils.isOppoScreenHasGroove(context) ||
                ScreenUtils.isVoioScreenHasGroove(context)) {
            return true;
        }

        return false;

    }

}

