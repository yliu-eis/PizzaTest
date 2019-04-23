package com.ebsco.designingtests;

public enum Dough {

    WHITE,
    GLUTEN_FREE,
    WHOLE_WHEAT;

    public static Dough getValue(String value) {
        try{
            return Dough.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

}
