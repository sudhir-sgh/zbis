package com.zopper.bsi.utils;

import com.google.gson.Gson;

/**
 * Created by sudhir on 19/5/16.
 */
public class AppUtils {

    public static String toJson(Object object){
        return new Gson().toJson(object);
    }

}
