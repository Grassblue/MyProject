package com.ldq.myproject.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ldq.myproject.R;
import com.ldq.myproject.bean.ProvinceBean;
import com.ldq.myproject.bean.UserInfo;
import com.ldq.myproject.common.Constant;
import com.ldq.myproject.common.PreferencesManager;
import com.ldq.myproject.util.CityDataUtil;
import com.ldq.myproject.util.GlideLoader;
import com.ldq.myproject.util.ToastUtils;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import de.hdodenhof.circleimageview.CircleImageView;

public class MoreInfoActivity extends AppCompatActivity {

    @BindView(R.id.img_icon)
    CircleImageView imgIcon;
    @BindView(R.id.tr1_photo)
    TableRow tr1Photo;
    @BindView(R.id.tv_uname)
    TextView tvUname;
    @BindView(R.id.tr2_uname)
    TableRow tr2Uname;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tr3_sex)
    TableRow tr3Sex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tr4_age)
    TableRow tr4Age;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tr5_address)
    TableRow tr5Address;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private ArrayList<String> ageItems = new ArrayList<>();
    private ArrayList<String> sexItems = new ArrayList<>();

    private String photoUrl, uname, sex, age, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tvTitle.setText(R.string.more_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        options1Items = CityDataUtil.getProvinceData();
        options2Items = CityDataUtil.getCityData();
        options3Items = CityDataUtil.getAreData();
    }

    @OnClick({R.id.tr1_photo, R.id.tr2_uname, R.id.tr3_sex, R.id.tr4_age, R.id.tr5_address, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tr1_photo:
                selectUserIc();
                break;
            case R.id.tr2_uname:
                break;
            case R.id.tr3_sex:
                showSexPickView();
                break;
            case R.id.tr4_age:
                showAgePickView();
                break;
            case R.id.tr5_address:
                showCityPickView();
                break;
            case R.id.btn_submit:
                updateUserInfo();
                break;
        }
    }
    private void selectUserIc() {
        ImageConfig imageConfig
                = new ImageConfig.Builder(new GlideLoader())
                .steepToolBarColor(getResources().getColor(R.color.colorPrimary))
                .titleBgColor(getResources().getColor(R.color.colorPrimary))
                .titleSubmitTextColor(getResources().getColor(R.color.white))
                .titleTextColor(getResources().getColor(R.color.white))
                // (截图默认配置：关闭    比例 1：1    输出分辨率  500*500)
                .crop(1, 1, 300, 300)
                // 开启单选   （默认为多选）
                .singleSelect()
                // 开启拍照功能 （默认关闭）
                .showCamera()
                // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                .filePath("/only/Pictures")
                .build();
        ImageSelector.open(MoreInfoActivity.this, imageConfig);   // 开启图片选择器
    }

    private void showSexPickView() {
        sexItems.add(getString(R.string.man));
        sexItems.add(getString(R.string.woman));
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                tvSex.setText(sexItems.get(options1));
            }
        })
                .setTitleText(getString(R.string.select_sex))
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setOutSideCancelable(false)// default is true
                .build();
        pvOptions.setPicker(sexItems);//一级选择器
        pvOptions.show();
    }

    private void showAgePickView() {
        for (int i = 1; i < 100; i++) {
            ageItems.add(String.valueOf(i));
        }
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                tvAge.setText(ageItems.get(options1));
            }
        })
                .setTitleText(getString(R.string.select_age))
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setOutSideCancelable(false)// default is true
                .build();
        pvOptions.setPicker(ageItems);//一级选择器
        pvOptions.show();
    }

    private void showCityPickView() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                tvAddress.setText(tx);
            }
        })
                .setTitleText(getString(R.string.select_city))
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setOutSideCancelable(false)// default is true
                .build();
        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void updateUserInfo() {
        uname = tvUname.getText().toString();
        sex = tvSex.getText().toString();
        age = tvAge.getText().toString();
        address = tvAddress.getText().toString();
        if (!"".equals(photoUrl)
                && !"".equals(sex)
                && !"".equals(age)
                && !"".equals(address)) {
            UserInfo newUser = new UserInfo();
            newUser.setPhoto(photoUrl);
            newUser.setSex(getString(R.string.man).equals(sex) ? true : false);
            newUser.setAge(Integer.valueOf(age));
            newUser.setAddress(address);
            UserInfo bmobUser = BmobUser.getCurrentUser(MoreInfoActivity.this, UserInfo.class);
            newUser.update(MoreInfoActivity.this, bmobUser.getObjectId(), new UpdateListener() {
                @Override
                public void onSuccess() {
                    // TODO Auto-generated method stub
                    ToastUtils.shortToast(MoreInfoActivity.this, getString(R.string.more_info_success));
                    PreferencesManager.getInstance(MoreInfoActivity.this).put(Constant.USER_PHOTO, photoUrl);
                    MoreInfoActivity.this.finish();
                }

                @Override
                public void onFailure(int code, String msg) {
                    // TODO Auto-generated method stub
                    ToastUtils.shortToast(MoreInfoActivity.this, getString(R.string.more_info_failure) + msg);
                }
            });
        }else{
            ToastUtils.shortToast(MoreInfoActivity.this,getString(R.string.please_complete_info));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageSelector.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get Image Path List
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            if (pathList.size() > 0) {
                //由于单选只需要回去第一个数据就好,获取图片URL并上传
                uploadPhotoForURL(pathList.get(0));
            } else {
                ToastUtils.shortToast(MoreInfoActivity.this, getString(R.string.select_photo_failure));
            }
        }
    }

    private void uploadPhotoForURL(String path) {
        final BmobFile bmobFile = new BmobFile(new File(path));
        bmobFile.uploadblock(MoreInfoActivity.this, new UploadFileListener() {

            @Override
            public void onSuccess() {
                photoUrl = bmobFile.getFileUrl(MoreInfoActivity.this);
                Glide.get(imgIcon.getContext()).with(imgIcon.getContext())
                        .load(photoUrl)
                        .asBitmap()//强制转换Bitmap
                        .placeholder(R.mipmap.ic_img_default)
                        .error(R.mipmap.ic_img_fail)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(imgIcon);
                ToastUtils.shortToast(MoreInfoActivity.this, getString(R.string.upload_photo_success) + photoUrl);
            }

            @Override
            public void onProgress(Integer value) {
            }

            @Override
            public void onFailure(int code, String msg) {
                ToastUtils.shortToast(MoreInfoActivity.this, getString(R.string.upload_photo_failure) + msg);
            }
        });
    }
}
