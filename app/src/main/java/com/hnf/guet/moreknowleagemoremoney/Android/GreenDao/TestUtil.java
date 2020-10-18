package com.hnf.guet.moreknowleagemoremoney.Android.GreenDao;

import android.util.Log;

/**
 * Created by SNOW on 2020/8/17.
 */
public class TestUtil {

    public static void test(final UserBean userBean){
        Log.i("HNF"," 22222:"+userBean.getName());
        test2(userBean);
    }

    private static void test2(final UserBean userBean){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    Log.i("HNF","3333:"+userBean.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
