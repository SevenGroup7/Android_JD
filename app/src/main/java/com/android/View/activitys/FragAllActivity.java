package com.android.View.activitys;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.Presenter.MyPresenter;
import com.android.View.MyViewInterface;
import com.android.View.fragments.ClassifyFragment;
import com.android.View.fragments.HomeFragment;
import com.android.View.fragments.MineFragment;
import com.android.View.fragments.ShoppingCarFragment;
import com.roughike.bottombar.BottomBar;

import com.android.R;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class FragAllActivity extends BaseActivity{

    private BottomBar bottomBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_frag_all);

        /**
         * 沉浸式状态栏
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //半透明头部状态栏，底部导航栏   布局在状态栏，导航栏下方
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }


        /**
         * 标题栏
         */

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        create();
        initDate();
    }


    @Override
    void initView() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);

    }


    @Override
    void initDate() {

    }

    @Override
    int setChildContentView() {
        return R.layout.activity_frag_all;
    }

    private void create() {

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                Fragment fragment = null;
                switch (tabId) {
                    case R.id.tab_home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.tab_classify:
                        fragment = new ClassifyFragment();
                        break;

                    case R.id.tab_shoppingcar:
                        fragment = new ShoppingCarFragment();
                        break;

                    case R.id.tab_mine:
                        fragment = new MineFragment();
                        break;
                }
//                fragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, fragment)
                        .commit();
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, new HomeFragment())
                        .commit();
            }
        });
    }


}
