package com.hnf.guet.moreknowleagemoremoney.Android.AsyncTask;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by SNOW on 2020/9/2.
 * 三个参数
 * 第一个：表示execute()发送的参数的类型，与doInBackground中一致
 * 第二个：表示进度的数据类型，与onProgressUpdate()中的一致
 * 第三个：表示结果的数据类型，与onPostExecute()中的参数一致
 *
 * 以下几个方法是按顺序执行的
 */
public class MyAsyncTask extends AsyncTask<String,Integer,String> {

    private static final String TAG = "MyAsyncTask";
    private Button btn;
    private ProgressBar bar;
    private TextView textView;

    public MyAsyncTask(Button btn, ProgressBar bar, TextView textView) {
        this.btn = btn;
        this.bar = bar;
        this.textView = textView;
    }


    /**
     * 运行在主线程
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btn.setText("下载");
        textView.setText("未下载");
        bar.setProgress(0);
    }

    /**
     * 运行在子线程
     * @param strings
     * @return
     */
    @Override
    protected String doInBackground(String... strings) {
        //这两个参数是excute中传过来的。
        String param1 = strings[0];
        String param2 = strings[1];

        Log.e(TAG,param1+"  "+param2);
        int count = 0;
        while (count < 99){
            count+=1;

            //这里的进度会传给onProgressUpdate（）方法
            publishProgress(count);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //执行结束的结果会传到onPostExecute（）中
        return "test";
    }

    /**
     * 运行在主线程
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //进度是从doInBackground中获取的
        bar.setProgress(values[0]);
        textView.setText(values[0]+"%");
    }

    /**
     * 运行在主线程
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.e(TAG,"result:"+s);
    }
}
