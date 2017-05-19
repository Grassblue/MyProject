package com.ldq.myproject.common;

/**
 * Created by S01 on 2017/5/6.
 */

public class Constant {
    public static final String BMOB_ID = "69c85efd88511bd8b360cf532a1f0c0a";
    public static final String PAGE_SIZE = "10";
    public static final String JUHE_NEWS_KEY = "a61641496aa7ac16a735356c5de1126b";
    public static final String JUHE_JOKE_KEY = "d30494525de530164ec12eb76dfe9bbd";
    public static final String YIYUAN_APPID = "37551";
    public static final String YIYUAN_SECRET = "632a19c85d2a4dc3b2f427d6b400eede";

    /** 是否第一次运行 **/
    public static final String IS_FIRST_RUN = "isFirstRun";
    /** 是否登录 */
    public static final String IS_LOGIN = "isLogin";
    /** 用户头像地址 **/
    public static final String USER_PHOTO = "user_photo";
    /** 用户头昵称 **/
    public static final String USER_NAME = "user_name";
    /** 用户头密码 **/
    public static final String USER_PWD = "user_pwd";
    /** 用户登录方式 **/
    public static final String LOGINTYPE = "login_type";

    public static final int LOGIN_TYPE_NORMAL = 0X001;
    public static final int LOGIN_TYPE_THIRD = 0X002;

    public static final int COLLECTION_TYPE_NEWS = 0X001;
    public static final int COLLECTION_TYPE_JOKE = 0X002;
    public static final int COLLECTION_TYPE_PIC = 0X003;
}
