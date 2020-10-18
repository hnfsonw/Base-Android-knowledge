package com.hnf.guet.moreknowleagemoremoney.Thread;

public class WaitAndNotify {
    private static final Object flag = new Object();

    public static void main(String[] args) {
        MyThead myThead = new MyThead("hnf");
        MyThreadB myThreadB = new MyThreadB();
        myThead.start();
        myThreadB.start();
    }


    static class MyThreadB extends Thread{
        @Override
        public void run() {
            synchronized (flag){
                for (int i = 0;i<20;i++){
                    flag.notify();
                    System.out.println("this is Thread B");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class MyThead extends Thread{

        public MyThead(String name){
            super(name);
        }

        @Override
        public void run() {
            synchronized (flag){
                for (int i = 0;i<20;i++){
                    flag.notify();
                    System.out.println("this is Thread A");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    在哪个线程里面调用wait方法，挂起的就是哪个线程
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
