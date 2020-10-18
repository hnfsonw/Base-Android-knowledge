package com.hnf.guet.moreknowleagemoremoney.Android.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INetRequest {

    /**
     * Retrofit把网络请求接口的URL分成了两个部分，一部分放在Retrofit对象里，另一部分放在网络请求中
     * 如果接口的url是一个完整的网络，那么Retrofit对象里面的Url可以忽略
     * @return
     */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
