package com.ldq.myproject.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by LDQ on 2017/5/15.
 */

public class UserInfo extends BmobUser {
    private Boolean sex;
    private String photo;
    private Integer age;
    private String address;

    public UserInfo() {
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
