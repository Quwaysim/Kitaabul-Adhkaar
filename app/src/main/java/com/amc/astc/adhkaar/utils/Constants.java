package com.amc.astc.adhkaar.utils;

public final class Constants {
    public static final String KEY_ADHKAR_INTENT = "Adhkar";
    public static final String KEY_SUWAR_INTENT = "Suwar";
    public static final String KEY_FORTY_RABBANA_INTENT = "forty_rabbana";
    public static final String KEY_FORTY_HADITH_INTENT = "40 hadith";

    // Notification Channel constants
    // Name of Notification Channel for verbose notifications of background work
    public static final CharSequence VERBOSE_NOTIFICATION_CHANNEL_NAME =
            "Kitaabul-Adhkaar Notifications";
    public static String VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION =
            "Reminder for morning and evening adhkar";
    public static final CharSequence NOTIFICATION_TITLE = "Kitaabul-Adhkaar";
    public static final String CHANNEL_ID = "VERBOSE_NOTIFICATION" ;
    public static final int NOTIFICATION_ID = 1;

    private Constants() {
    }

}
