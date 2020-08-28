package com.springcloud.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TimeUtil {


    public static String longTransferTime(Long timestamp){
        Date date=new Date(timestamp);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Long interval(Long begin,Long end){
        return end>begin?(end-begin)/1000:(begin-end)/1000;
    }



    public static void main(String[] args) {
        System.out.println(longTransferTime(System.currentTimeMillis()));
    }
}
