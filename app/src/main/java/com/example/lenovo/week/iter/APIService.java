package com.example.lenovo.week.iter;

import com.example.lenovo.week.bean.UserBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;


/**
 * Created by lenovo on 2017/12/2.
 */

public interface APIService {
    @GET("homePageApi/homePage.do")
    Observable<UserBean> getdata();
    Retrofit RETROFIT=new Retrofit.Builder()
            .baseUrl(Url.URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    APIService API_SERVICE=RETROFIT.create(APIService.class);
}