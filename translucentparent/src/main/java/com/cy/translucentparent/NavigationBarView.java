package com.cy.translucentparent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


/**
 * Created by lenovo on 2017/7/4.
 */

public class NavigationBarView extends View {
    public NavigationBarView(Context context) {
        this(context,null);
    }

    public NavigationBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(StaNavUtils.getNavigationBarHeight(this), MeasureSpec.EXACTLY));
    }
}
