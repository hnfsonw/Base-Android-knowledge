package com.hnf.guet.moreknowleagemoremoney.Android.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 绑定Service
 */
public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";

    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Intent intent = new Intent(this,MyService.class);
        bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }


    public ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG,"连接建立");
            //获取到Service的实例
            myService = ((MyService.MyBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG,"连接断开");
            myService = null;
        }
    };
}
