package com.hnf.guet.moreknowleagemoremoney.Android.BitMap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * bitmap加载大图，避免oom
 */

public class BitMapActivity extends AppCompatActivity {
    private static final String TAG = "BitMapActivity";
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_map);
        imgView = findViewById(R.id.img_view);

        //Bitmap加载的几种方式
//        BitmapFactory.decodeFile("");
//        BitmapFactory.decodeByteArray();
//        BitmapFactory.decodeResource();
//        BitmapFactory.decodeStream();

        Bitmap bitmap  = BitmapFactory.decodeResource(getResources(),R.drawable.pexels);
        Bitmap copy = bitmap.copy(Bitmap.Config.RGB_565,false);
        Log.e(TAG,"原始大小:"+bitmap.getByteCount());

        imgView.setImageBitmap(copy);

        //回收bitmap
        bitmap.recycle();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                //imageview控件的宽和高不能再oncreate或者onResume()里面读取，否则读到的将会是0，因为控件的还没有绘制出来
                compressImg(imgView.getWidth(),imgView.getHeight());
            }
        }).start();


    }

    private void compressImg(int dstWidth, int dstHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//只读取尺寸，不加载进内存
        options.inPreferredConfig = Bitmap.Config.RGB_565;//不要透明度，清晰度中等

        //预加载后可以获取到图片真实的宽和高
        BitmapFactory.decodeResource(getResources(),R.drawable.pexels,options);
        int originWidth = options.outWidth;
        int originHeight = options.outHeight;

        //设置采样率，比如采样率设置为4，则从4个像素中只读取一个像素，采样率也高，失真越严重
        options.inSampleSize = getSimpleSize(originWidth,originHeight,dstWidth,dstHeight);
        options.inJustDecodeBounds = false;
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pexels,options);
        Log.e(TAG,"处理后的大小:"+bitmap.getByteCount());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imgView.setImageBitmap(bitmap);
            }
        });
    }

    private int getSimpleSize(int originWidth, int originHeight, int dstWidth, int dstHeight) {

        int simleSize = 1;
        if (originWidth > originHeight && originWidth > dstWidth){
            simleSize = originWidth/dstWidth;
        }else if (originWidth < originHeight && originHeight > dstHeight){
            simleSize = originHeight/dstHeight;
        }

        if (simleSize <= 0){
            simleSize = 1;
        }

        Log.e(TAG,"simleSize："+simleSize);
        return simleSize;
    }
}
