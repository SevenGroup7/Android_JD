package com.android.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

public class NetUtils {

    //判断有无网络的方法
    public static boolean isConn(Context context){
        //1.得到系统服务
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //2.得到网络信息类对象-需要添加权限
        NetworkInfo info = manager.getActiveNetworkInfo();
        //3.进行判断
        if(info!=null && info.isAvailable()){//已经连接网络
            return true;
        }else{
            return false;
        }
    }

    //如果没有网络的情况下，弹出一个对话框，打开设置页面
    public static void openNetDialog(final Context context){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage("没有网络，是否进行设置？");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //跳转到系统设置页面-隐士跳转
                Intent intent = null;
                // 先判断当前系统版本
                if(android.os.Build.VERSION.SDK_INT > 10){  // 3.0以上
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                }else{
                    intent = new Intent();
                    intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                }
                context.startActivity(intent);
            }
        });
        builder.setNegativeButton("取消",null);
        AlertDialog dialog = builder.create();
        dialog.show();


    }

}
