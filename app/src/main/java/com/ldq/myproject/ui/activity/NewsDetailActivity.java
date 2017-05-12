package com.ldq.myproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ldq.myproject.R;
import com.ldq.myproject.bean.NewsResult.ResultBean.News;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {
    @BindView(R.id.wv_detail)
    WebView wvDetail;
    private Intent intent;
    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        intent = getIntent();
        news = intent.getExtras().getParcelable("news");
        wvDetail.loadUrl(news.getUrl());
        WebSettings settings = wvDetail.getSettings();
        settings.setJavaScriptEnabled(true);
        wvDetail.setWebChromeClient(new WebChromeClient());
        wvDetail.setWebViewClient(new WebViewClient());
    }
}
