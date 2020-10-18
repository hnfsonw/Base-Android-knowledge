package com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.hnf.guet.moreknowleagemoremoney.Android.MVP.model.MvpModelImp;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.model.MvpModelInterface;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.view.IViewInterface;


/**
 * Created by SNOW on 2020/8/27.
 * presentr主要处理业务逻辑，不进行任何的网络请求
 * 没有任何的android API,单纯是java代码，所以可以用单元测试进行presenter层的测试
 */
public class MvpPresenterImp implements MvpPresenterInterface{
    private MvpModelInterface mvcModel;
    private IViewInterface viewInterface;

    public MvpPresenterImp(IViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        mvcModel = new MvpModelImp();
    }

    @Override
    public void getDatas() {
        if (TextUtils.isEmpty(viewInterface.getInputId().trim())){
            viewInterface.showFaild("请输入id");
        }else {
            mvcModel.queryDataById(viewInterface.getInputId(), new MvpCallBack() {
                @Override
                public void querySuccess(String name) {
                    viewInterface.showSuccess(name);
                }

                @Override
                public void queryFail() {
                    viewInterface.showFaild("查无此人");
                }
            });
        }
    }
}
