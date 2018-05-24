package com.android.Module;

import com.android.Presenter.MyPresenterInterface;
import com.android.Utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyModule {
    public void getDate(String str, final MyPresenterInterface myPresenterInterface){
        OkHttpUtils.doGet(str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                myPresenterInterface.onSuccess(s);
            }
        });
    }
}
