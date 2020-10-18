package com.hnf.guet.moreknowleagemoremoney.Android.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * 标准广播，无序，不能拦截
 */
public class NormalReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalReceiver";
    public NormalReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("Msg");
        Log.e(TAG, msg);
    }
}
