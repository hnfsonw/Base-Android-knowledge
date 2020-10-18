package com.hnf.guet.moreknowleagemoremoney.InnerClass;

public class Test {
    public static void main(String[] args) {
        //访问成员内部类
        OutTest.InnerTest innerTest = new OutTest().new InnerTest();

        //访问静态内部类
        OutTest.staticInnerClass staticInnerClass = new OutTest.staticInnerClass();
    }
}
