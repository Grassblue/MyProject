package com.ldq.myproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldq.myproject.R;
import com.ldq.myproject.bean.Collection;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.util.LogUtils;

import java.util.List;

/**
 * Created by LDQ on 2017/5/19.
 */

public class CollectionAdapter{
    private Context context;
    private List<Collection> datas;
    private boolean isOpenLoadMore;

    public CollectionAdapter(View itemView, Context context, List<Collection> datas, boolean isOpenLoadMore) {
        this.context = context;
        this.datas = datas;
        this.isOpenLoadMore = isOpenLoadMore;
    }

    public void convert(MyViewHolder holder,Collection data, int viewType) {
        LogUtils.e("convert:" + viewType);
        switch (viewType) {
            case Constant.COLLECTION_TYPE_NEWS:
                loadNews(holder,data);
                break;
            case Constant.COLLECTION_TYPE_JOKE:
                loadJoke(holder,data);
                break;
            case Constant.COLLECTION_TYPE_PIC:
                loadPic(holder,data);
                break;
        }
    }

    private void loadNews(MyViewHolder holder,Collection data) {
        holder.tv_title.setText(data.getTitle());
    }

    private void loadJoke(MyViewHolder holder,Collection data) {
        holder.tv_jokeContent.setText(data.getTitle());
    }

    private void loadPic(MyViewHolder holder,Collection data) {
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_title,tv_jokeContent;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_jokeContent = (TextView) view.findViewById(R.id.tv_jokeContent);
        }
    }

    private int getItemLayoutId(int viewType) {
        LogUtils.e("getItemLayoutId:"+viewType);
        switch (viewType){
            case Constant.COLLECTION_TYPE_NEWS:
                return R.layout.fragment_news;
            case Constant.COLLECTION_TYPE_JOKE:
                return R.layout.fragment_joke;
            case Constant.COLLECTION_TYPE_PIC:
                return R.layout.fragment_picture;
        }
        return 0;
    }

    private int getViewType(int position, Collection data) {
        LogUtils.e("getViewType:"+data.getType()+"|"+datas.get(position).getType());
        return datas.get(position).getType();
    }
}
