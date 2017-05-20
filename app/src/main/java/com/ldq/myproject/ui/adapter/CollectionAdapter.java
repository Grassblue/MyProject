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
import com.ldq.myproject.bean.Collection;

import java.util.List;

/**
 * Created by LDQ on 2017/5/19.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyViewHolder> {
    private Context context;
    private List<Collection> datas;
    private MyViewHolder holder;

    public CollectionAdapter(Context context, List<Collection> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        holder = new CollectionAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_collection, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(!"".equals(datas.get(position).getPicUrl())){
            holder.img_collection.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(datas.get(position).getPicUrl())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_img_default)
                    .error(R.mipmap.ic_img_fail)
                    .crossFade()
                    .into(holder.img_collection);
        }
        holder.tv_collection.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_collection;
        TextView tv_collection;

        public MyViewHolder(View view) {
            super(view);
            img_collection = (ImageView) view.findViewById(R.id.img_collection);
            tv_collection = (TextView) view.findViewById(R.id.tv_collection);
        }
    }

    public void  setNewData(List<Collection> newData){
        datas.clear();
        datas.addAll(newData);
        notifyDataSetChanged();
    }
}
