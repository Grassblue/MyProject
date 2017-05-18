package com.ldq.myproject.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.io.File;

/**
 * Created by LDQ on 2017/5/16.
 * [PreferencesManager管理类，提供get和put方法来重写SharedPreferences所提供的方法，并支持java对象，更为实用和便捷]
 */

public class PreferencesManager{
    private Context mContext;
    private SharedPreferences preferences;
    private static String shareName = "MyProjectData";
    private static PreferencesManager instance;

    private PreferencesManager(Context context) {
        this(context, shareName);
    }

    private PreferencesManager(Context context, String shareName) {
        mContext = context;
        preferences = context.getSharedPreferences(shareName,
                Context.MODE_PRIVATE);
    }

    /**
     * 得到单例模式的PreferencesManager对象
     *
     * @param context
     *            上下文
     * @return
     */
    public static PreferencesManager getInstance(Context context) {
        return getInstance(context, shareName);
    }

    /**
     * 得到单例模式的PreferencesManager对象
     *
     * @param context
     *            上下文
     * @param shareName
     *            文件名称
     * @return
     */
    public static PreferencesManager getInstance(Context context,
                                                 String shareName) {
        if (instance == null) {
            synchronized (PreferencesManager.class) {
                if (instance == null) {
                    instance = new PreferencesManager(context, shareName);
                }
            }
        }
        return instance;
    }

    public void put(String key, boolean value) {
        SharedPreferences.Editor edit = preferences.edit();
        if (edit != null) {
            edit.putBoolean(key, value);
            edit.commit();
        }
    }

    public void put(String key, String value) {
        SharedPreferences.Editor edit = preferences.edit();
        if (edit != null) {
            edit.putString(key, value);
            edit.commit();
        }
    }

    public void put(String key, int value) {
        SharedPreferences.Editor edit = preferences.edit();
        if (edit != null) {
            edit.putInt(key, value);
            edit.commit();
        }
    }

    public void put(String key, float value) {
        SharedPreferences.Editor edit = preferences.edit();
        if (edit != null) {
            edit.putFloat(key, value);
            edit.commit();
        }
    }

    public void put(String key, long value) {
        SharedPreferences.Editor edit = preferences.edit();
        if (edit != null) {
            edit.putLong(key, value);
            edit.commit();
        }
    }


    public String get(String key) {
        return preferences.getString(key, "");
    }

    public String get(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public boolean get(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public int get(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public float get(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    public long get(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }


    /**
     * 直接存放对象，将对象转JSON，key为对象的classname
     * @param t
     */
    public <T> void put(T t) {
        try {
            SharedPreferences.Editor edit = preferences.edit();
            String json = JSON.toJSONString(t);
            edit.putString(t.getClass().getSimpleName(), json);
            edit.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取整个对象，跟put(T t)对应使用
     *
     * @param cls
     * @return
     */
    public <T> Object get(Class<T> cls) {
        Object obj = null;
        try {
            String json = preferences.getString(cls.getSimpleName(), "");
            if(!TextUtils.isEmpty(json)){
                obj = JSON.parseObject(json, cls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void clearAll() {
        try {
            String fileName = shareName+".xml";
            StringBuilder path = new StringBuilder("/data/data/").append(mContext.getPackageName()).append("/shared_prefs");
            File file = new File(path.toString(), fileName);
            if (file.exists()) {
                file.deleteOnExit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
