package com.ebsco.designingtests;

import java.util.List;

public class PizzaImpl implements Pizza {
    private final List<Topping> toppings;
    private final Dough dough;
    private final Sauce sauce;
    private final int size;

    public PizzaImpl(List<Topping> toppings, Dough dough, Sauce sauce, int size) {
        this.toppings = toppings;
        this.dough = dough;
        this.sauce = sauce;
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Dough getDough() {
        return dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        switch (size) {
            case 9:
                return 10;
            case 12:
                return 15;
            case 15:
                return 20;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Dough: " + dough.name() + " Sauce: " + sauce.name() + " Size: " + size
            + " Price: $" + getPrice() + " Toppings: " + toppings;
    }
}
