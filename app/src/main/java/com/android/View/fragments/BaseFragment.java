package com.android.View.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.Interfaces.IBaseView;
import com.android.Presenter.BasePresenter;

public abstract class BaseFragment<V,P extends BasePresenter<IBaseView>> extends Fragment{

    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initDateBase();
        initData();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setChildContentView(),container,false);
    }

    private void initDateBase(){
        presenter = setPresenter();
        if(presenter != null){
            presenter.attachView((IBaseView) this);
        }else{
            try {
                throw new Exception("Error+Fragment");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    abstract void initView();
    abstract void initData();
    abstract P setPresenter();
    abstract int setChildContentView();
}
