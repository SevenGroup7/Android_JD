package com.android.View.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.Module.Adapter.RecyclerAdapter;
import com.android.Module.Adapter.RecyclerMSAdapter;
import com.android.Module.Beans.BeanAll;
import com.android.Module.Beans.NineBean;
import com.android.Presenter.MyMSPresenter;
import com.android.Presenter.MyNinePresenter;
import com.android.Presenter.MyPresenter;
import com.android.R;
import com.android.Utils.GlideImageLoader;
import com.android.View.MyMSInterface;
import com.android.View.MyNineInterface;
import com.android.View.MyViewInterface;
import com.android.View.activitys.FragAllActivity;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener, MyViewInterface, MyNineInterface, MyMSInterface {

    private View view;
    private Toolbar toolbar;
    private LinearLayout scan;
    private LinearLayout ssk;
    private TextView sskText;
    private ImageView sskHelp;
    private LinearLayout message;
    private Banner banner;
    private RecyclerView rcv;
    private RecyclerView rcv2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    List<String> imgs = (List<String>) msg.obj;
                    banner.setImages(imgs).start();
                    break;
                case 1:
                    List<NineBean.DataBean> list = (List<NineBean.DataBean>) msg.obj;
                    adapter.setDate(list);
                    adapter.notifyDataSetChanged();
                    break;
                case 2:
                    List<BeanAll.MiaoshaBean.ListBeanX> listBeanXList = (List<BeanAll.MiaoshaBean.ListBeanX>) msg
                            .obj;
                    msAdapter.setDate(listBeanXList);
                    msAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private RecyclerAdapter adapter;
    private TextView tvMiaosha;
    private TextView mMiaoshaTimeTv;
    private TextView mMiaoshaShiTv;
    private TextView mMiaoshaMinterTv;
    private TextView mMiaoshaSecondTv;
    private RecyclerMSAdapter msAdapter;
    private Gson gson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initTitle();//标题
        initView();//Banner
        initNine();//分类入口
        initMSText();//倒计时(为实现)
        initMiaoSha();//秒杀

        return view;
    }

    private void initMiaoSha() {

        rcv2 = view.findViewById(R.id.rcv2);
        rcv2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        MyMSPresenter myMSPresenter = new MyMSPresenter(this);
        myMSPresenter.getDate("https://www.zhaoapi.cn/ad/getAd");
        msAdapter = new RecyclerMSAdapter(getActivity());
        rcv2.setAdapter(msAdapter);
    }

    private void initMSText() {

        mMiaoshaShiTv = view.findViewById(R.id.tv_miaosha_shi);
        mMiaoshaTimeTv = view.findViewById(R.id.tv_miaosha_time);
        mMiaoshaMinterTv = view.findViewById(R.id.tv_miaosha_minter);
        mMiaoshaSecondTv = view.findViewById(R.id.tv_miaosha_second);

    }

    private void initNine() {
        rcv = view.findViewById(R.id.rcv);
        rcv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
        MyNinePresenter myNinePresenter = new MyNinePresenter(this);
        myNinePresenter.getDate("https://www.zhaoapi.cn/product/getCatagory");
        adapter = new RecyclerAdapter(getActivity());
        rcv.setAdapter(adapter);
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
        gson = new Gson();
        BeanAll beanAll = gson.fromJson(str, BeanAll.class);
        List<BeanAll.DataBean> list = beanAll.getData();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            images.add(list.get(i).getIcon());
        }
        Message msg = Message.obtain();
        msg.what = 0;
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

    @Override
    public void nineSuccess(Object obj) {
        String str = (String) obj;
        gson = new Gson();
        NineBean nineBean = gson.fromJson(str, NineBean.class);
        List<NineBean.DataBean> list = nineBean.getData();
        Message msg = Message.obtain();
        msg.what = 1;
        msg.obj = list;
        handler.sendMessage(msg);

    }

    @Override
    public void onMiaoShu(Object obj) {
        String str = (String) obj;
        gson = new Gson();
        BeanAll beanAll = gson.fromJson(str, BeanAll.class);
        List<BeanAll.MiaoshaBean.ListBeanX> list = beanAll.getMiaosha().getList();
        Message msg = Message.obtain();
        msg.what = 2;
        msg.obj = list;
        handler.sendMessage(msg);
    }
}
