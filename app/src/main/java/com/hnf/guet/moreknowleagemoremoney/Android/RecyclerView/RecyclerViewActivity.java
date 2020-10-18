package com.hnf.guet.moreknowleagemoremoney.Android.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.hnf.guet.moreknowleagemoremoney.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewActivity extends AppCompatActivity implements RecycItemClickListener{

    private static final String TAG = "RecyclerViewActivity";

    private ArrayList<HashMap<String,String>> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initDatas();
        initView();
    }

    private void initView() {
        RecyclerView rv = findViewById(R.id.my_recycview);
        LinearLayoutManager manager  = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);

        RecycAdapter adapter = new RecycAdapter(this,dataLists);
        adapter.setClickListener(this);

        rv.setAdapter(adapter);
    }

    private void initDatas() {
        dataLists = new ArrayList<>();
        for (int i = 0;i<100;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("txt1","这是标题"+i);
            hashMap.put("txt2","这是内容"+i);
            dataLists.add(hashMap);
        }
    }

    @Override
    public void itemClickListener(View view, int position) {
        Log.e(TAG,"点击了："+position);
    }
}
