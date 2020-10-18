package com.hnf.guet.moreknowleagemoremoney.Android.MVP.model;

import com.hnf.guet.moreknowleagemoremoney.Android.MVP.entity.JavaBean;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.MvpCallBack;

import java.util.ArrayList;

/**
 * Created by SNOW on 2020/8/26.
 * model主要用于处理数据，包括数据库的数据查找已经网络数据的请求解析等等
 */
public class MvpModelImp implements MvpModelInterface{
    private ArrayList<JavaBean> lists;

    public MvpModelImp(){
        lists = new ArrayList<>();
        initData();
    }

    private void initData() {
        for (int i = 0;i<10;i++){
            JavaBean bean = new JavaBean();
            bean.setId(String.valueOf(i));
            bean.setName(i+"号");
            lists.add(bean);
        }
    }

    @Override
    public void queryDataById(String id, MvpCallBack mvpCallBack) {
        boolean isfind = false;
        for (JavaBean bean:lists){
            if (id.equals(bean.getId())){
                isfind = true;
                mvpCallBack.querySuccess(bean.getName());
            }
        }
        if (!isfind){
            mvpCallBack.queryFail();
        }
    }
}
