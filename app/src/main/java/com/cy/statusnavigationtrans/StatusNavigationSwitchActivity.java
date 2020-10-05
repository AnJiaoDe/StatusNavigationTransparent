package com.cy.statusnavigationtrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.cy.translucentparent.StatusNavigationActivity;

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
                    setStatusBarColor(0xfff2f2f2);
                    setNavigationBarColor(0xff000000);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
