package com.hnf.guet.moreknowleagemoremoney.Android.UDP;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyUdpService extends IntentService {
    private static final String TAG = "MyUdpService";
    String dataStr = "this is server msg";
    byte[] dataBuffer = new byte[1024];
    DatagramSocket datagramSocket= null;

    public MyUdpService() {
        super("MyUdpService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            //把服务端绑定到3000端口上
            datagramSocket = new DatagramSocket(3000);

            DatagramPacket receivePacket = new DatagramPacket(dataBuffer,1024);

            while (true){
                //接收从客户端发送过来的消息
                datagramSocket.receive(receivePacket);
                String clientHost = receivePacket.getAddress().getHostAddress();
                int clientPort = receivePacket.getPort();
                Log.e(TAG,clientHost+":"+clientPort);

                //getData获取到的是缓冲区的大小，实际的数据大小必须是getLength
                String msgFromClient = new String(receivePacket.getData(),0,receivePacket.getLength());
                Log.e(TAG,msgFromClient);


                //接收完毕，发送数据到客户端
                DatagramPacket sendPacket = new DatagramPacket(dataStr.getBytes(),dataStr.length(),receivePacket.getAddress(),clientPort);
                datagramSocket.send(sendPacket);

                //由于每reciver一次数据，receivePacket的就会变成实际的数据长度，为了防止数据丢失，需要每次将receivePacket重新设置
                receivePacket.setLength(1024);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }
}
