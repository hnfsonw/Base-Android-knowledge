package com.hnf.guet.moreknowleagemoremoney.Android.LruCache;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.hnf.guet.moreknowleagemoremoney.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * LruCache的使用
 */
public class LruCacheActivity extends AppCompatActivity {

    private final String TAG = "LruCacheActivity";
    private ImageView imageView;
    private Button loadBtn;
    private MyImageLoader imageLoader;
    private String imgUrl = "https://upload-images.jianshu.io/upload_images/4655344-72f8111379394434.png";

    @SuppressLint("HandlerLeak")
    Handler mhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x11:
                    byte[] arr = (byte[]) msg.obj;
                    Bitmap bitmap = BitmapFactory.decodeByteArray(arr,0,arr.length);
                    imageLoader.addBitmap(imgUrl,bitmap);
                    imageView.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lru_cache);

        imageView = findViewById(R.id.lru_image);
        loadBtn = findViewById(R.id.load_btn);

        imageLoader = new MyImageLoader();
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmapFromCache();
                if (bitmap != null){
                    Log.e(TAG,"从缓存中读取图片");
                    imageView.setImageBitmap(bitmap);
                }else {
                    Log.e(TAG,"从网络下载图片");
                    dowloadImgFromNet();
                }
            }
        });
    }

    private void dowloadImgFromNet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(imgUrl)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final byte[] bytesArr = response.body().bytes();
                Log.i(TAG,"下载完成"+bytesArr.length);
                Message message = mhandler.obtainMessage();
                message.obj = bytesArr;
                message.what = 0x11;
                mhandler.sendMessage(message);
            }
        });
    }

    private Bitmap getBitmapFromCache() {
        return imageLoader.getBitmap(imgUrl);
    }
}
