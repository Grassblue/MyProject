package com.ldq.myproject.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.Collection;
import com.ldq.myproject.bean.PictureResult;
import com.ldq.myproject.bean.PictureResult.ShowapiResBodyBean.PagebeanBean.PictureInfo;
import com.ldq.myproject.bean.UserInfo;
import com.ldq.myproject.common.BaseApplication;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.ServerConfig;
import com.ldq.myproject.ui.adapter.PictureAdapter;
import com.ldq.myproject.util.LoginUtils;
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

public class PictureFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;
    private View rootView;

    private int page = 1;
    private List<PictureInfo> data = new ArrayList<>();
    private PictureAdapter pictureAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_recyclerview, null);
        unbinder = ButterKnife.bind(this, rootView);

        toolbar.setVisibility(View.GONE);
        initView();
        return rootView;
    }

    private void initView() {
        //初始化适配器
        pictureAdapter = new PictureAdapter(data, getContext());
        //绑定适配器
        recyclerView.setAdapter(pictureAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                page = 1;
                getAsyncData(page);
            }
        });

        pictureAdapter.setOnItemLongClickListener(new PictureAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(final int position) {
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
                                    collection.setPicUrl(data.get(position-1).getList().get(0).getBig());
                                    collection.setTitle(data.get(position-1).getTitle());
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
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        getAsyncData(1);
    }


    private void getAsyncData(final int page) {
        OkHttpUtils
                .get()
                .url(ServerConfig.SHOEAPI_PICTURE_URL)
                .addParams("type", "4002")
                .addParams("page", String.valueOf(page))
                .addParams("showapi_appid", Constant.YIYUAN_APPID)
                .addParams("showapi_sign", Constant.YIYUAN_SECRET)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.shortToast(getActivity(), getString(R.string.request_failure));
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //解析数据
                        PictureResult pictureResult = JSON.parseObject(response, PictureResult.class);
                        data.addAll(pictureResult.getShowapi_res_body().getPagebean().getContentlist());
                        pictureAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
