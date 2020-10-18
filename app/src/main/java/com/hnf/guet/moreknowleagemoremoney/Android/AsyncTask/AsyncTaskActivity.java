package com.hnf.guet.moreknowleagemoremoney.Android.AsyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.hnf.guet.moreknowleagemoremoney.R;

public class AsyncTaskActivity extends AppCompatActivity {
    private Button btn,cancelBtn;
    private ProgressBar bar;
    private TextView textView;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        bar = findViewById(R.id.async_progressBar);
        btn = findViewById(R.id.async_button2);
        textView = findViewById(R.id.async_textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask(btn,bar,textView);

                //这里传的参数将会在MyAsyncTask中接收到
                myAsyncTask.execute("参数一","参数二");
            }
        });

        cancelBtn = findViewById(R.id.async_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask.cancel(true);
            }
        });
    }
}
