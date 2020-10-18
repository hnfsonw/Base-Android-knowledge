package com.hnf.guet.moreknowleagemoremoney.Android.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 测试handler在主线程创建和子线程创建的区别
 *
 * 注意：new Handler()可以传入参数或者不传参数，如果传了Looper参数的时候，传入的是哪个
 * 线程的Looper，那么handler就运行在哪个线程下；
 * 如果没传入参数，那么在哪个线程下new handler（）,就运行在哪个线程下。
 *
 */
public class HandlerTest2Activity extends AppCompatActivity {
    private Handler handler;
    private Handler sonHandler;//在子线程创建Handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test2);
        handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("HNF","这是在--主线程--中创建Handler");
                    }
                });

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * 在子线程中创建handler，由于不会自动绑定Looper，所以是没办法处理消息的
                 * 这时就需要手动把handler和Looper绑定。每个线程只能有一个Looper，绑定Looper的时候
                 * 会自动绑定MessageQueue
                 */

                //绑定方式一
//                sonHandler = new Handler(Looper.getMainLooper());
//                sonHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("这是在--子线程--中创建handler");
//                    }
//                });

                //绑定方式二
                Looper.prepare();
                sonHandler = new Handler();
                sonHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("HNF","这是在--子线程--中创建Handler");
                    }
                });
                Looper.loop();
            }
        }).start();
    }
}
