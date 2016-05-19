package com.zopper.bsi.enums;

/**
 * Created by sudhir on 19/5/16.
 */
public enum FormDataType {

    TEXT(0),
    RADIO_BUTTON(1),
    SELECT_BOX(2),
    TEXT_AREA(3)
    ;

    FormDataType(int key){
        this.key = key;
    }

    int key;

    public Integer getKey() {
        return null;
    }
}
