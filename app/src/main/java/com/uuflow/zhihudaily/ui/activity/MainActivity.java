package com.uuflow.zhihudaily.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.uuflow.zhihudaily.R;
import com.uuflow.zhihudaily.model.LatestNews;
import com.uuflow.zhihudaily.retrofit.RetrofitFactory;
import com.uuflow.zhihudaily.retrofit.retrofitService.LatestNewsService;
import com.uuflow.zhihudaily.ui.adapter.LatestNewsAdapter;
import com.uuflow.zhihudaily.utils.L;
import com.uuflow.zhihudaily.utils.ToastUtil;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements LatestNewsAdapter.OnRecyclerViewItemClickListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_news);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);






        Observable<LatestNews> latestNews = ((LatestNewsService) RetrofitFactory.create(LatestNewsService.class)).getLatestNews();
        latestNews.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(latestNews1 -> {
                    ToastUtil.showLongToast("get latestNews success....  ");
                    L.e(latestNews1.toString());
                    LatestNewsAdapter latestNewsAdapter = new LatestNewsAdapter(latestNews1.getStories());
                    latestNewsAdapter.setOnRecyclerViewItemClickListener(this);
                    mRecyclerView.setAdapter(latestNewsAdapter);
                });
    }

    @Override
    public void onItemClick(View itemView, String data) {
        Bundle bundle = new Bundle();
        bundle.putString("id",data);
        startActivity(DetailActivity.class,bundle);
    }
}
