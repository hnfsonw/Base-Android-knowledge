package com.hnf.guet.moreknowleagemoremoney.Android.MVP.presenter.callback;

public interface CallBack<T> {
    void onSuccess(T response);

    void onError(Throwable t);
}
