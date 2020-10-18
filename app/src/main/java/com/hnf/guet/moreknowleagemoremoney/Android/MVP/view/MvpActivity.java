package com.hnf.guet.moreknowleagemoremoney.Android.MVP.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.MvpPresenterImp;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.MvpPresenterInterface;
import com.hnf.guet.moreknowleagemoremoney.R;


public class MvpActivity extends AppCompatActivity implements IViewInterface, View.OnClickListener {
    private EditText editText;
    private Button btn;
    private TextView textView;

    //持有presenter实现类的引用，这样就可以调用presenter里面的方法
    private MvpPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        initInstances();
    }

    private void initInstances() {
        //向上转型，调用的是子类覆盖的父类的方法，但是将无法调用子类独有的方法
        //好处：可以将代码流程简化，具体实现过程有具体子类实现，无需关心
        presenter = new MvpPresenterImp(this);
    }

    private void initView() {
        textView = findViewById(R.id.mvp_textview);
        editText = findViewById(R.id.mvp_edit);
        btn = findViewById(R.id.mvp_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public String getInputId() {
        return editText.getText().toString();
    }

    @Override
    public void showSuccess(String name) {
        textView.setText(name);
    }

    @Override
    public void showFaild(String msg) {
        textView.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mvp_btn:
                presenter.getDatas();
                break;
            default:
                break;
        }
    }
}
