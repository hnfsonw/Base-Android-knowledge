package com.hnf.guet.moreknowleagemoremoney.Android.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.hnf.guet.moreknowleagemoremoney.R;

public class FragmentActivity extends AppCompatActivity implements SecondFragment.MyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //向fragment传值
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("info","hnf");
        fragment.setArguments(bundle);

        //动态加载fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.parent_contaner,new FirstFragment());
        transaction.replace(R.id.parent_contaner,new FirstFragment());
        transaction.commit();


        //fragment通过接口回调的方式将值回传给activity


    }

    @Override
    public void sendListener(String info) {
        Log.e("Hnf","这是fragmen回传的数据");
    }
}
