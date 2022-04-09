package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Opening extends Activity {
    Timer timer;//宣告一個時間函示
    int tt=10;//設置初始秒數
    ImageView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        t1= findViewById(R.id.open_iv);
        timer = new Timer();//時間函示初始化
        //這邊開始跑時間執行緒
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    tt--;//時間倒數
                    t1.setImageResource(R.drawable.kisspng2);
                    //if判斷示裡面放置在時間結束後想要完成的事件
                    if(tt<7){
                        t1.setImageResource(R.drawable.kisspng3);
                        if(tt<4){
                            t1.setImageResource(R.drawable.kisspng4);
                               if (tt < 1) {
                               tt = 10; //讓時間執行緒保持輪迴
                    }
                }}});
            }
        };
        timer.schedule(task, 700, 100);//時間在幾毫秒過後開始以多少毫秒執行or時間在幾毫秒過後開始[timer.schedule(task, 1000)]

        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000); //2秒跳轉
    }
    private static final int GOTO_MAIN_ACTIVITY = 0;
    private final Handler mHandler = new Handler(Looper.myLooper()) {
        public void handleMessage(android.os.Message msg) {

            if (msg.what == GOTO_MAIN_ACTIVITY) {
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(Opening.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

    };
}

