package com.android.View.activitys;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.android.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        initZtl();

    }

    @Override
    void initView() {

    }

    @Override
    void initDate() {

    }

    @Override
    int setChildContentView() {
        return R.layout.activity_login;
    }

    private void initZtl() {
        /**
         * 沉浸式状态栏
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //半透明头部状态栏，底部导航栏   布局在状态栏，导航栏下方
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
