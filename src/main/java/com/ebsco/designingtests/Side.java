package com.ebsco.designingtests;

import java.util.ArrayList;
import java.util.List;

public enum Side {
    LEFT,
    RIGHT,
    ENTIRE;

    public static Side getValue(String value) {
        try{
            return Side.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public List<Topping> getTopping(String toppings){
        List<Topping> toppingsList = new ArrayList<>();
        String[] toppArray = toppings.split(",");
        for (String t : toppArray) {
            ToppingType type = ToppingType.getValue(t.trim());
            if (type != null) {
                toppingsList.add(new ToppingImpl(this, type));
            }
        }
        return toppingsList;
    }


}
