package com.android.View.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setChildContentView());
        initView();
        initDate();
    }



    abstract void initView();
    abstract void initDate();
    abstract int setChildContentView();
}
