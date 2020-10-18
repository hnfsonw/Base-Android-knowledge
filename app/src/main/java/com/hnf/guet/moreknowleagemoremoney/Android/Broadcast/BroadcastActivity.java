package com.hnf.guet.moreknowleagemoremoney.Android.Broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        /**
         * 动态注册无序广播
         * android 8.0之后已经禁用静态注册的方式了
         */

        //标准广播
//        IntentFilter filter  = new IntentFilter();
//        filter.addAction("com.hnf.orderBroadcast");
//        NormalReceiver receiver = new NormalReceiver();
//        registerReceiver(receiver,filter);

        //有序广播
//        IntentFilter filter  = new IntentFilter();
//        filter.addAction("com.hnf.orderBroadcast");
//        OrderReceiver1 orderReceiver1 = new OrderReceiver1();
//        OrderReceiver2 orderReceiver2 = new OrderReceiver2();
//        registerReceiver(orderReceiver1,filter);
//        registerReceiver(orderReceiver2,filter);

        //本地广播
//        IntentFilter filter  = new IntentFilter();
//        filter.addAction("com.hnf.orderBroadcast");
//        NormalReceiver receiver = new NormalReceiver();
//        final LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
//        manager.registerReceiver(receiver,filter);

        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderIntent = new Intent("com.hnf.orderBroadcast");
                orderIntent.putExtra("Msg","hi");

                /**
                 * 发送无序广播
                 */
//                sendBroadcast(orderIntent);

                /**
                 * 发送无序广播
                 */
//                sendOrderedBroadcast(orderIntent,null);

                /**
                 * 发送本地广播
                 * 本地广播不能静态注册
                 */
//                manager.sendBroadcast(orderIntent);

                //异步发送广播，本地有正在执行的广播的话，这个广播将会被阻塞，知道上一个广播执行完才发送
//                manager.sendBroadcastSync();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 注销标准广播
         */
//        unregisterReceiver(xxx);

        /**
         * 注销本地广播
         */
//        manager.unregisterReceiver(xxx);
    }
}
