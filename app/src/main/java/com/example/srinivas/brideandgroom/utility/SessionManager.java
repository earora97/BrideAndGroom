package com.example.srinivas.brideandgroom.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 9/2/17.
 */

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "app";

    public static final String CUR_LAN = "cur_lan";
    public static final String KEY_FIRST = "key_first";
    public static final String KEY_HOUR = "key_hour";
    public static final String KEY_MINUTE = "key_minute";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setCurrentLaunge(String lan) {
        editor.putString(CUR_LAN, lan);
        editor.commit();
    }

    public String getCurrentLaunge() {
        return pref.getString(CUR_LAN, "");
    }

    public void setFirstTime(int val) {
        editor.putInt(KEY_FIRST, val);
        editor.commit();
    }

    public int getFirstTime() {
        return pref.getInt(KEY_FIRST, 1);
    }

    public void setHourTime(int val) {
        editor.putInt(KEY_HOUR, val);
        editor.commit();
    }

    public int getHourTime() {
        return pref.getInt(KEY_HOUR, 8);
    }

    public void setMinuteTime(int val) {
        editor.putInt(KEY_MINUTE, val);
        editor.commit();
    }

    public int getMinuteTime() {
        return pref.getInt(KEY_MINUTE, 0);
    }

}
