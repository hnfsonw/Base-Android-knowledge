package com.hnf.guet.moreknowleagemoremoney.Android.TCP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hnf.guet.moreknowleagemoremoney.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpActivity extends AppCompatActivity {
    private static final String TAG = "TcpActivity";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.activity_tcp);
        Intent intent = new Intent(this,TcpService.class);
        startService(intent);

        editText = findViewById(R.id.edit_tcp);
        Button btn = findViewById(R.id.btn_tcp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        createTcpClient();
                    }
                }).start();
            }
        });
    }

    private void createTcpClient() {
        //tcp通信，客户端不需要绑定端口，系统会分配，但是要指明服务端的端口号；
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",6666);

            //发送消息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("服务端，你好!"+editText.getText());
            printWriter.flush();
            socket.shutdownOutput();

            //读取消息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String info = "";
            while ((info = reader.readLine()) != null){
                Log.e(TAG,"服务端:"+info+" ip:"+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
            }

            reader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
