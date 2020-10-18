package com.hnf.guet.moreknowleagemoremoney.Android.ANR;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.R;


public class AnrActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);
        textView = findViewById(R.id.anr_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("子线程更新UI");
                textView.requestLayout();
            }
        }).start();
    }
}
