package com.hnf.guet.moreknowleagemoremoney.Android.InterfaceCallback;

/**
 * Created by SNOW on 2020/8/10.
 */
public class TestMain2 {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        ClassA classA = new ClassA(classB);
        classA.testA(11,2);
    }
}
