package com.hnf.guet.moreknowleagemoremoney.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    /**
     * emaphore（信号量）是用来控制同时访问特定资源的线程数量，
     * 它通过协调各个线程，以保证合理的使用公共资源。很多年以来，
     * 我都觉得从字面上很难理解Semaphore所表达的含义，
     * 只能把它比作是控制流量的红绿灯，比如XX马路要限制流量，
     * 只允许同时有一百辆车在这条路上行使，其他的都必须在路口等待，
     * 所以前一百辆车会看到绿灯，可以开进这条马路，后面的车会看到红灯，
     * 不能驶入XX马路，但是如果前一百辆中有五辆车已经离开了XX马路，
     * 那么后面就允许有5辆车驶入马路，这个例子里说的车就是线程，
     * 驶入马路就表示线程在执行，离开马路就表示线程执行完成，
     * 看见红灯就表示线程被阻塞，不能执行。
     *
     * semaphore可以用于流量控制。
     */

    private static ExecutorService threadpool = Executors.newFixedThreadPool(30);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0;i<30;i++){
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    //申请一个许可证
                    try {
                        semaphore.acquire();
                        System.out.println("Thread is running");
                        //释放许可证，从未允许一个新的线程去申请
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * api
     * tryAcquire()方法尝试获取许可证。
     * int availablePermits() ：返回此信号量中当前可用的许可证数。
     * int getQueueLength()：返回正在等待获取许可证的线程数。
     * boolean hasQueuedThreads() ：是否有线程正在等待获取许可证。
     * void reducePermits(int reduction) ：减少reduction个许可证。是个protected方法。
     * Collection getQueuedThreads() ：返回所有等待获取许可证的线程集合。是个protected方法。
     */
}
