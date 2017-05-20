package com.ldq.myproject.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.Collection;
import com.ldq.myproject.bean.JokeResult;
import com.ldq.myproject.bean.JokeResult.ResultBean.Joke;
import com.ldq.myproject.bean.UserInfo;
import com.ldq.myproject.common.BaseApplication;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.ServerConfig;
import com.ldq.myproject.ui.adapter.JokeAdapter;
import com.ldq.myproject.util.LoginUtils;
import com.ldq.myproject.util.TimeUtils;
import com.ldq.myproject.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import okhttp3.Call;

/**
 * Created by S01 on 2017/5/6.
 */

public class JokeFragment extends Fragment {
    public static final int TYPE_REFRESH = 0X01;
    public static final int TYPE_LOADMORE = 0X02;

    Unbinder unbinder;
    @BindView(R.id.pullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;
    private View rootView;

    private int page = 1;
    private List<Joke> data = new ArrayList<>();
    private JokeAdapter jokeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_listview, null);
        unbinder = ButterKnife.bind(this, rootView);

        initView();
        return rootView;
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
        //请求数据
        OkHttpUtils
                .get()
                .url(ServerConfig.JUHE_JOKE_URL)
                .addParams("sort", "desc")
                .addParams("page", String.valueOf(page))
                .addParams("pagesize", Constant.PAGE_SIZE)
                .addParams("time", TimeUtils.getTime())
                .addParams("key", Constant.JUHE_JOKE_KEY)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.shortToast(getActivity(), getString(R.string.request_failure));
                        pullToRefreshListView.onRefreshComplete();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //停止刷新
                        pullToRefreshListView.onRefreshComplete();
                        //解析数据
                        JokeResult jokeResult = JSON.parseObject(response, JokeResult.class);
                        switch (type) {
                            case TYPE_REFRESH:
                                jokeAdapter.setNewData(jokeResult.getResult().getData());
                                break;
                            case TYPE_LOADMORE:
                                jokeAdapter.getMoreData(jokeResult.getResult().getData());
                                break;
                        }
                    }
                });
    }

    private void initView() {
        //设置列表的刷新加载
        pullToRefreshListView.setMode(PullToRefreshListView.Mode.BOTH);
        //初始化适配器
        jokeAdapter = new JokeAdapter(data);
        //绑定适配器
        pullToRefreshListView.setAdapter(jokeAdapter);
        //添加监听事件
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                ToastUtils.shortToast(getActivity(), data.get(i - 1).getContent());
            }
        });

        pullToRefreshListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.collection)
                        .setMessage(R.string.is_collection)
                        .setPositiveButton(R.string.collection, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LoginUtils.checkLogin(true);
                                UserInfo userInfo = BmobUser.getCurrentUser(BaseApplication.getInstance(), UserInfo.class);
                                if (userInfo != null) {
                                    Collection collection = new Collection();
                                    collection.setuId(userInfo.getObjectId());
                                    collection.setType(Constant.COLLECTION_TYPE_JOKE);
                                    collection.setTitle(data.get(position-1).getContent());
                                    collection.save(getActivity(), new SaveListener() {
                                        @Override
                                        public void onSuccess() {
                                            ToastUtils.shortToast(getActivity(), getString(R.string.collection_success));
                                        }

                                        @Override
                                        public void onFailure(int i, String s) {
                                            ToastUtils.shortToast(getActivity(), getString(R.string.collection_failure));
                                        }
                                    });
                                }
                            }
                        })
                        .setNegativeButton(R.string.cancel, null)
                        .create()
                        .show();
                return true;
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
