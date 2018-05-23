package com.android.View.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.Interfaces.IBaseView;
import com.android.Presenter.BasePresenter;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setChildContentView());
        initView();
        initBaseDate();
        initDate();
    }

    private void initBaseDate(){
        presenter = setPresenter();

        if(presenter != null){
            presenter.attachView(this);
        }else{
            try {
                throw new Exception("Error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    abstract void initView();
    abstract void initDate();
    abstract P setPresenter();
    abstract int setChildContentView();
}
