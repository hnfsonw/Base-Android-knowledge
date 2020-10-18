package com.hnf.guet.moreknowleagemoremoney.Android.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * HandlerThread原理
 * 通过继承Thread类，快速创建一个带有Looper的线程对象
 * 通过封装Handler类，快速绑定Handler和Looper，实现线程进通信
 */
public class HandlerThreadActivity extends AppCompatActivity {
    private static final String TAG = "HandlerThreadActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        /**
         * 开启一个带有Looper的线程
         */
        final HandlerThread handlerThread = new HandlerThread("myHandlerThread");
        handlerThread.start();

        /**
         * 绑定handler和Looper
         */
        final Handler workerHandler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 0x11:
                        //当前线程为子线程，最好不要用来更新Ui,用来做线程间的通信就可以了
                        Log.e(TAG,"receive thread: "+msg.arg1+" "+Thread.currentThread().getName());
                        break;
                }

                //注销
                handlerThread.quit();
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"send thread:"+Thread.currentThread().getName());

                Message message = workerHandler.obtainMessage();
                message.what = 0x11;
                message.arg1 = 111;
                workerHandler.sendMessage(message);
            }
        }).start();
    }
}
