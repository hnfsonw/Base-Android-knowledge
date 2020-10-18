package com.hnf.guet.moreknowleagemoremoney.Android.ScreenAdapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 *屏幕适配技巧
 * 一：多使用自适应布局，比如RelativeLayout,LinearLayout，FrameLayout
 * 二：使用最小限定符，sw  比如下面的这个布局，定义了两个，一个在res/layout中
 *     一个在res/layout-sw600dp中，当屏幕像素从px转化为dp后，最小的边大于600dp的话则加载 res/layout-sw600dp中的
 *     布局文件，否则加载res/layout中的布局文件。android 3.2以后还可以使用 最小宽度限定符 w,最小高度限定符h
 *     比如 res/layout-w600dp或者res/layout-h600dp,用于横竖屏方面的处理
 * 三：图片资源的适配，如果有.9.png图的话可以直接放在drawable目录下，没有的话就需要有多套不同分辨率的图片
 *     但是如果没有多套的话可以放在xhdpi下，最主流的屏幕分辨率。
 * 四：界面适配，确定当前布局（通过判断某个view在布局中是否存在来判断使用哪个布局文件）
 *     根据当前布局做出响应 （根据不同的布局文件，跳转不同的界面）
 *     重复使用其他活动中的片段
 *     处理屏幕配置变化
 */

public class ScreenAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_adapter);
    }
}
