package com.zopper.bsi.enums;

/**
 * Created by sudhir on 19/5/16.
 */
public enum StatusCode {

    DELETED(0),
    ACTIVE(1);

    StatusCode(int key){
        this.key = key;
    }

    int key;

    public Integer getKey() {
        return key;
    }
}
