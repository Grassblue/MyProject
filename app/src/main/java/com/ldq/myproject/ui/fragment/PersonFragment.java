package com.ldq.myproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.ldq.myproject.R;
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
    @BindView(R.id.tv_myInfo)
    TextView tvMyInfo;
    @BindView(R.id.tr1_myInfo)
    TableRow tr1MyInfo;
    @BindView(R.id.tv_myLove)
    TextView tvMyLove;
    @BindView(R.id.tr2_myLove)
    TableRow tr2MyLove;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tr1_myInfo, R.id.tr2_myLove, R.id.tr3_history, R.id.tr4_setting, R.id.tr5_advice, R.id.tr6_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tr1_myInfo:
                intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tr2_myLove:
                break;
            case R.id.tr3_history:
                break;
            case R.id.tr4_setting:
                break;
            case R.id.tr5_advice:
                break;
            case R.id.tr6_about:
                break;
        }
    }
}
