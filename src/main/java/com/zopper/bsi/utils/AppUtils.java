package com.zopper.bsi.utils;

import java.util.UUID;

import com.google.gson.Gson;

/**
 * Created by sudhir on 19/5/16.
 */
public class AppUtils {

    public static String toJson(Object object){
        return new Gson().toJson(object);
    }
    
    public static String generateReferenceNumber() {
    	return UUID.randomUUID().toString();
    }

}
