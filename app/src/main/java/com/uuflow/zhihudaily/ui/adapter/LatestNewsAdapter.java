package com.uuflow.zhihudaily.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.uuflow.zhihudaily.R;
import com.uuflow.zhihudaily.model.News;

import java.util.List;


/**
 * @author yelin.wu 16/2/17 下午2:28.
 * @description
 */
public  class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.ViewHolder> implements View.OnClickListener{

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    private List<News> mData;

    public LatestNewsAdapter(List<News> data) {
        mData = data;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,(String)view.getTag());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;
        private SimpleDraweeView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.news_text);
            mImageView = (SimpleDraweeView) itemView.findViewById(R.id.news_image);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest_news,parent,false);
        ViewHolder vh = new ViewHolder(v);
        v.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position).getTitle());

        DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(mData.get(position).getImages()[0]).build();
        holder.mImageView.setController(controller);

        holder.itemView.setTag(mData.get(position).getId() + "");



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
}
