package com.android.View.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.Presenter.MainPresenter;
import com.android.R;

public class FragAllActivity extends BaseActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_frag_all);
    }

    @Override
    void initView() {

    }

    @Override
    void initDate() {

    }

    @Override
    MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    int setChildContentView() {
        return R.layout.activity_frag_all;
    }
}
