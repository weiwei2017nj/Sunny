package com.hon.sunny.common.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Frank on 2017/8/9.
 * E-mail:frank_hon@foxmail.com
 */

public class Time {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowYMDHMSTime() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return mDateFormat.format(new Date());
    }

    /**
     * MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowMDHMSTime() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "MM-dd HH:mm:ss");
        return mDateFormat.format(new Date());
    }

    /**
     * MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowYMD() {

        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        return mDateFormat.format(new Date());
    }

    /**
     * yyyy-MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getYMD(Date date) {

        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        return mDateFormat.format(date);
    }

    @SuppressLint("SimpleDateFormat")
    public static String getMD(Date date) {

        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "MM-dd");
        return mDateFormat.format(date);
    }

    @SuppressLint("SimpleDateFormat")
    public static String getNowMDhm() {

        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "MM-dd HH:mm");
        return mDateFormat.format(new Date());
    }
}

