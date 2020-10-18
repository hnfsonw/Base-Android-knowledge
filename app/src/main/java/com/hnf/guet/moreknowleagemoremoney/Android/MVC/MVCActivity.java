package com.hnf.guet.moreknowleagemoremoney.Android.MVC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hnf.guet.moreknowleagemoremoney.R;


/**
 * 实现：点击按钮，根据传入的ID查找出bean
 */

public class MVCActivity extends AppCompatActivity {
    private EditText editText;
    private Button btn;
    private TextView textView;

    private MVCModel mvcModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        mvcModel = new MVCModel();
        textView = findViewById(R.id.my_textview);
        editText = findViewById(R.id.my_edit);
        btn = findViewById(R.id.my_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvcModel.queryBeanById(editText.getText().toString(), new MvcCallBack() {
                    @Override
                    public void querySuccess(String name) {
                        showSuccess(name);
                    }

                    @Override
                    public void queryFail() {
                        showFaild("查无此人");
                    }
                });
            }
        });
    }

    private void showFaild(String msg) {
        textView.setText(msg);
    }

    private void showSuccess(String name) {
        textView.setText(name);
    }


}
