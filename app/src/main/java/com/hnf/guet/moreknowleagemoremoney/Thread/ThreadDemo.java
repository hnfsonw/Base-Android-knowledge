package com.hnf.guet.moreknowleagemoremoney.Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        //第一种方式：继承Thread
        MyThread1 myThread = new MyThread1();
        myThread.start();

        //第二种方式：实现runable接口
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        //第三种当时：匿名内部类实现runable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread three");
            }
        }).start();
    }


    static class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("Thread one");
        }
    }


    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread two");
        }
    }

}
