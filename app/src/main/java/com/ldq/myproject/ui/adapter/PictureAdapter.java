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
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        //加载网络图片
        Glide.with(context)
                .load(data.get(position).getList().get(0).getBig())
                .centerCrop()
                .placeholder(R.mipmap.ic_img_default)
                .error(R.mipmap.ic_img_fail)
                .crossFade()
                .into(holder.imageView);
        holder.tv_title.setText(data.get(position).getTitle());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null)
                    onItemLongClickListener.onLongClick(position);
                //返回false会在长安结束后继续点击
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    //    长按点击事件
    public interface OnItemLongClickListener {
        void onLongClick(int position);
    }

    OnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
