package com.hnf.guet.moreknowleagemoremoney.Android.ListView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.hnf.guet.moreknowleagemoremoney.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SNOW on 2020/8/24.
 */
public class ListViewAdapter extends BaseAdapter {
    ArrayList<HashMap<String,String>> itemLists;
    private LayoutInflater inflater;
    public ListViewAdapter(Context context,ArrayList<HashMap<String,String>> itemLists){
        this.itemLists = itemLists;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemLists.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLists.get(position);
    }

    /**
     * 返回item的Id
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_cell_one,null);
            holder.textOne = convertView.findViewById(R.id.text1);
            holder.textTwo = convertView.findViewById(R.id.text2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textOne.setText(itemLists.get(position).get("txt1"));
        holder.textTwo.setText(itemLists.get(position).get("txt2"));
        return convertView;
    }

    static class ViewHolder{
        public TextView textOne;
        public TextView textTwo;
    }
}
