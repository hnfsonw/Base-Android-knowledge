package com.hnf.guet.moreknowleagemoremoney.Android.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.hnf.guet.moreknowleagemoremoney.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SNOW on 2020/8/24.
 */
public class RecycAdapter extends RecyclerView.Adapter {
    private ArrayList<HashMap<String,String>> itemLists;
    private LayoutInflater inflater;
    private RecycItemClickListener clickListener;

    public void setClickListener(RecycItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public RecycAdapter(Context context, ArrayList<HashMap<String,String>> itemLists){
        this.itemLists = itemLists;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.recyc_item_cell,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        //数据和控件绑定
        vh.getText1().setText(itemLists.get(position).get("txt1"));
        vh.getText2().setText(itemLists.get(position).get("txt2"));
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text1,text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.txt1);
            text2 = itemView.findViewById(R.id.txt2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //添加item点击事件
                    //getAdapterPosition和getLayoutPosition
                    clickListener.itemClickListener(v,getAdapterPosition());
                }
            });
        }

        public TextView getText1() {
            return text1;
        }

        public TextView getText2() {
            return text2;
        }
    }
}
