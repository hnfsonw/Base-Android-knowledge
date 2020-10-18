package com.hnf.guet.moreknowleagemoremoney.Android.MVP.model;


import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.MvpCallBack;

/**
 * Created by SNOW on 2020/8/27.
 */
public interface MvpModelInterface {
    void queryDataById(String id, MvpCallBack mvpCallBack);
}
