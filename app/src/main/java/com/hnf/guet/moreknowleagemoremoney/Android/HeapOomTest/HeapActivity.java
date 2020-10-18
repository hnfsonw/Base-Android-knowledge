package com.hnf.guet.moreknowleagemoremoney.Android.HeapOomTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 单例模式引起的内存泄露demo
 * android profiler排查内存泄露demo
 */

public class HeapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heap);

       MySingleInstance.getInstance(this);
    }

}

