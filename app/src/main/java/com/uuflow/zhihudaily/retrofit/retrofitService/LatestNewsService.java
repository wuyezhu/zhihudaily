package com.uuflow.zhihudaily.retrofit.retrofitService;

import com.uuflow.zhihudaily.model.LatestNews;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 获取最新news
 * @author yelin.wu 16/2/17 上午11:38.
 * @description
 */
public interface LatestNewsService {
    @GET("news/latest")
    Observable<LatestNews> getLatestNews();
}
