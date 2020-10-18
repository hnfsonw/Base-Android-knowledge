package com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.impl;

import com.hnf.guet.moreknowleagemoremoney.Android.MVP.model.impl.MVPAModelImpl;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.model.inter.IMVPAModel;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.inter.IMVPAPresenter;
import com.hnf.guet.moreknowleagemoremoney.Android.MVP.view.inter.IMVPAView;

public class MVPAPresenterImpl implements IMVPAPresenter {
    private IMVPAView mIMVPAView;
    private IMVPAModel mIMVPAModel;

    public MVPAPresenterImpl(IMVPAView aIMVPAView) {
        mIMVPAView = aIMVPAView;
        mIMVPAModel = new MVPAModelImpl();
    }
}
