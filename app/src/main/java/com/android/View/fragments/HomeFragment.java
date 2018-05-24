package com.android.View.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.Module.Beans.BeanAll;
import com.android.Presenter.MyPresenter;
import com.android.R;
import com.android.Utils.GlideImageLoader;
import com.android.View.MyViewInterface;
import com.android.View.activitys.FragAllActivity;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener,MyViewInterface{

    private View view;
    private Toolbar toolbar;
    private LinearLayout scan;
    private LinearLayout ssk;
    private TextView sskText;
    private ImageView sskHelp;
    private LinearLayout message;
    private Banner banner;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            List<String> imgs = (List<String>) msg.obj;
            banner.setImages(imgs).start();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initTitle();//标题
        initView();//Banner


        return view;
    }


    private void initView() {

        banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getDate("https://www.zhaoapi.cn/ad/getAd");

    }

    private void initTitle() {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        scan = (LinearLayout) view.findViewById(R.id.scan);
        ssk = (LinearLayout) view.findViewById(R.id.ssk);
        sskText = (TextView) view.findViewById(R.id.ssk_text);
        sskHelp = (ImageView) view.findViewById(R.id.ssk_help);
        message = (LinearLayout) view.findViewById(R.id.message);
//        CrashReport.testJavaCrash();//测试bugly
        scan.setOnClickListener(this);
        ssk.setOnClickListener(this);
        sskText.setOnClickListener(this);
        sskHelp.setOnClickListener(this);
        message.setOnClickListener(this);
    }

    @Override
    public void onSuccess(Object obj) {

        String str = (String) obj;
        Gson gson = new Gson();
        BeanAll beanAll = gson.fromJson(str, BeanAll.class);
        List<BeanAll.DataBean> list = beanAll.getData();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            images.add(list.get(i).getIcon());
        }
        Message msg = Message.obtain();
        msg.obj = images;
        handler.sendMessage(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scan:
                Toast.makeText(getActivity(), "扫啊扫", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk:
                Toast.makeText(getActivity(), "搜索框", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk_text:
                Toast.makeText(getActivity(), "搜索框文字", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk_help:
                Toast.makeText(getActivity(), "搜索框帮助", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(getActivity(), "消息", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
