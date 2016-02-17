package com.uuflow.zhihudaily.retrofit.retrofitService;

import com.uuflow.zhihudaily.model.NewsDetail;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author yelin.wu 16/2/17 下午4:56.
 * @description
 */
public interface NewsDetailService {
    @GET("news/{id}")
    Observable<NewsDetail> getNewsDetail(@Path("id") String id);
}
