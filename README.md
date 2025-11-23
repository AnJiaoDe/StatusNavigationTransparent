
文章目录

GitHub：https://github.com/AnJiaoDe/StatusNavigationTransparent

使用方法

注意：如果轮子死活下载不下来，说明maven地址有毛病，你需要找到jitpack的官网首页，查看最新的官网地址

注意：记得去gayhub查看最新版本，最新版本最niubility

首先创建全局theme继承Theme.AppCompat.Light.NoActionBar

然后继承StatusNavigationActivity

1. 系统StatusBar填充界面,自定义背景颜色(文字、icon颜色根据StatusBar颜色亮度设置为黑色)

2.系统StatusBar填充界面,自定义背景颜色(文字、icon颜色根据StatusBar颜色亮度设置为白色)

3.系统StatusBar不填充界面,布局添加StatusBarView实现半透明

4.系统StatusBar不填充界面,且半透明于图片之上

5.系统StatusBar不填充界面,且全透明于图片之上

6.系统navigationbar填充界面,自定义颜色

7.系统navigationbar不填充界面,且全透明

8.隐藏statusbar

9.隐藏navigationbar

10.隐藏statusbar、navigationbar，全屏

11.图片预览，切换statusbar、navigationbar的显示

StatusNavigationUtils工具类

StatusNavigationActivity

StatusBarView和系统StatusBar高度一致

NavigationBarView系统NavigationBarView高度一致

ScreenUtils

欢迎联系、指正、批评

## [GitHub：https://github.com/AnJiaoDe/StatusNavigationTransparent](https://github.com/AnJiaoDe/StatusNavigationTransparent)

## 使用方法
1.工程目录下的`build.gradle`中添加代码：
## 注意：如果轮子死活下载不下来，说明maven地址有毛病，你需要找到jitpack的官网首页，查看最新的官网地址

```java
allprojects {
		repositories {
			        maven { url 'https://www.jitpack.io' }
		}
	}
```
2.直接在需要使用的模块的build.gradle中添加代码：

## 注意：记得去gayhub查看最新版本，最新版本最niubility

```java
dependencies {
implementation 'com.github.AnJiaoDe:StatusNavigationTransparent:V1.2.4'
}
```


![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006004830409.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NvbmZ1c2luZ19hd2FrZW5pbmc=,size_16,color_FFFFFF,t_70)


## 首先创建全局theme继承Theme.AppCompat.Light.NoActionBar

 
```xml
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    </style>
```

```xml
<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
```
 

## 然后继承StatusNavigationActivity
 注意：不一定非要继承StatusNavActivity ,可以使用StatusNavigationUtils工具类、StatusBarView和NavigationBarView


总之，方法多样灵活
## 1. 系统StatusBar填充界面,自定义背景颜色(文字、icon颜色根据StatusBar颜色亮度设置为黑色)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020100600534638.png)


```java
public class Status00Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status00);
        //此行可不写，默认就是0xfff2f2f2
        setStatusBarColor(getStatusBarColorDefault());
    }

    @Override
    public void onClick(View v) {

    }
}
```
       

## 2.系统StatusBar填充界面,自定义背景颜色(文字、icon颜色根据StatusBar颜色亮度设置为白色)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006005516961.png)

```java
public class Status0Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status0);
        setStatusBarColor(getResources().getColor(R.color.theme));
    }


    @Override
    public void onClick(View v) {

    }
}
```

## 3.系统StatusBar不填充界面,布局添加StatusBarView实现半透明
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006005718949.png)

```java
public class Status2Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status2);
        setStatusBarNoFillAndTransParentHalf();
    }


    @Override
    public void onClick(View v) {

    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">
    <com.cy.translucentparent.StatusBarView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar半透明"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```

## 4.系统StatusBar不填充界面,且半透明于图片之上
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006005825571.png)

```java
public class Status5Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status5);
        setStatusBarNoFillAndTransParentHalf();
        //或者写2行
//        setStatusBarNoFill();
//        setStatusBarColor(0x33000000);
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 5.系统StatusBar不填充界面,且全透明于图片之上
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006005912922.png)

```java
public class Status6Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status6);
        setStatusBarNoFillAndTransParent();
    }


    @Override
    public void onClick(View v) {

    }
}
```

## 6.系统navigationbar填充界面,自定义颜色
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006010032268.png)

```java
public class Navigation0Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation0);
        setNavigationBarColor(0xffff0000);
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 7.系统navigationbar不填充界面,且全透明
模拟器上看起来是半透明，有些手机会有阴影，不必强求，随缘即可
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006010143951.png)

