package com.hnf.guet.moreknowleagemoremoney.Android.InterfaceCallback;

/**
 * Created by SNOW on 2020/8/10.
 *
 * A接收参数，给B计算，B把计算结果返回
 */
public class ClassA {
    private ClassB classB;

    public ClassA(ClassB classB){
        this.classB = classB;
        classB.setMyInterface(new MyInterface() {
            @Override
            public void sum(int sum) {
                System.out.println("sum："+sum);
            }
        });
    }

    public void testA(int a,int b){
        classB.testB(a,b);
    }

//    @Override
//    public void sum(int sum) {
//        System.out.println("sum:"+sum);
//    }
}
