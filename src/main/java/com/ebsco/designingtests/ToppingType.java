package com.ebsco.designingtests;

public enum ToppingType {

    PEPPERONI,
    MOZZAERELLA,
    PROVOLONE,
    RANCH,
    MUSHROOM,
    BBQ_SAUCE,
    BBQ_CHICKEN,
    TOMATO,
    SAUSAGE,
    JELLO,
    CLAMS;

    public static ToppingType getValue(String value) {
        try {
            return ToppingType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

}
