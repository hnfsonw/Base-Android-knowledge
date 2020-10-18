package com.hnf.guet.moreknowleagemoremoney.Android.MVC;

import java.util.ArrayList;

/**
 * Created by SNOW on 2020/8/26.
 */
public class MVCModel {
    private ArrayList<JavaBean> lists;

    public MVCModel(){
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


    public void queryBeanById(String id,MvcCallBack callBack){
        boolean isfind = false;
        for (JavaBean bean:lists){
            if (id.equals(bean.getId())){
                isfind = true;
                callBack.querySuccess(bean.getName());
            }
        }
        if (!isfind){
            callBack.queryFail();
        }
    }
}
