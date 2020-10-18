package com.hnf.guet.moreknowleagemoremoney.Android.MutilProcess;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;


/**
 * Android多进程开发
 * 多进程的好处：
 * 把一个大的apk拆分成多个模块，让每一个模块都运行在单独的进程中，可以减少单个进程所占用的
 * 内存，避免内存占用过大被系统杀死；同时，单个进程的崩溃不影响其他进程的正常执行。
 *
 * 缺点:
 * Application会多次重建，因为当一个组件定义为另一个进程时候，如果该进程不存在，系统会
 * 先创建对应的进程才创建该组件，此时就会重新创建一个applciation.
 * 静态成员、单例、线程同步都会失效，因为不同的进程内存空间是隔离的。
 * 多进程访问同一个数据库文件的时候，可能会造成资源的竞争访问。
 *
 *
 * 使用：
 * Android的四大组件均可以在Manifest里面设置属性android:process来设置其所属进程
 * 正常情况下，apk的进程名就是该apk的包名
 * 如果android:process的值以冒号开头，那么表示该进程为私有进程，例 android:process=":processActivity"
 * 否则表示公有进程。
 *
 * 私有进程：其他应用的组件不可以和该组件运行在同一个进程中
 * 公有进程：其他应用可以通过设置ShareUID使之可以和该组件运行在同一个进程中。
 * ShareUID：使数据共享，应用之间可以互相调用资源。
 *
 */

public class MutilApplaction extends Application {

    /**
     * 程序创建的时候执行
     */
    @Override
    public void onCreate() {


    }

    /**
     * 程序终此的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 内存低的时候执行
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    /**
     * 清理内存的时候执行
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    /**
     * 横竖屏或者配置发生改变的时候执行
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
