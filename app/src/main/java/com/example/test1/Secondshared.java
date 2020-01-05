package com.example.test1;

import android.content.Context;
import android.content.SharedPreferences;

public class Secondshared {
    private static Secondshared secpreference;
    private SharedPreferences sharedPreferences;

    public static Secondshared getInstance(Context context) {
        if (secpreference == null) {
            secpreference = new Secondshared(context);
        }
        return secpreference;
    }

    private Secondshared(Context context) {
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
}
