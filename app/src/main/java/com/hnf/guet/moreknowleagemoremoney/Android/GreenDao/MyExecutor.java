package com.hnf.guet.moreknowleagemoremoney.Android.GreenDao;


import androidx.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu
 * @date 2017-12-19
 * corePoolSize:核心线程池的大小，默认情况下没有线程，任务来了才会创建线程，除非调用了
 * prestartAllCoreThreads()或者prestartCoreThread()方法，在创建了线程池后，线程池中的线程数为0，
 * 当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，
 * 就会把到达的任务放到缓存队列当中；
 */

public class MyExecutor {
    private static final Executor THREAD_POOL_EXECUTOR, THREAD_NET_EXCUTOR;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = 32;
    private static final int CORE_POOL_SIZE_MIN = 10;
    private static final int MAXIMUM_POOL_SIZE = 64;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final BlockingQueue<Runnable> S_POOL_WORK_QUEUE =
            new LinkedBlockingQueue<Runnable>(128);
    private static final ThreadFactory S_THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(@NonNull Runnable r) {
            return new Thread(r, "MyExecutor #" + mCount.getAndIncrement());
        }
    };

    static {
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS
                , TimeUnit.SECONDS, S_POOL_WORK_QUEUE, S_THREAD_FACTORY);

        THREAD_NET_EXCUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE_MIN, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS,
                TimeUnit.SECONDS, S_POOL_WORK_QUEUE, S_THREAD_FACTORY);

        service = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
    }

    private static ScheduledExecutorService service;


    public static void execute(Runnable runnable) {
        THREAD_POOL_EXECUTOR.execute(runnable);
    }

    public static void executeNet(Runnable runnable) {
        THREAD_NET_EXCUTOR.execute(runnable);
    }

    public static void scheduleWithFixedDelay(Runnable runnable, long delay, TimeUnit unit) {
        service.schedule(runnable, delay, unit);

    }

    public static ScheduledFuture<?> scheduleWithFixedDelays(Runnable runnable, long delay, TimeUnit unit) {
        return service.schedule(runnable, delay, unit);

    }

    /**
     * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,TimeUnit unit)
     * 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次
     * 执行开始之间都存在给定的延迟，如果任务的执行时间超过了廷迟时间（delay），下一个任务则会在
     * （当前任务执行所需时间+delay）后执行。
     * 任务结束后才会执行下一次任务
     * <p>
     * 以固定延迟时间进行执行
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     */

    public static void scheduleWithFixedDelay(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
        service.scheduleWithFixedDelay(runnable, initialDelay, delay, unit);
    }


    public static ScheduledFuture<?> scheduleWithFixedDelays(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
        return service.scheduleWithFixedDelay(runnable, initialDelay, delay, unit);
    }


    /**
     * 以固定周期频率执行任务
     */
    public static void scheduleWithFixedRate(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
        service.scheduleAtFixedRate(runnable, initialDelay, delay, unit);
    }
}
