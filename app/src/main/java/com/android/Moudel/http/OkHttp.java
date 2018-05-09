package com.android.Moudel.http;

import com.android.Moudel.callBack.OkHttpCallBack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp implements Callback {

    private static OkHttp INSTANCE;
    private OkHttpClient mOkHttpClient;
    private OkHttpCallBack mOkHttpCallBack;

    private OkHttp(){
        mOkHttpClient = new OkHttpClient.Builder().build();
    }

    private OkHttp getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new OkHttp();

        }
        return INSTANCE;
    }


    public void doGet(String path,OkHttpCallBack okHttpCallBack){
        this.mOkHttpCallBack = okHttpCallBack;
        Request request = new Request.Builder()
                .url(path)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(this);
    }

    public void doPost(String path, HashMap<String,String> map,OkHttpCallBack okHttpCallBack){
        this.mOkHttpCallBack = okHttpCallBack;

        FormBody.Builder builder = new FormBody.Builder();
        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key);
            builder.add(key,value);
        }

        FormBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(path)
                .post(formBody)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(this);

    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String str = response.body().string();
        mOkHttpCallBack.onSuccess(str);
    }
}
