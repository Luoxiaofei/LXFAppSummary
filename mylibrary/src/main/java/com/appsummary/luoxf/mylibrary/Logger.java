package com.appsummary.luoxf.mylibrary;

import android.text.TextUtils;
import android.util.Log;

/**
 * 日志打印工具类，封装到一起，是为了调用时方便
 *
 * @author Administrator
 */
public final class Logger {
    private static final String TAG = "TOOGOO";

    private Logger() {
        //Utility classes should not have a public or default constructor.
    }

    public static void v(String message) {
        Log.v(TAG, message);
    }

    public static void v(String tag, String message) {
        Log.v(tag, message);
    }

    public static void d(String message) {
        Log.d(TAG, message);
    }

    public static void i(String message) {
        Log.i(TAG, message);
    }

    public static void i(String tag, String message) {
        Log.i(tag, message);
    }

    public static void w(String message) {
        Log.w(TAG, message);
    }

    public static void w(String tag, String message) {
        Log.w(tag, message);
    }

    public static void e(String message) {
        Log.e(TAG, message);
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
    }

    public static void d(String tag, String msg, Throwable tr) {
        Log.d(tag, msg, tr);
    }

    public static void e(Throwable tr) {
        Log.e(TAG, "", tr);
    }

    public static void d(String tag, String message) {
        Log.d(TextUtils.isEmpty(tag) ? TAG : tag, message);
    }
}
