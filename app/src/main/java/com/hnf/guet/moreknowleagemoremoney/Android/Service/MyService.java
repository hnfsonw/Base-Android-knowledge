package com.hnf.guet.moreknowleagemoremoney.Android.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private IBinder binder = new MyBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"绑定");
        return binder;
    }

    public class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
}
