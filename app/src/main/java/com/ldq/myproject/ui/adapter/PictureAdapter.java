package com.ldq.myproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.PictureResult.ShowapiResBodyBean.PagebeanBean.PictureInfo;

import java.util.List;

/**
 * Created by LDQ on 2017/5/8.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.MyViewHolder> {
    public List<PictureInfo> data;
    private Context context;
    public MyViewHolder holder;

    public PictureAdapter(List<PictureInfo> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_picture, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        //加载网络图片
        Glide.with(context)
                .load(data.get(position).getList().get(0).getBig())
                .centerCrop()
                .placeholder(R.mipmap.aio_image_default_round)
                .error(R.mipmap.aio_image_fail_round)
                .crossFade()
                .into(holder.imageView);
        holder.tv_title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_title;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
