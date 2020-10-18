package com.hnf.guet.moreknowleagemoremoney.Thread;

public class StopThreadDemo {
    public static void main(String[] args) {
        HThread hThread = new HThread();
        hThread.start();

        hThread.isInterrupted();
    }


    /**
     * 这种方式能通用关闭阻塞和运行状态的线程
     */
    static class HThread extends Thread{
        @Override
        public void run() {

            //用于中断运行状态的线程
            try {
                while (!isInterrupted()){
                    Thread.sleep(1000);
                    System.out.println("hread running……");
                }
            }catch (InterruptedException e){
                //用于中断阻塞状态的线程
            }
        }
    }

    /**
     * 第二种方式：额外添加一个flag，并提供一个stopTask()修改该flag的值，当flag改变的时候，退出线程
     * 原理与上面第一种方式类似
     */
}
