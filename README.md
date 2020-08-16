

文章目录

GitHub：https://github.com/AnJiaoDe/StatusNavigationTransparent

使用方法

注意：如果轮子死活下载不下来，说明maven地址有毛病，你需要找到jitpack的官网首页，查看最新的官网地址

注意：记得去gayhub查看最新版本，最新版本最niubility

1. StatusBar半透明
2. StatusBar全透明
3. StatusBar透明于图片之上
3. NavigationBar透明

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
implementation 'com.github.AnJiaoDe:StatusNavigationTransparent:V1.1.7'
}
```


![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LTQ1NzUxNTIxMGEyZGEyZGI?x-oss-process=image/format,png)
 

 
**本文只描述在activity中如何使用，fragment中使用方法类似，可以实现**
 
 **首先创建全局theme**
 
```xml
<resources>

    <!--&lt;!&ndash; Base application theme. &ndash;&gt;-->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">

        <!--此处可自行根据项目需要设置,和状态栏导航栏透明无关-->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/theme</item>
        <item name="android:windowBackground">@color/white</item>
        <item name="android:windowSoftInputMode">stateAlwaysHidden</item>
        <item name="android:textColor">@color/text_deep</item>
        <item name="android:textSize">@dimen/size_3</item>
        <item name="android:scaleType">centerInside</item>
        <item name="android:launchMode">singleTop</item>
    </style>

</resources>

```

```xml
<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
```
 
 **然后创建BaseActivity实现StatusBar全透明**

```java
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusNavUtils.setStatusBarColor(this,0x00000000);
    }
    public void startAppcompatActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }


}

```

## 1. StatusBar半透明



**1.1 StatusBar半透明用StatusBarView实现(4.4以上有效)**


![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LTlhNjQ2N2Q4ZTNlZTNiMzI?x-oss-process=image/format,png)


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
        android:layout_height="wrap_content"
        android:background="#33000000" />

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar半透明(statusBarView)"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```


**1.2 StatusBar半透明用setStatusBarColor实现(5.0以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWU1MjQ2ZWQ2YjBiMmNkZjQ?x-oss-process=image/format,png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    style="@style/transparent_statusbar_fit"
    android:orientation="vertical">


    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar半透明(setStatusBarColor)"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```

```java
public class Status2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status2);
        StatusNavUtils.setStatusBarColor(this,0x33000000);
    }


    @Override
    public void onClick(View v) {

    }
}

```

## 2. StatusBar全透明


**2.1 StatusBar全透明用fitSystemWindows实现(4.4以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LTM3NWZlNGE1Y2QyNjNkZWI?x-oss-process=image/format,png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    style="@style/transparent_statusbar_fit"
    android:background="@color/colorPrimary"
    android:orientation="vertical">


    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar全透明(fitsystemwindows)"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```


**2.2 StatusBar全透明用StatusBarView实现(4.4以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LTVkZmUwMWY0OWQ1OTFiOTc?x-oss-process=image/format,png)

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
        android:layout_height="wrap_content"
        android:background="#00000000" />

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar全透明(StatusBarView)"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```


## 3. StatusBar透明于图片之上



**3.1 StatusBar半透明于图片之上用setStatusBarColor实现(5.0以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LTYwMDM3OWIyYTk2YTgwYTU?x-oss-process=image/format,png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@drawable/huge" />

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar半透明于图片之上(setStatusBarColor)"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```

```java
public class Status5Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status5);

        StatusNavUtils.setStatusBarColor(this,0x33000000);
    }

    @Override
    public void onClick(View v) {

    }
}

```

**3.2 StatusBar全透明于图片之上(4.4以上有效)**


![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWEzZjU0ZTM3NTYxYzU5YWI?x-oss-process=image/format,png)
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@drawable/huge" />

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorPrimary">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="StatusBar全透明于图片之上"
            android:textColor="#ffffff" />
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical"></LinearLayout>
</LinearLayout>

```


## 3. NavigationBar透明



**3.1 NavigationBar半透明用setNavigationBarColor实现(5.0以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWM1YWQ2MzdhYWYxNGI4NTk?x-oss-process=image/format,png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:id="@+id/activity_status7"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:background="@color/colorPrimary">

<TextView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:text="navigationBar半透明(setNavigationBarColor)"
    android:textColor="@color/white" />
</RelativeLayout>

```

```java
public class Navigation1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status7);

        StatusNavUtils.setNavigationBarColor(this,0x33000000);
    }

    @Override
    public void onClick(View v) {

    }
}

```

**3.2 NavigationBar全透明(4.4以上有效)**

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWFkNjNhNjYwNTM2MTM0NzM?x-oss-process=image/format,png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_status7"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:gravity="center"
        android:layout_alignParentBottom="true"
        android:text="navigationBar全透明"
        android:textColor="@color/white" />
</RelativeLayout>

```

```java
public class Navigation2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        StatusNavUtils.setNavigationBarColor(this,0x00000000);

    }

    @Override
    public void onClick(View v) {

    }
}

```
 
 


 **源码：**
**transparent_statusbar_fit**
```
    <style name="transparent_statusbar_fit">
        <item name="android:fitsSystemWindows">true</item>
        <item name="android:clipToPadding">false</item>
    </style>
```

**StatusNavUtils**
```java
public class StatusNavUtils {


    /**
     * 状态栏透明去阴影（5.0以上）
     *
     * @param activity
     * @param color
     */
    public static void setStatusBarColor(Activity activity, int color) {
        Window window = activity.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

    }

    /**
     * 导航栏全透明去阴影（5.0以上）
     *
     * @param activity
     * @param color
     */

    public static void setNavigationBarColor(Activity activity, int color) {
        Window window = activity.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setNavigationBarColor(color);
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }

    /**
     * 状态栏、导航栏全透明去阴影（5.0以上）
     *
     * @param activity
     * @param color_status
     * @param color_nav
     */
    public static void setStatusNavBarColor(Activity activity, int color_status, int color_nav) {
        Window window = activity.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(color_status);

            window.setNavigationBarColor(color_nav);
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }


}

```

**StatusBarView**

```java
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

**ScreenUtils**

```java
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

 微信公众号
 ![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWZjZmJiNDUxNzVmOTlkZTA)

QQ群

  ![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL3VwbG9hZC1pbWFnZXMuamlhbnNodS5pby91cGxvYWRfaW1hZ2VzLzExODY2MDc4LWEzMWZmNDBhYzY4NTBhNmQ)

