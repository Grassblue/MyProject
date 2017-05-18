package com.ldq.myproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.NewsResult.ResultBean.News;

import java.util.List;

/**
 * Created by S01 on 2017/5/6.
 */

public class NewsAdapter extends BaseAdapter{
    public List<News> data;
    public ViewHolder holder;

    public NewsAdapter() {
    }

    public NewsAdapter(List<News> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_news,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //加载网络图片
        Glide.with(parent.getContext())
                .load(data.get(position).getThumbnail_pic_s())
                .centerCrop()
                .placeholder(R.mipmap.ic_img_default)
                .error(R.mipmap.ic_img_fail)
                .crossFade()
                .into(holder.img_news);
        holder.tv_title.setText(data.get(position).getTitle());

        return convertView;
    }

    class ViewHolder{
        ImageView img_news;
        TextView tv_title;

        public ViewHolder(View convertView){
            img_news = (ImageView) convertView.findViewById(R.id.img_news);
            tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        }
    }

    //下拉刷新:刷新第一页数据，先清空原数据，再重新添加新数据，然后更新UI
    public void setNewData(List<News> newData){
        data.clear();;
        data.addAll(newData);
        notifyDataSetChanged();
    }

    //加载更多:加载下一页数据，所以请求时page++，只需要把新数据添加到原数据的后面，然后更新UI
    public void getMoreData(List<News> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }
}