```java
public class Navigation2Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        setNavigationBarTransparent();
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 8.隐藏statusbar
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006010602644.gif)

```java
public class HideStatusBarActivity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_status_bar);
        setHideStatusBar();
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 9.隐藏navigationbar
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006010812251.gif)

```java
public class HideNavigationBarActivity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_navigation_bar);
        setHideNavigationBar();
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 10.隐藏statusbar、navigationbar，全屏
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006010930427.gif)

```java
public class FullScreenActivity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        setFullScreen();
    }

    @Override
    public void onClick(View v) {

    }
}
```

## 11.图片预览，切换statusbar、navigationbar的显示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201006011103788.gif)

```java
public class StatusNavigationSwitchActivity extends StatusNavigationActivity {
    private boolean fullScreen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_navigation_switch);
        final ViewGroup rl1=findViewById(R.id.rl1);
        final ViewGroup rl2=findViewById(R.id.rl2);
        findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreen=!fullScreen;
                if(fullScreen){
                    rl1.setVisibility(View.GONE);
                    rl2.setVisibility(View.GONE);
                    setHideStatusBar();
                    setNavigationBarTransparent();
                }else {
                    rl1.setVisibility(View.VISIBLE);
                    rl2.setVisibility(View.VISIBLE);
                    setClearHideStatusBar();
                    setStatusBarColor(getStatusBarColorDefault());
                    setNavigationBarColor(getNavigationBarColorDefault());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

```
小编提供了贼多工具方便你的使用

## StatusNavigationUtils工具类

```java
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

    /**设置导航栏颜色，和setNavigationBarTransparent互斥，要么选择自定义导航栏颜色，要么选择导航栏全透明
     * @param activity
     * @param color
     */

    public static void setNavigationBarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        int ui = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(ui);
        window.setNavigationBarColor(color);
    }

    /**
     * 隐藏状态栏、导航栏，全屏
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |=  View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
    /**
     * 去除隐藏状态栏、导航栏，全屏的标志
     * @param activity
     */
    public static void setClearFullScreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &=  View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                & View.SYSTEM_UI_FLAG_FULLSCREEN
                & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }

    /**
     * 隐藏状态栏
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
     * @param activity
     */
    public static void setHideNavigationBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui |=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
    /**
     * 去除隐藏导航栏的标志
     * @param activity
     */
    public static void setClearHideNavigationBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int ui = decorView.getSystemUiVisibility();
        ui &=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION & View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(ui);
    }
}

```

## StatusNavigationActivity

```java
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
        return 0xff000000;
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

```

## StatusBarView和系统StatusBar高度一致

```java
package com.cy.translucentparent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by lenovo on 2017/7/4.
 */

public class StatusBarView extends View {
    private Context context;
    public StatusBarView(Context context) {
        this(context,null);
    }

    public StatusBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(ScreenUtils.getStatusBarHeight(context), MeasureSpec.EXACTLY));
    }
}

```

## NavigationBarView系统NavigationBarView高度一致

```java
package com.cy.translucentparent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by lenovo on 2017/7/4.
 */

public class NavigationBarView extends View {
    private Context context;
    public NavigationBarView(Context context) {
        this(context,null);
    }

    public NavigationBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(ScreenUtils.getNavigationBarHeight(context), MeasureSpec.EXACTLY));
    }
}

```

## ScreenUtils

```java
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

    public static int getScreenWidth(Context context) {

        DisplayMetrics displayMetrics = new DisplayMetrics();

        WindowManager wm = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT <= 17) {
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        WindowManager wm = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT <= 17) {
            wm.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
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
}


```

## 欢迎联系、指正、批评



Github:[https://github.com/AnJiaoDe](https://github.com/AnJiaoDe)

简书：[https://www.jianshu.com/u/b8159d455c69](https://www.jianshu.com/u/b8159d455c69)

CSDN：[https://blog.csdn.net/confusing_awakening](https://blog.csdn.net/confusing_awakening)

ffmpeg入门教程:[https://www.jianshu.com/p/042c7847bd8a](https://www.jianshu.com/p/042c7847bd8a)


