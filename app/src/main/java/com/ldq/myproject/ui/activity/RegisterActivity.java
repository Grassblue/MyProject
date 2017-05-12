package com.ldq.myproject.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ldq.myproject.R;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.textInputLayout3)
    TextInputLayout textInputLayout3;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.textInputLayout5)
    TextInputLayout textInputLayout5;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        Bmob.initialize(this, Constant.BMOB_ID);
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        final String name = registerName.getText().toString();
        final String pwd = registerPwd.getText().toString();
        BmobUser user = new BmobUser();
        user.setUsername(name);
        user.setPassword(pwd);
        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                if (name.equals("") || pwd.equals("")) {
                    ToastUtils.shortToast(RegisterActivity.this, "账户和密码不能为空");
                } else if (name.length() < 7 || pwd.length() < 7) {
                    ToastUtils.shortToast(RegisterActivity.this, "账户和密码不能小于6位数");
                } else {
                    ToastUtils.shortToast(RegisterActivity.this, "注册成功");
                }
            }

            @Override
            public void onFailure(int i, String s) {
                ToastUtils.shortToast(RegisterActivity.this, "注册失败");
            }
        });
    }
}
