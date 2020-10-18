package com.hnf.guet.moreknowleagemoremoney.Thread;

import java.util.concurrent.CyclicBarrier;


/**
 * 实现所有线程都完成步骤一了才继续往下执行步骤二的需求
 */
public class CyclicBarrierDemo {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }

    /**
     *Thread-1 到达栅栏 A
     * Thread-3 到达栅栏 A
     * Thread-0 到达栅栏 A
     * Thread-4 到达栅栏 A
     * Thread-2 到达栅栏 A
     * Thread-2 完成最后任务
     * Thread-2 冲破栅栏 A
     * Thread-1 冲破栅栏 A
     * Thread-3 冲破栅栏 A
     * Thread-4 冲破栅栏 A
     * Thread-0 冲破栅栏 A
     * Thread-4 到达栅栏 B
     * Thread-0 到达栅栏 B
     * Thread-3 到达栅栏 B
     * Thread-2 到达栅栏 B
     * Thread-1 到达栅栏 B
     * Thread-1 完成最后任务
     * Thread-1 冲破栅栏 B
     * Thread-0 冲破栅栏 B
     * Thread-4 冲破栅栏 B
     * Thread-2 冲破栅栏 B
     * Thread-3 冲破栅栏 B
     *
     *
     */

}
