package com.android.View.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.R;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        start();

    }

    private void start() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, FragAllActivity.class));
                finish();
            }
        }, 3000);


//        Timer timer = new Timer();
//
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(new Intent(StartActivity.this, FragAllActivity.class));
//                finish();
//            }
//        };
//        timer.schedule(task, 3000);

    }
}
