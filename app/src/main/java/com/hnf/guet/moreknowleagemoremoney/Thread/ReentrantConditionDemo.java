package com.hnf.guet.moreknowleagemoremoney.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConditionDemo {
    private static ReentrantLock lock = new ReentrantLock();//非公平锁
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t1=new Thread(new task1(),"task1");
        Thread t2=new Thread(new task2(),"task2");
        t1.start();t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class task1 implements Runnable{
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行");
            System.out.println(Thread.currentThread().getName()+"释放锁并等待");
            try {
                //task1会释放锁并进入等待状态，那么task2就会获取到锁
                condition.await();
                System.out.println(Thread.currentThread().getName()+"重新获取到锁");
                System.out.println(Thread.currentThread().getName()+"执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    public static class task2 implements Runnable{
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行");
            System.out.println(Thread.currentThread().getName()+"开始唤醒其他线程");
            //在task2中唤醒task1,但是此时锁还是被task2占用着，所以需要等到task2执行完释放锁了，
            // task1才会继续执行
            condition.signal();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完成");
            lock.unlock();
        }
    }


    /**
     * 运行结果
     * task1开始执行
     * task1释放锁并等待
     * task2开始执行
     * task2开始唤醒其他线程
     * task2执行完成
     * task1重新获取到锁
     * task1执行完成
     */
}
