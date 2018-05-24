package com.android.Utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils{
    //单例模式，把构造方法进行私有化
    //
    private OkHttpUtils(){};
    static  OkHttpClient client;


    public static OkHttpClient getInstance(){


        if (client==null) {
            //更加安全
            synchronized (OkHttpUtils.class) {
                //缓存的地方     mnt/sdcard
                File file = new File(Environment.getExternalStorageDirectory(), "cache11");
                client = new OkHttpClient().newBuilder()
                        .readTimeout(3000, TimeUnit.SECONDS)   //设置读取超时时间
                        .connectTimeout(3000, TimeUnit.SECONDS) //设置连接的超时时间

                        .cache(new Cache(file, 10 * 1024))
                        .build();
            }
        }
        return client;
    }


    /**
     * get请求
     * Callback  是一个接口
     */
    public static void doGet(String url, Callback callback){

        //1:拿到okhttpclient  对像

        OkHttpClient client = getInstance();
        //2:进行请求的操作

        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);


    }

    //post请求
    public static void doPost(String url, Map<String,String> parms, Callback callback){

        //得到客户端的对像
        OkHttpClient client = getInstance();

        //不是FormBody，而是一个Builder
        FormBody.Builder body = new FormBody.Builder();
        //key   value
        for (String key:parms.keySet()){
            //value的值
            body.add(key,parms.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(body.build())
                .build();

        client.newCall(request).enqueue(callback);

    }
}
