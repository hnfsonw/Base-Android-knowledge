package com.hnf.guet.moreknowleagemoremoney.Android.CustomView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.hnf.guet.moreknowleagemoremoney.R;

import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void toShape(View view) {
        startActivity(new Intent(this, ShapeActivity.class));
    }

    public void toSelector(View view) {
        startActivity(new Intent(this, SelectorActivity.class));
    }

    public void toLayerList(View view) {
        startActivity(new Intent(this, LayerListActivity.class));
    }

    public void toAnimation(View view) {
        startActivity(new Intent(this, AnimationActivity.class));
    }


    public void useAssetsAndRaw(){
        /**
         * assets目录和res/raw的区别
         *
         * *res/raw和assets的相同点：
         * 两者目录下的文件在打包后会原封不动的保存在apk包中，不会被编译成二进制。
         *
         * *res/raw和assets的不同点：
         * 1.res/raw中的文件会被映射到R.java文件中，访问的时候直接使用资源ID即R.id.filename；
         * assets文件夹下的文件不会被映射到R.java中，访问的时候需要AssetManager类。
         *
         * 2.res/raw不可以有目录结构，而assets则可以有目录结构，也就是assets目录下可以再建立文件夹
         *
         */
        try {
            //读取res/raw下的文件资源的方式
            InputStream is = getResources().openRawResource(R.raw.dlrb);

            //读取assets下的文件资源的方式
            AssetManager assetManager = getAssets();
            InputStream is2 = assetManager.open("dlrb");

            //获取assets目录下的文件列表,还有很多方法
            String[] files = getAssets().list("");
        }catch (Exception e){

        }

    }


}
