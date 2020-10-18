package com.hnf.guet.moreknowleagemoremoney.Android.SingleTaskExit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 一键退出app
 * 分为两步
 * 第一：结束掉所有Activity
 * （利用singleTask的原理，将入口activity设置为singleTask,该模式会把本activity上面的activty全部出栈）
 * 第二：关闭进程
 *
 * 优点：简单  缺点：只适用于单任务栈的，如果是多任务栈则不适用
 *
 * 注意：不能直接用System.exit(0)或者killProcess，
 * 因为如果是多个activity的话，这种方式只能把栈顶的activity销毁而已
 */

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btn = findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 当activity被放到栈顶的时候，会触发这个方法
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null){
            boolean isExit = intent.getBooleanExtra("isExit",false);
            if (isExit){
                Log.e(TAG,"finish myself");
                this.finish();
                //这里调用方法kill掉进程的话，会很突兀，apk退出没有动画
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
