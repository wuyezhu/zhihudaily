package com.uuflow.zhihudaily.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.uuflow.zhihudaily.R;
import com.uuflow.zhihudaily.model.NewsDetail;
import com.uuflow.zhihudaily.retrofit.RetrofitFactory;
import com.uuflow.zhihudaily.retrofit.retrofitService.NewsDetailService;
import com.uuflow.zhihudaily.utils.L;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mWebView = (WebView) findViewById(R.id.wv_detail);


        NewsDetailService newsDetailService = (NewsDetailService) RetrofitFactory.create(NewsDetailService.class);
        Observable<NewsDetail> detailObservable = newsDetailService.getNewsDetail(getPreString("id"));
        detailObservable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsDetail -> {
                    mWebView.loadData("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://news-at.zhihu.com/css/news_qa.auto.css?v=77778\">"  + newsDetail.getBody(), "text/html;charset=UTF-8", null);
                    L.e(newsDetail.getBody());
                    L.e(newsDetail.getCss()[0]);
                });

    }
}
