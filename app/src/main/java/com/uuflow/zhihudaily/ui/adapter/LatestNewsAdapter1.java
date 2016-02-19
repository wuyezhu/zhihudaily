package com.uuflow.zhihudaily.ui.adapter;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uuflow.zhihudaily.R;
import com.uuflow.zhihudaily.databinding.ItemLatestNewsBinding;
import com.uuflow.zhihudaily.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelin.wu 16/2/18 上午10:05.
 * @description 使用dataBinding的Adapter
 */
public  class LatestNewsAdapter1 extends RecyclerView.Adapter<LatestNewsAdapter1.ViewHolder> implements View.OnClickListener{

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    private List<News> mData = new ArrayList<>();

   /* public LatestNewsAdapter1(List<News> data) {
        mData = data;
    }*/

    public void addData(List<News> data){
        if (data == null) {
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void replaceData(List<News> data){
        mData.clear();
        addData(data);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,(String)view.getTag());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemLatestNewsBinding mBind;
        public ViewHolder(View itemView) {
            super(itemView);
            mBind = ItemLatestNewsBinding.bind(itemView);
        }

        public ViewDataBinding getViewDataBinding() {
            return mBind;
        }

        public void bind(@NonNull News news){
            mBind.setNews(news);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest_news, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = mData.get(position);
        holder.bind(news);
        holder.itemView.setTag(Long.toString(news.getId()));
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener listener){
        mOnItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public interface OnRecyclerViewItemClickListener{
        void onItemClick(View itemView,String data);
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(SimpleDraweeView imageView,String url){
        imageView.setImageURI(Uri.parse(url));

    }
}
