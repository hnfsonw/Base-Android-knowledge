package com.hnf.guet.moreknowleagemoremoney.Android.MutilProcess.MessagerUse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 *
 *4：客户端绑定该Service,通过IBinder对象实例化一个Messenger对象，通过该Messenger对象
 *就可以像Service中的handler发送Message消息
 * 5：Service中的handler收到消息后，在handleMessage中处理消息
 * 6：而Service要想向客户端回复消息，同样需要客户端的Messenger
 * 7：客户端创建handler，通过该handler创建一个客户端的Messenger，通过msg.replyTo将
 * 客户端的Messenger放进Message中，并发送给服务端
 *
 *
 */

public class MessagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messager);

        //绑定Service
        Intent intent = new Intent(this,MessagerService.class);
        bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }


    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            //第四步
            Messenger messager = new Messenger(service);
            Message msg = Message.obtain(null,0x11,0,0);


            //第七步
            msg.replyTo = clientMessager;
            try {
                messager.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private class ClientHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0x22:
                    Log.i("client","客户端收到服务端的消息啦");
                default:
                    break;
            }
        }
    }

    Messenger clientMessager = new Messenger(new ClientHandler());

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
