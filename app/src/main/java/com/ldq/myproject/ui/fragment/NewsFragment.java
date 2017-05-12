package com.ldq.myproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.NewsResult;
import com.ldq.myproject.bean.NewsResult.ResultBean.News;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.ServerConfig;
import com.ldq.myproject.ui.activity.NewsDetailActivity;
import com.ldq.myproject.ui.adapter.NewsAdapter;
import com.ldq.myproject.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * Created by S01 on 2017/5/6.
 */

public class NewsFragment extends Fragment {
    public static final int TYPE_REFRESH = 0X01;
    public static final int TYPE_LOADMORE = 0X02;

    @BindView(R.id.pullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;
    Unbinder unbinder;
    private View rootView;

    private int page = 1;
    private List<News> data = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_listview, null);
        unbinder = ButterKnife.bind(this, rootView);

        initView();
        return rootView;
    }

    private void initView() {
        //设置列表的刷新加载
        pullToRefreshListView.setMode(PullToRefreshListView.Mode.BOTH);
        //初始化适配器
        newsAdapter = new NewsAdapter(data);
        //绑定适配器
        pullToRefreshListView.setAdapter(newsAdapter);
        //添加监听事件
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("news", data.get(position-1));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新，刷新第一页数据
                page = 1;
                getAsyncData(page, TYPE_REFRESH);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //加载更多
                getAsyncData(page++, TYPE_LOADMORE);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        getAsyncData(1, TYPE_REFRESH);
    }

    private void getAsyncData(final int page, final int type) {
        OkHttpUtils
                .get()
                .url(ServerConfig.JUHE_NEWS_URL)
                .addParams("type", "top")
                .addParams("key", Constant.JUHE_NEWS_KEY)
                .addParams("page", String.valueOf(page))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.shortToast(getActivity(), "请求失败");
                        pullToRefreshListView.onRefreshComplete();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //停止刷新
                        pullToRefreshListView.onRefreshComplete();
                        //解析数据
                        NewsResult newsResult = JSON.parseObject(response,NewsResult.class);
                        switch (type) {
                            case TYPE_REFRESH:
                                newsAdapter.setNewData(newsResult.getResult().getData());
                                break;
                            case TYPE_LOADMORE:
                                newsAdapter.getMoreData(newsResult.getResult().getData());
                                break;
                        }
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
