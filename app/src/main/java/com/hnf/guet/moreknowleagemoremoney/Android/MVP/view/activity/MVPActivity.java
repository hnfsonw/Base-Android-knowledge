package com.hnf.guet.moreknowleagemoremoney.Android.MVP.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.impl.MVPAPresenterImpl;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.inter.IMVPAPresenter;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.view.inter.IMVPAView;
import com.hnf.guet.moreknowleagemoremoney.R;

public class MVPActivity extends AppCompatActivity implements IMVPAView {

    private IMVPAPresenter mIMVPAPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMVPAPresenter = new MVPAPresenterImpl(this);
        setContentView(R.layout.activity_mvp);
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag) {

    }
}
