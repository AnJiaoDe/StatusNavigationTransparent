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
