package com.hnf.guet.moreknowleagemoremoney.Android.UDP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.hnf.guet.moreknowleagemoremoney.R;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClientActivity extends AppCompatActivity {
    private static final String TAG = "UdpClientActivity";
    String dataStr = "this is cleint msg!";
    byte[] buf = new byte[1024];
    int tryTimes = 0;
    DatagramPacket receivePacket = null;
    DatagramSocket socket = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp_client);
        Intent intent = new Intent(this,MyUdpService.class);
        startService(intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //设置客户端监听端口9000
                            socket = new DatagramSocket(9000);
                            InetAddress address = InetAddress.getLocalHost();
                            //设置阻塞时间
                            socket.setSoTimeout(5000);

                            //将要发送的数据打包成packget并发送
                            DatagramPacket sendPacket = new DatagramPacket(dataStr.getBytes(),dataStr.length(),address,3000);
                            socket.send(sendPacket);

                            //准备packet用来接收服务端的数据
                            receivePacket = new DatagramPacket(buf,1024);
                            socket.receive(receivePacket);

                            //这里getData获取的是缓冲区的大小，数据的真实长度应用用getLength()获取
                            String serverMsg = new String(receivePacket.getData(),0,receivePacket.getLength());
                            Log.i(TAG,serverMsg);

                            //由于每次receive后，receivePacket的大小都会变成数据的大小，所以这里要手动把数组大小设置回来，避免数据丢失。
                            receivePacket.setLength(1024);

                        } catch (SocketException e) {
                            e.printStackTrace();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (InterruptedIOException e){
                            System.out.println("超时重发:"+tryTimes);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        socket.close();
                    }
                }).start();
            }
        });
    }
}
