package com.android.View.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.R;
import com.tencent.bugly.crashreport.CrashReport;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Toolbar toolbar;
    private LinearLayout scan;
    private LinearLayout ssk;
    private TextView sskText;
    private ImageView sskHelp;
    private LinearLayout message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        scan = (LinearLayout) view.findViewById(R.id.scan);
        ssk = (LinearLayout) view.findViewById(R.id.ssk);
        sskText = (TextView) view.findViewById(R.id.ssk_text);
        sskHelp = (ImageView) view.findViewById(R.id.ssk_help);
        message = (LinearLayout) view.findViewById(R.id.message);

        initView();


        return view;
    }

    private void initView() {
//        CrashReport.testJavaCrash();//测试bugly
        scan.setOnClickListener(this);
        ssk.setOnClickListener(this);
        sskText.setOnClickListener(this);
        sskHelp.setOnClickListener(this);
        message.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scan:
                Toast.makeText(getActivity(),"扫啊扫",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk:
                Toast.makeText(getActivity(),"搜索框",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk_text:
                Toast.makeText(getActivity(),"搜索框文字",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ssk_help:
                Toast.makeText(getActivity(),"搜索框帮助",Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(getActivity(),"消息",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
