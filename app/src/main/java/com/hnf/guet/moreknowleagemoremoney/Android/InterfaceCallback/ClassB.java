package com.hnf.guet.moreknowleagemoremoney.Android.InterfaceCallback;

/**
 * Created by SNOW on 2020/8/10.
 */
public class ClassB {
    private MyInterface myInterface;

    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public void testB(int a, int b){
        myInterface.sum(a+b);
    }

}
