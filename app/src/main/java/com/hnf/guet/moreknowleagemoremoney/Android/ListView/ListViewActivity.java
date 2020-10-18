package com.hnf.guet.moreknowleagemoremoney.Android.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.hnf.guet.moreknowleagemoremoney.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /**
         * ArrayAdapter，适合简单的数组数据集合
         */
//        ListView listView = findViewById(R.id.list_view_one);
//        List<String> datas = new ArrayList<>();
//        for (int i =0;i<100;i++){
//            datas.add("item"+i);
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
//        listView.setAdapter(adapter);

        /**
         * SimpleAdapter
         */
//        String[] name = new String[]{"张三","李斯","王五"};
//        int[] pictureId = new int[]{R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
//
//        ArrayList<HashMap<String,Object>> listItem = new ArrayList<>();
//        for (int i = 0;i<name.length;i++){
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("name",name[i]);
//            hashMap.put("picture",pictureId[i]);
//            listItem.add(hashMap);
//        }
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItem,R.layout.list_view_cell_one,name,pictureId);
//        ListView listView = findViewById(R.id.list_view_one);
//        listView.setAdapter(simpleAdapter);


        /**
         * BaseAdapter,适用于item自定义，方便扩展
         */
        ListView listView = findViewById(R.id.list_view_one);
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        for (int i =0;i<100;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("txt1","这是标题"+i);
            hashMap.put("txt2","这是内容"+i);
            list.add(hashMap);
        }

        ListViewAdapter adapter = new ListViewAdapter(this,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("HNF","点击了"+position);
            }
        });
    }
}
