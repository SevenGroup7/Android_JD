package com.android.Module;

import com.android.Utils.OkHttpUtils;
import com.android.View.MyMSInterface;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyMSModule {

    public void getDate(String str, final MyMSInterface myMSInterface) {
        OkHttpUtils.doGet(str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                myMSInterface.onMiaoShu(s);
            }
        });
    }

}
