package com.hnf.guet.moreknowleagemoremoney.Android.Fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hnf.guet.moreknowleagemoremoney.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private MyListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 根据多态的特性，activity实现了接口，父类引用指向子类对象
         * 所以这里实例化接口就直接把接口的子类赋值给它就可以了
         */
        listener = (MyListener) getActivity();
    }

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listener.sendListener("这是fragment传给activity的数据");

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public interface MyListener{
        void sendListener(String info);
    }

}
