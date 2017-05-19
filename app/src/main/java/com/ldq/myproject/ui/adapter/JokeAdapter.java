package com.ldq.myproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ldq.myproject.R;
import com.ldq.myproject.bean.JokeResult.ResultBean.Joke;

import java.util.List;

/**
 * Created by S01 on 2017/5/6.
 */

public class JokeAdapter extends BaseAdapter {
    public List<Joke> data;
    public ViewHolder holder;

    public JokeAdapter(List<Joke> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_joke,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_jokeContent.setText(data.get(i).getContent());
        return view;
    }

    class ViewHolder{
        TextView tv_jokeContent;
        public ViewHolder(View view){
            tv_jokeContent = (TextView) view.findViewById(R.id.tv_jokeContent);
        }
    }

    //下拉刷新:刷新第一页数据，先清空原数据，再重新添加新数据，然后更新UI
    public void setNewData(List<Joke> newData){
        data.clear();;
        data.addAll(newData);
        notifyDataSetChanged();
    }

    //加载更多:加载下一页数据，所以请求时page++，只需要把新数据添加到原数据的后面，然后更新UI
    public void getMoreData(List<Joke> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

}
