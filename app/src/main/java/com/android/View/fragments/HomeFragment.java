package com.android.View.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.Adapter.RecyclerViewAdapter;
import com.android.Interfaces.IBaseView;
import com.android.R;
import com.android.Utils.GlideImageLoader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener, IBaseView {

    private View view;
    private Toolbar toolbar;
    private LinearLayout scan;
    private LinearLayout ssk;
    private TextView sskText;
    private ImageView sskHelp;
    private LinearLayout message;
    private Banner banner;
    private List<String> list = new ArrayList<>();
    private List<String> images = new ArrayList<>();
    private ListView listView;
    private XRecyclerView xrlv;
    private int curr;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initImages();
        initRecyclerView();
        initTitle();//标题
        initBanner();//Banner


        return view;
    }

    private void initRecyclerView() {
        xrlv = view.findViewById(R.id.xr);

        //LinearLayoutManager是线性布局，setOrientation可以设置他的方向是横向还是纵向。
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrlv.setLayoutManager(layoutManager);


        xrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr = 0;
                list.clear();
                initList(curr);
                xrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                SystemClock.sleep(2000);
                curr =curr+10;
                initList(curr);
                xrlv.refreshComplete();
            }
        });

        curr = 0;
        initList(curr);
    }

    private void initList(int itemSize) {
        for (int i = itemSize; i < itemSize+50; i++) {
            list.add("item" + i);
        }

        /**
         * 为了不重复创建adapter
         */
        if(adapter == null){
            adapter = new RecyclerViewAdapter(getActivity(),list);
            xrlv.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }

    }

    private void initImages() {

        images = new ArrayList<>();
        images.add("https://www.zhaoapi.cn/images/quarter/ad1.png");
        images.add("https://www.zhaoapi.cn/images/quarter/ad2.png");
        images.add("https://www.zhaoapi.cn/images/quarter/ad3.png");
        images.add("https://www.zhaoapi.cn/images/quarter/ad4.png");

    }

    private void initBanner() {

        banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader()).setImages(images).start();

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
