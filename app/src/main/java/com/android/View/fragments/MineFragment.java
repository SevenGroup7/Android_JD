package com.android.View.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.R;
import com.android.View.activitys.LoginActivity;

public class MineFragment extends Fragment implements View.OnClickListener {
    private RelativeLayout linear;
    private ImageView mineToux;
    private TextView mineText;
    private ImageView mineSettings;
    private ImageView mineComment;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mine, container, false);

        initZtl();
        initView();


        return view;
    }

    private void initView() {

        linear = (RelativeLayout) view.findViewById(R.id.linear);
        mineToux = (ImageView) view.findViewById(R.id.mine_toux);
        mineText = (TextView) view.findViewById(R.id.mine_text);
        mineSettings = (ImageView) view.findViewById(R.id.mine_settings);
        mineComment = (ImageView) view.findViewById(R.id.mine_comment);


        linear.setOnClickListener(this);
        mineToux.setOnClickListener(this);
        mineText.setOnClickListener(this);
        mineSettings.setOnClickListener(this);
        mineComment.setOnClickListener(this);

    }

    private void initZtl() {
        /**
         * 沉浸式状态栏
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //半透明头部状态栏，底部导航栏   布局在状态栏，导航栏下方
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.mine_toux:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.mine_text:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.mine_settings:
                Toast.makeText(getActivity(), "我是设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_comment:
                Toast.makeText(getActivity(), "我是消息", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
