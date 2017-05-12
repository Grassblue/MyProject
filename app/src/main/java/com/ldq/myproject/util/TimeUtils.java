package com.ldq.myproject.util;

import java.util.Date;

/**
 * Created by S01 on 2017/5/6.
 */

public class TimeUtils {
    public static String getTime(){
        String time = String.valueOf(new Date().getTime());
        return time.substring(0,time.length()-3);
    }
}
