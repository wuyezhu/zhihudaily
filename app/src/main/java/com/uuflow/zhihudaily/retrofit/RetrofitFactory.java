package com.uuflow.zhihudaily.retrofit;


import com.uuflow.zhihudaily.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yelin.wu 16/2/17 上午11:13.
 * @description
 */
public class RetrofitFactory {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static final String DEV_BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static String baseUrl;
    static {
        baseUrl = BuildConfig.DEBUG ? DEV_BASE_URL : BASE_URL;
    }
    private RetrofitFactory(){}
    public static Object create(Class clazz){
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl).client(okHttpClient).build();
        return retrofit.create(clazz);
    }
}
