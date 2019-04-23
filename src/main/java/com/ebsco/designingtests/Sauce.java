package com.ebsco.designingtests;

public enum Sauce {
    MARINARA,
    RANCH,
    NONE;


    public static Sauce getValue(String value) {
        try{
            return Sauce.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
