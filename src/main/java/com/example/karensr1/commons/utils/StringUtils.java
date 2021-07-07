package com.example.karensr1.commons.utils;

public class StringUtils {
    private StringUtils() {}


    public static boolean isBlank(String unsafeValue) {
        if(unsafeValue == null) {
            return true;
        }
        return unsafeValue.isBlank();
    }


    public static boolean isNotBlank(String unsafeValue) {
        return !isBlank(unsafeValue);
    }
}
