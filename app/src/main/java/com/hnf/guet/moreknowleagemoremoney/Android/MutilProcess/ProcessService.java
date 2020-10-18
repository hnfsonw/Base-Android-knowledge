package com.hnf.guet.moreknowleagemoremoney.Android.MutilProcess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ProcessService extends Service {
    public ProcessService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
