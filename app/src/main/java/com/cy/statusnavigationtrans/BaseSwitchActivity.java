package com.cy.statusnavigationtrans;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.cy.translucentparent.StaNavUtils;


public class BaseSwitchActivity extends BaseActivity {
    private boolean fullScreen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_navigation_switch);
        final ViewGroup rl1=findViewById(R.id.rl1);
        final ViewGroup rl2=findViewById(R.id.rl2);

        StaNavUtils.setNavigationBarTransparent(BaseSwitchActivity.this, false);
        findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreen=!fullScreen;
                if(fullScreen){
                    rl1.setVisibility(View.GONE);
                    rl2.setVisibility(View.GONE);
                }else {
                    rl1.setVisibility(View.VISIBLE);
                    rl2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
