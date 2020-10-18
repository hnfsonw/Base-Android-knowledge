// IMyAidlInterfaceManager.aidl
package com.hnf.guet.aidlservice;

// Declare any non-default types here with import statements
import com.hnf.guet.aidlservice.ParameterBean;
import com.hnf.guet.aidlservice.IResultListener;

interface IMyAidlInterfaceManager {

    void onCaculateResult(in ParameterBean ags1,in ParameterBean ags2);

    void registerListener(in IResultListener listener);

    void unRegisterListener(in IResultListener listener);

}
