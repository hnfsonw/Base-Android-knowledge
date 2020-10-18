package com.hnf.guet.moreknowleagemoremoney.Thread;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 */
public class ExxcutetorThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 创建固定大小的线程池，线程数量的固定的，当有新任务提交时，有空闲的线程就立即执行，没有空闲线程就放到队列
         *
         * 缺点：当任务频繁是，队列会迅速增大，耗尽资源；而且没有任务时，也不会释放工作线程，占用资源
         *
         * 所以没有任务执行的时候需要把线程池给shutdown掉
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        /**
         * 创建单个线程的线程池
         *
         * 所以没有任务执行的时候需要把线程池给shutdown掉
         */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();


        /**
         * 总会迫使线程池增加新的线程去执行新的任务。在没有任务执行时，
         * 当线程的空闲时间超过keepAliveTime（60秒），
         * 则工作线程将会终止被回收，当提交新任务时，如果没有空闲线程，
         * 则创建新线程执行任务，会导致一定的系统开销。如果同时又大量任务被提交，
         * 而且任务执行的时间不是特别快，那么线程池便会新增出等量的线程池处理任务，
         * 这很可能会很快耗尽系统的资源。
         */
        ExecutorService executorService2 = Executors.newCachedThreadPool();


        /**
         * 定时线程池，该线程池可用于周期性地去执行任务，通常用于周期性的同步数据。
         *
         * scheduleAtFixedRate:以固定的频率去执行任务，周期是指每次执行任务成功之间的间隔。
         * schedultWithFixedDelay:以固定的延时去执行任务，延时是指上一次执行成功之后和下一次开始执行的之前的时间。
         */
        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        executorService3.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

            }
        },0,2, TimeUnit.SECONDS);

        for (int i = 0;i<5;i++){
            executorService.execute(getThread(i));
        }
    }


    private static Runnable getThread(final int i) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }
}
