package com.hnf.guet.moreknowleagemoremoney.Android.HeapOomTest;

import android.content.Context;

import java.lang.ref.WeakReference;

import kotlin.jvm.Synchronized;

/**
 * Created by SNOW on 2020/8/26.
 */
public class MySingleInstance {
    private static volatile MySingleInstance instance;

    /**
     * 此处，由于单例的生命周期与应用的生命周期一致，所以如果这里传入的是activity的上下文
     * 当activity退出的时候，由于此处持有activity的引用，所以activity无法被回收，就会造成内存泄露
     *
     * 修改方式：使用软引用
     */
//    private Context mContext;

    private WeakReference<Context> mContext;

    public MySingleInstance(Context context){
        mContext = new WeakReference<>(context);
    }

    public static MySingleInstance getInstance(Context context){
        if (instance == null){
            synchronized (MySingleInstance.class){
                if (instance == null){
                    instance = new MySingleInstance(context);
                }
            }
        }
        return instance;
    }

}
