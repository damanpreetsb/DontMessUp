package com.singh.daman.dontmessup.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Daman on 9/9/2017.
 */

public final class Utility {
    public ArrayMap<String,String> arrayMap;

    public Utility() {
    }

    public static void setFullScreen(@NonNull final Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void createArrayMap() {

    }

}
