package com.android.View.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.Presenter.MainPresenter;
import com.android.View.fragments.ClassifyFragment;
import com.android.View.fragments.HomeFragment;
import com.android.View.fragments.MineFragment;
import com.android.View.fragments.ShoppingCarFragment;
import com.roughike.bottombar.BottomBar;

import com.android.R;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.TabSelectionInterceptor;

import java.util.ArrayList;
import java.util.List;

public class FragAllActivity extends BaseActivity<MainPresenter> {

    private BottomBar bottomBar;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_frag_all);


        initView();
        create();
    }

    @Override
    void initView() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        View layout = findViewById(R.id.contentContainer);
    }

    private void create() {
        /**
         * fragmentList = new ArrayList<>();
         fragmentList.add(new HomeFragment());
         fragmentList.add(new ClassifyFragment());
         fragmentList.add(new ShoppingCarFragment());
         fragmentList.add(new MineFragment());
         viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override public Fragment getItem(int position) {
        return fragmentList.get(position);
        }

        @Override public int getCount() {
        return fragmentList.size();
        }
        });
         */

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                Object ob = null;
                switch (tabId) {
                    case R.id.tab_home:
                        ob = new HomeFragment();
                        break;

                    case R.id.tab_classify:
                        ob = new ClassifyFragment();
                        break;

                    case R.id.tab_shoppingcar:
                        ob = new ShoppingCarFragment();
                        break;

                    case R.id.tab_mine:
                        ob = new MineFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, (Fragment) ob).commit();
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new HomeFragment()).commit();
            }
        });
    }


    @Override
    void initDate() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
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
