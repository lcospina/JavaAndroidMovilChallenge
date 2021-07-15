package com.enteprise.movilchallenge.presentation.utils;

public class Utilitys {

    public static String stringCut(String data) {
        if (data != null) {
            if (data.length() < 5) {
                return data;
            } else {
                return data.substring(0, 5);
            }
        }
        return data;
    }
}
