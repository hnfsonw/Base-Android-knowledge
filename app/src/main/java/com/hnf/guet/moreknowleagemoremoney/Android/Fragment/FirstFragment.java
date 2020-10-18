package com.hnf.guet.moreknowleagemoremoney.Android.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hnf.guet.moreknowleagemoremoney.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //获取activity传的值
        Bundle bundle = getArguments();
        String info = bundle.getString("info");

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


}
