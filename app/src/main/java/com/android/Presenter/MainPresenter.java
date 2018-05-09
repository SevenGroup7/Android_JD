package com.android.Presenter;

import android.util.Log;

import com.android.Interfaces.IMainView;
import com.android.Moudel.callBack.OkHttpCallBack;
import com.android.Moudel.http.OkHttp;

import java.util.HashMap;

public class MainPresenter extends BasePresenter<IMainView> {

    private final OkHttp okHttp;
    public MainPresenter(){
        okHttp = OkHttp.getINSTANCE();
    }

    public void login(String path, HashMap<String,String> hashMap){

        okHttp.doPost(path, hashMap, new OkHttpCallBack() {
            @Override
            public void onSuccess(String str) {
                Log.e("TAG","======"+str);
                getView().onSuccess(str);
            }

            @Override
            public void onError() {

            }
        });

    }


    public void apply(String path, HashMap<String,String> hashMap){

        okHttp.doPost(path, hashMap, new OkHttpCallBack() {
            @Override
            public void onSuccess(String str) {
                Log.e("TAG","------"+str);
                getView().onSuccess(str);
            }

            @Override
            public void onError() {

            }
        });

    }

}
