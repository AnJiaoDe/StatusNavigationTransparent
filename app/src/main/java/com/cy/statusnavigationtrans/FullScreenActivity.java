package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import com.cy.translucentparent.StaNavUtils;

public class FullScreenActivity extends BaseActivity {
    private boolean fullScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        StaNavUtils.setAppearanceLightStatusBars(this,false);
        StaNavUtils.setNavigationBarTransparent(this,false);
        StaNavUtils.fillStatusBar(this,true);
        findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreen = !fullScreen;
                StaNavUtils.fullScreen(FullScreenActivity.this,fullScreen);
            }
        });
    }
}
