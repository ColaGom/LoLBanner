package com.cbstudio.lolbanner.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Colabear on 2016-04-07.
 */
public class UserPref {

    private  static  SharedPreferences.Editor mEditor = null;
    private static SharedPreferences mPref = null;
    private static final String KEY_PREF = "cola.pref.lolobserver";

    public static void init(Context context)
    {
        mPref = context.getSharedPreferences(KEY_PREF, 0);
        mEditor = mPref.edit();
    }

    private static final String KEY_USER_NAME = "key.user.name";
    public static void putUserName(String userName)
    {
        mEditor.putString(KEY_USER_NAME, userName);
        mEditor.commit();
    }

    public static String getUserName()
    {
        return mPref.getString(KEY_USER_NAME, "");
    }

    private static  final String KEY_USER_ID = "key.user.id";
    public static void putUserId(String userId)
    {
        mEditor.putString(KEY_USER_ID, userId);
        mEditor.commit();
    }

    public static String getUesrId()
    {
        return mPref.getString(KEY_USER_ID, "");
    }

    private  static  final String KEY_LATEST_VERSION = "key.latest.version";
    public static  void putLatestVersion(String version)
    {
        mEditor.putString(KEY_LATEST_VERSION, version);
        mEditor.commit();
    }

    public static  String getLatestVersion(){
        return mPref.getString(KEY_LATEST_VERSION, "");
    }
}
