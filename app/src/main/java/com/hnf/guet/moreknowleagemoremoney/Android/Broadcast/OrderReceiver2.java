package com.hnf.guet.moreknowleagemoremoney.Android.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 有序广播，低优先级
 */
public class OrderReceiver2 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver2";

    @Override
    public void onReceive(Context context, Intent intent) {
        String nextMsg = getResultExtras(true).getString("next");
        Log.e(TAG,nextMsg);
    }
}
