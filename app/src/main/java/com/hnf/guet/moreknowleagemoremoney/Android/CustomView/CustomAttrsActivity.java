package com.hnf.guet.moreknowleagemoremoney.Android.CustomView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hnf.guet.moreknowleagemoremoney.R;


//系统自带的View可以在xml中配置属性，对于写的好的Custom View同样可以在xml中配置属性，为了使自定义的View的属性可以在xml中配置，需要以下4个步骤：
//
//        通过<declare-styleable>为自定义View添加属性
//
//        在xml中为相应的属性声明属性值
//
//        在运行时（一般为构造函数）获取属性值
public class CustomAttrsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_attrs);
    }
}
