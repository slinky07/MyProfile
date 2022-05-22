package com.slinky.myprofile;

import android.app.Activity;
import android.content.SharedPreferences;

public class ThemeUtils {

    private static final String FILE_NAME = "myPreference";  //Shared Preference fileName
    private static final String SEASON = "Season";      //Shared Preference key

    private final static int THEME_SPRING = 0;          // index of spinners hardcoded to know which one to get
    private final static int THEME_SUMMER = 1;          // not good practice, should have done a hashmap with keys maybe
    private final static int THEME_AUTUMN = 2;
    private final static int THEME_WINTER = 3;

    /**
     * method to set the theme. should be called before SUPER call of OnCreate.
     * @param activity is context to use.
     * @param preferredTheme is integer saved by SharedPreference which also is index of spinner.
     */
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

    /**
     * static method to be used by any activities to store a shared preference.
     * @param activity  is context to use.
     * @param position  is integer to save in Shared preference.
     */
    public static void putSharedPreference(Activity activity, int position) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(FILE_NAME, activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SEASON, position);
        editor.apply();

    }

    /**
     * method to get actual saved theme. would not need to duplicate these lines if
     * would need to be called between multiple activities.
     * @param activity being context to use.
     * @return  saved theme, if preference is non-existent send back spring value.
     */
    public static int getSavedTheme(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(FILE_NAME, activity.MODE_PRIVATE);
        return sharedPreferences.getInt(SEASON, THEME_SPRING);
    }


}
