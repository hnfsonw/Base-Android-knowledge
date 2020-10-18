package com.hnf.guet.moreknowleagemoremoney.Android.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 一个looper是可以处理多个handler的
 */
public class HandlerActivity extends AppCompatActivity {
    private TextView textView;
    private MyHandler myHandler1;
    private Handler myHandler2;

    /**
     * 创建Handler方式一：
     * 创建自定义类继承Handler类
     */
    class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0x11:
                    textView.setText(msg.arg1+" "+msg.obj.toString());
                    break;
                case 0x12:
                    textView.setText(msg.arg1+" "+msg.obj.toString());
                    break;
            }
        }
    }

    /**
     * 创建Handler方式二
     * 匿名内部类
     */
    private void dealWithHandler() {
        myHandler2 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 0x11:
                        textView.setText(msg.arg1+" "+msg.obj.toString());
                        break;
                    case 0x12:
                        textView.setText(msg.arg1+" "+msg.obj.toString());
                        break;
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        textView = findViewById(R.id.handler_text);

        //handler创建方式一
        myHandler1 = new MyHandler();

        //handler创建方式二
        dealWithHandler();

//        myHandler2 = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //这种方式会重新创建一个Message对象
//                Message message = new Message();

                //这种方式会从消息池中取Message，如果有直接用，没有再重新创建
                Message message = myHandler1.obtainMessage();
                message.what = 0x11;
                message.arg1 = 11;
                message.obj = "11str";
                /**
                 * 同时，handler还有两种发送Message的方式
                 * 第一种：handler.sendMessage();
                 */
                myHandler1.sendMessage(message);

                /**
                 * 第二种：
                 * handler.post(new Runnable)
                 */
//                myHandler2.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("111");
//                    }
//                });
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
                //这种方式会从消息池中取Message，如果有直接用，没有再重新创建
                Message message = myHandler2.obtainMessage();
                message.what = 0x12;
                message.arg1 = 22;
                message.obj = "22str";
                myHandler2.sendMessage(message);


//                myHandler2.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("22222");
//                    }
//                });
            }
        }).start();
    }
}
