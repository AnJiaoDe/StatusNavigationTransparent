package com.cy.statusnavigationtrans;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cy.translucentparent.StatusNavigationActivity;
import com.cy.translucentparent.StatusNavigationUtils;

public class Navigation2Activity extends StatusNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        setNavigationBarTransparent();
    }

}
