package com.hnf.guet.moreknowleagemoremoney.Android.MutilProcess.MessagerUse;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;


/**
 * Messenger其实是封装的AIDL,可以实现线程以及进程间的通信
 * 注意：Messenger和Message的区别
 * 使用步骤：
 * 1：Service创建一个handler，用于处理从客户端收到的消息
 * 2：用该handler创建一个Messenger对象，Messenger的内部会引用该handler对象
 * 3：用创建好的Messenger对象获得一个IBinder实例，并且将该实例通过Service的onBind方法
 * 返回给客户端
 *
 */
public class MessagerService extends Service {
    public MessagerService() {

    }

    //第一步
    class ServerHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0x11:
                    Log.i("Service","服务端收到客户端的消息了");


                    //第8步，服务端通过传过来的msg获取到客户端的Messenger,并通过该Messenger发送消息给客户端的handler
                    Messenger clientMessenger = msg.replyTo;
                    Message msgToClient = Message.obtain();
                    msgToClient.what = 0x22;
                    try {
                        clientMessenger.send(msgToClient);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    super.handleMessage(msg);
                    break;

            }
        }
    }


    //第二步
    final Messenger mMessenger = new Messenger(new ServerHandler());


    //第三步
    @Override
    public IBinder onBind(Intent intent) {

        return mMessenger.getBinder();
    }
}
