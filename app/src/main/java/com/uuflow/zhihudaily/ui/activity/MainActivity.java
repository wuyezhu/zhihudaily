package com.uuflow.zhihudaily.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.uuflow.zhihudaily.R;
import com.uuflow.zhihudaily.databinding.ActivityMainBinding;
import com.uuflow.zhihudaily.model.LatestNews;
import com.uuflow.zhihudaily.retrofit.RetrofitFactory;
import com.uuflow.zhihudaily.retrofit.retrofitService.LatestNewsService;
import com.uuflow.zhihudaily.ui.adapter.LatestNewsAdapter1;
import com.uuflow.zhihudaily.ui.widget.SuperSwipeRefreshLayout;
import com.uuflow.zhihudaily.utils.L;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends BaseActivity implements LatestNewsAdapter1.OnRecyclerViewItemClickListener{
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityMainBinding mBinding;
    private Date mDate = new Date();
    private Calendar mCalendar;
    private LatestNewsService mLatestNewsService;
    private LatestNewsAdapter1 mLatestNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(mDate);



        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLatestNewsService = (LatestNewsService) RetrofitFactory.create(LatestNewsService.class);
        mLatestNewsAdapter = new LatestNewsAdapter1();

        mBinding.srlHome.setTargetScrollWithLayout(false);




        mBinding.srlHome.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {

            }
        });

        mBinding.srlHome.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadMore();
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {

            }
        });
//        mBinding.srlHome.setOnRefreshListener(() -> fetchData());

        /*mBinding.rvNews.addOnScrollListener(new OnScrollListener() {
            boolean isScrollToBottom = false;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
                L.e("-------dx " + dx + "--------dy " + dy);
                if (dx > 0 || dy > 0) {
                    isScrollToBottom = true;
                }else{
                    isScrollToBottom = false;
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) mBinding.rvNews.getLayoutManager();
                L.e("here?");
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    L.e("is idle  .....");
                    int lastCompletelyVisibleItemPosition = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    if (lastCompletelyVisibleItemPosition == (totalItemCount - 1) && isScrollToBottom) {
                        ToastUtil.showLongToast("加载更多。。。。");
                        L.e("加载更多。。。。");
                    }
                }
            }
        });*/



        mBinding.rvNews.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mBinding.rvNews.setLayoutManager(mLayoutManager);
        fetchData();
    }

    private void loadMore() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        mCalendar.set(Calendar.DATE, mCalendar.get(Calendar.DATE) - 1);
        String endDate = sdf.format(mCalendar.getTime());
        Observable<LatestNews> beforeNews = mLatestNewsService.getBeforeNews(endDate);
        beforeNews.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beforeNews1 -> {
                    mLatestNewsAdapter.addData(beforeNews1.getStories());
                    mBinding.srlHome.setLoadMore(false);
                });

    }

    private void fetchData() {
        Observable<LatestNews> latestNews = mLatestNewsService.getLatestNews();
        latestNews.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(latestNews1 -> {
                    updateUI(latestNews1);
                });
    }

    private void updateUI(LatestNews latestNews1) {
        L.e(latestNews1.toString());
        mLatestNewsAdapter.setOnRecyclerViewItemClickListener(this);
        mBinding.rvNews.setAdapter(mLatestNewsAdapter);
        mLatestNewsAdapter.replaceData(latestNews1.getStories());
        mBinding.srlHome.setRefreshing(false);
    }

    @Override
    public void onItemClick(View itemView, String data) {
        Bundle bundle = new Bundle();
        bundle.putString("id",data);
        startActivity(DetailActivity.class, bundle);
    }
}
