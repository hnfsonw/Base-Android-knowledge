package com.hnf.guet.moreknowleagemoremoney.Android.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hnf.guet.moreknowleagemoremoney.R;

import retrofit2.Retrofit;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        request();
    }

    private void request() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://fy.iciba.com/")
//                .addConverterFactory()
    }
}
