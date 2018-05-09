package com.android.View.activitys;

import android.graphics.Color;
import android.os.Bundle;

import com.android.Presenter.MainPresenter;
import com.android.R;
import com.android.View.fragments.ClassifyFragment;
import com.android.View.fragments.HomeFragment;
import com.android.View.fragments.MineFragment;
import com.android.View.fragments.ShoppingCarFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class FragAllActivity extends BaseActivity<MainPresenter> {

    private BottomTabBar tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_frag_all);
    }

    @Override
    void initView() {
        tabBar = findViewById(R.id.tabBar);

        tabBar.init(getSupportFragmentManager())
                .setImgSize(30,30)
                .setFontSize(13)
                .setChangeColor(Color.RED, Color.GRAY)
                .setTabBarBackgroundColor(Color.LTGRAY)
                .addTabItem("首页", R.drawable.home1, R.drawable.home0, HomeFragment.class)
        //前面第一个是点击后的图片，第二个是点击前的图片
                .addTabItem("分类", R.drawable.classify1, R.drawable.classify0, ClassifyFragment.class)
                .addTabItem("购物车", R.drawable.shoppingcar1, R.drawable.shoppingcar0, ShoppingCarFragment.class)
                .addTabItem("我的", R.drawable.mine1, R.drawable.mine0, MineFragment.class)
                .isShowDivider(false);

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
