package com.ldq.myproject.ui.activity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.ldq.myproject.R;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.PreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.btn_loginout)
    Button btnLoginout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_loginout)
    public void onClick() {
        //清除缓存用户对象
        BmobUser.logOut(SettingsActivity.this);
        PreferencesManager.getInstance(SettingsActivity.this).put(Constant.IS_LOGIN, false);
        SettingsActivity.this.finish();
    }
}
