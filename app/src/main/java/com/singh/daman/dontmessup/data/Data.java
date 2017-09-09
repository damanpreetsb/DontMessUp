package com.singh.daman.dontmessup.data;

import android.support.v4.util.ArrayMap;

import com.singh.daman.dontmessup.enums.GestureEnum;

import java.util.Random;

/**
 * Created by Daman on 9/9/2017.
 */

public final class Data {

    public Data() {
    }

    public static ArrayMap<String, String> createArrayMap() {
        ArrayMap<String,String> arrayMap;
        arrayMap = new ArrayMap<>();
        arrayMap.put("Please swipe", GestureEnum.SWIPE.toString());
        arrayMap.put("Please tap", GestureEnum.TAP.toString());
        arrayMap.put("Tap tap", GestureEnum.DOUBLETAP.toString());
        arrayMap.put("Swipe", GestureEnum.SWIPE.toString());
        return arrayMap;
    }

    public static String[] getData(ArrayMap<String,String> arrayMap){
        Random r = new Random();
        int i = r.nextInt(4);
        String[] s = new String[2];
        s[0] = arrayMap.keyAt(i);
        s[1] = arrayMap.get(s[0]);
        return s;
    }
}
