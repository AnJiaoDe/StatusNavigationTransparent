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
