package com.ldq.myproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.ldq.myproject.R;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.PreferencesManager;
import com.ldq.myproject.ui.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by S01 on 2017/5/6.
 */

public class PersonFragment extends Fragment {
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.tv_uname)
    TextView tvUname;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_myInfo)
    TextView tvMyInfo;
    @BindView(R.id.tr1_myInfo)
    TableRow tr1MyInfo;
    @BindView(R.id.tv_myCollect)
    TextView tvMyCollect;
    @BindView(R.id.tr2_myCollect)
    TableRow tr2MyCollect;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tr3_history)
    TableRow tr3History;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.tr4_setting)
    TableRow tr4Setting;
    @BindView(R.id.tv_advice)
    TextView tvAdvice;
    @BindView(R.id.tr5_advice)
    TableRow tr5Advice;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.tr6_about)
    TableRow tr6About;
    Unbinder unbinder;
    private View rootView;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_person, null);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initData() {
       if(PreferencesManager.getInstance(getActivity()).get(Constant.IS_LOGIN,false)){
           tvUname.setVisibility(View.VISIBLE);
           tvLogin.setVisibility(View.GONE);
           loadUserInfo();
       }else{
           tvUname.setVisibility(View.GONE);
           tvLogin.setVisibility(View.VISIBLE);
       }
    }

    private void loadUserInfo() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_icon, R.id.tv_login,R.id.tr1_myInfo, R.id.tr2_myCollect, R.id.tr3_history, R.id.tr4_setting, R.id.tr5_advice, R.id.tr6_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_icon:
                break;
            case R.id.tv_login:
                break;
            case R.id.tr1_myInfo:
                intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tr2_myCollect:
                break;
            case R.id.tr3_history:
                break;
            case R.id.tr4_setting:
                break;
            case R.id.tr5_advice:
                break;
            case R.id.tr6_about:
                showAppInfo();
                break;
        }
    }

    private void showAppInfo() {
        AlertDialog.Builder builer = new AlertDialog.Builder(getActivity())
                .setTitle("关于我们")
                .setMessage("开发人:Grassblue\n地址:https://github.com/Grassblue/MyProject")
                .setPositiveButton("确定", null);
        builer.create().show();
    }

}
