package com.ebsco.designingtests;

import java.util.List;

public class PizzaImpl implements SizedPizza {

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

    @Override
    public List<Topping> getToppings() {//followed Topping in interface Pizza
        return toppings;
    }

    @Override
    public Dough getDough() {
        return dough;
    }

    @Override
    public Sauce getSauce() {
        return sauce;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getPrice() {
        switch (size) {
            case 9:
                return 10;
            case 12:
                return 15;
            case 15:
                return 20;
            default:
                return (size/3)*5;
        }
    }

    @Override
    public String toString() {
        return "Dough: " + dough.name() + " Sauce: " + sauce.name() + " Size: " + size
                + " Price: $" + getPrice() + " Toppings: " + toppings;
    }
}
