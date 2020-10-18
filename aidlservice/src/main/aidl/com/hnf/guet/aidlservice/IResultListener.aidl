// IResultListener.aidl
package com.hnf.guet.aidlservice;

// Declare any non-default types here with import statements
import com.hnf.guet.aidlservice.ParameterBean;

interface IResultListener {

    void onCaculateCompleted(in ParameterBean result);

}
