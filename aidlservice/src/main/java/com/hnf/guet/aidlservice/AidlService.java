package com.hnf.guet.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class AidlService extends Service {
    private RemoteCallbackList<IResultListener> callbackList;

    public AidlService() {
        callbackList = new RemoteCallbackList<>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return stub;
    }

    private IMyAidlInterfaceManager.Stub stub = new IMyAidlInterfaceManager.Stub() {
        @Override
        public void onCaculateResult(ParameterBean ags1, ParameterBean ags2) throws RemoteException {
            //
            int a = ags1.getParam();
            int b = ags2.getParam();
            ParameterBean result = new ParameterBean(a * b);

            remoteListenList(result);
        }

        private void remoteListenList(ParameterBean result) {
            int listenNum = callbackList.beginBroadcast();
            for (int i = 0;i < listenNum;i++){
                IResultListener listener = callbackList.getBroadcastItem(i);
                //把计算结果设置到回调函数中
                try {
                    listener.onCaculateCompleted(result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            callbackList.finishBroadcast();
        }

        @Override
        public void registerListener(IResultListener listener) throws RemoteException {
            callbackList.register(listener);
        }

        @Override
        public void unRegisterListener(IResultListener listener) throws RemoteException {
            callbackList.unregister(listener);
        }
    };
}
