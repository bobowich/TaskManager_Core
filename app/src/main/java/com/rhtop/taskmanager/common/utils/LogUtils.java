package com.rhtop.taskmanager.common.utils;

import android.util.Log;

/**
 * Created by bobowich
 * Time: 2016/12/23.
 */

public class LogUtils {
    public static boolean isDebug = true;
    public static final String TAG = "TaskManager";
    private LogUtils() {
        throw new UnsupportedOperationException("cannot initialize this");
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }
}
