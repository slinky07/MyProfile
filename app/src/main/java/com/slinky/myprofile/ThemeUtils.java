package com.slinky.myprofile;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class ThemeUtils {

    private static final String PREF = "myPreference";
    private static final String SEASON = "Season";

    private final static int THEME_SPRING = 0;
    private final static int THEME_SUMMER = 1;
    private final static int THEME_AUTUMN = 2;
    private final static int THEME_WINTER = 3;


    public static String getSEASON() {
        return SEASON;
    }

    public static String getPREF() {
        return PREF;
    }

    public static int getRightThemeVal(int pos) {
        switch (pos) {
            case 1:
                return THEME_SUMMER;
            case 2:
                return THEME_AUTUMN;
            case 3:
                return THEME_WINTER;
            default:
                return THEME_SPRING; // 0 (spring) or >3
        }
    }

    public static void onCreateSetTheme(Activity activity, int preferredTheme) {
        switch (preferredTheme) {
            default:
            case THEME_SPRING:
                activity.setTheme(R.style.Theme_MyProfile_spring);
                break;
            case THEME_SUMMER:
                activity.setTheme(R.style.Theme_MyProfile_summer);
                break;
            case THEME_AUTUMN:
                activity.setTheme(R.style.Theme_MyProfile_autumn);
                break;
            case THEME_WINTER:
                activity.setTheme(R.style.Theme_MyProfile_winter);
                break;
        }
    }



}
