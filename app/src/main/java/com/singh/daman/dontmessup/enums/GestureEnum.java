package com.singh.daman.dontmessup.enums;

/**
 * Created by Daman on 9/9/2017.
 */

public enum GestureEnum {
    SWIPE("Swipe"),
    TAP("Tap"),
    DOUBLETAP("Double Tap");

    private String value;
    GestureEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
