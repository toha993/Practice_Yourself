package com.example.test1;

import android.content.Context;
import android.content.SharedPreferences;

public class YourPreference {
    private static YourPreference yourPreference;
    private SharedPreferences sharedPreferences;

    public static YourPreference getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new YourPreference(context);
        }
        return yourPreference;
    }

    private YourPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("YourCustomNamedPreference",Context.MODE_PRIVATE);
    }

    public void updt(String key,int value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putInt(key, value);
        prefsEditor.apply();
    }

    public int unlock(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getInt(key, 0);
        }
        return -1;
    }
//   public int unlock(String x)
//    {
//        SharedPreferences sharedPreferences = context.getSharedPreferences("Unlock Details",Context.MODE_PRIVATE);
//        return sharedPreferences.getInt("x",0);
//    }
//    public void updt(String x,int y)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("Unlock Details",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putInt(x,y);
//        editor.apply();
//    }
}
