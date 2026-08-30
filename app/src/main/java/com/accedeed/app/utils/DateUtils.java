package com.accedeed.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";
    private static final String TIME_FORMAT = "HH:mm";

    public static String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public static String formatDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public static String formatTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public static long getTodayStartTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        String dateStr = sdf.format(date);
        try {
            return sdf.parse(dateStr).getTime();
        } catch (Exception e) {
            return System.currentTimeMillis();
        }
    }

    public static String getRelativeTime(long timestamp) {
        long now = System.currentTimeMillis();
        long diffInSeconds = (now - timestamp) / 1000;

        if (diffInSeconds < 60) {
            return "Hace poco";
        } else if (diffInSeconds < 3600) {
            return "Hace " + (diffInSeconds / 60) + " minutos";
        } else if (diffInSeconds < 86400) {
            return "Hace " + (diffInSeconds / 3600) + " horas";
        } else {
            return formatDate(timestamp);
        }
    }
}
