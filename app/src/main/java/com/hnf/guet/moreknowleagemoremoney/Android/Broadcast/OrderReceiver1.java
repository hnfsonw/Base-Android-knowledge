package com.hnf.guet.moreknowleagemoremoney.Android.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


/**
 * 有序广播，高优先级
 */
public class OrderReceiver1 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver1";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("Msg");
        Log.e(TAG, msg);

        //使用这个方法拦截广播并丢弃
        abortBroadcast();

        Bundle bundle  = new Bundle();
        bundle.putString("next","next hi");
        setResultExtras(bundle);

    }
}
