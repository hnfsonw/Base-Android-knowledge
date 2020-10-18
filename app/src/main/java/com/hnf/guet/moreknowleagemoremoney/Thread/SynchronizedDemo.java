package com.hnf.guet.moreknowleagemoremoney.Thread;

public class SynchronizedDemo {
    public static void main(String[] args) {

    }


    //修饰普通方法,锁的是调用该方法的对象
    public synchronized void test(){

    }

    //这种写法，锁定的也是本方法所在的类的实例化对象
    public void test1(){
        synchronized (this){

        }
    }

    //这种写法，锁定的是object这个对象
    public void test2(Object object){
        synchronized (object){

        }
    }

    //修饰静态方法，锁住的是类的所有对象，即某一时刻只能有一个线程访问该类
    public static synchronized void test3(){

    }


    //这种写法修饰的也是一个类的所有对象
    public void test4(){
        synchronized (SynchronizedDemo.class){

        }
    }




}