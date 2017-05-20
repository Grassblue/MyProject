package com.ldq.myproject.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ldq.myproject.R;
import com.ldq.myproject.bean.Collection;
import com.ldq.myproject.bean.UserInfo;
import com.ldq.myproject.common.BaseApplication;
import com.ldq.myproject.ui.adapter.CollectionAdapter;
import com.ldq.myproject.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

public class CollectionActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //声明并初始化数据
    private List<Collection> data = new ArrayList<>();
    //声明适配器
    private CollectionAdapter collectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tvTitle.setText(R.string.my_collection);
        initView();
    }

    private void initView() {
        //初始化适配器
        collectionAdapter = new CollectionAdapter(this,data);
        //绑定适配器
        recyclerView.setAdapter(collectionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                asyncTask();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        asyncTask();
    }

    private void asyncTask() {
        BmobQuery<Collection> query = new BmobQuery<Collection>();
        UserInfo userInfo = BmobUser.getCurrentUser(BaseApplication.getInstance(), UserInfo.class);
        query.addWhereEqualTo("uId", userInfo.getObjectId());
        query.setLimit(30);
        query.findObjects(this, new FindListener<Collection>() {
            @Override
            public void onSuccess(List<Collection> list) {
                if (swipeRefreshLayout != null) {
                    if (swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
                collectionAdapter.setNewData(list);
                LogUtils.d(getString(R.string.collection_data) + list.size());
            }

            @Override
            public void onError(int i, String s) {
            }
        });
    }

}
