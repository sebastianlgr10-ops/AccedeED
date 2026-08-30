package com.accedeed.app.utils;

import android.util.Log;

public class AppLogger {
    private static final String APP_TAG = "AccedeED";

    public static void d(String tag, String message) {
        Log.d(APP_TAG + ":" + tag, message);
    }

    public static void e(String tag, String message) {
        Log.e(APP_TAG + ":" + tag, message);
    }

    public static void e(String tag, String message, Throwable throwable) {
        Log.e(APP_TAG + ":" + tag, message, throwable);
    }

    public static void i(String tag, String message) {
        Log.i(APP_TAG + ":" + tag, message);
    }

    public static void w(String tag, String message) {
        Log.w(APP_TAG + ":" + tag, message);
    }
}
