package com.hnf.guet.moreknowleagemoremoney.Android.TCP;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpService extends IntentService {
    private static final String TAG = "TcpService";
    public TcpService() {
        super("TcpService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //服务端绑定端口号，监听此端口的信息
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            while (true){
                //每连入一个客户端，就创建一个socke，用于通信
                Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startThreadToAcceptMessages(socket);
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startThreadToAcceptMessages(Socket socket) {
        //获取从客户端传过来的字节流
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            //将字节流转换成字符流来读取
            InputStreamReader reader = new InputStreamReader(inputStream);
            //将字符流写入缓冲区
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null){
                info+= temp;
                Log.e(TAG,"客户端说:"+info+" ip:"+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
            }

            //创建输入字节流
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.print("你好，客户端!");
            writer.flush();
            socket.shutdownOutput();

            bufferedReader.close();
            reader.close();
            inputStream.close();

            outputStream.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
