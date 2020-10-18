package com.hnf.guet.moreknowleagemoremoney.InnerClass;

public class OutTest {
    public OutTest(){
        System.out.println("this is outTest");
    }


    public class InnerTest{
        public InnerTest(){
            System.out.println("this is innerTest");
        }
    }

    public static class staticInnerClass{
        public staticInnerClass(){
            System.out.println("this is staticInnerTest");
        }
    }
}
