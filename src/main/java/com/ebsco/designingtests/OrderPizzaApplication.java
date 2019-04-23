package com.ebsco.designingtests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderPizzaApplication {

    public static void main(String[] args) {
        Pizza pizza = deliverPizza(args);
        System.out.println(pizza);
    }
    public static Pizza deliverPizza(String[] args) {
        final Iterator<String> it = Arrays.stream(args).iterator();
        final Map<String, String> flags = new HashMap<>();

        while (it.hasNext()) {
            final String flag = it.next();
            if (flag.startsWith("-")) {
                String value = it.next();
                flags.put(flag.substring(1), value);
            }
        }

        List<Topping> toppings = new ArrayList<>();
        Dough dough = Dough.WHITE;
        Sauce sauce = Sauce.MARINARA;
        Integer size = 9;
        Side side=Side.ENTIRE;

        for (Map.Entry<String, String> e : flags.entrySet()) {

            String value = e.getValue();

            switch (e.getKey().toLowerCase()) {
                case "left":
                    toppings.addAll(Side.LEFT.getTopping(value));
                    break;
                case "entire":
                    toppings.addAll(Side.ENTIRE.getTopping(value));
                    break;
                case "right":
                    toppings.addAll(Side.RIGHT.getTopping(value));
                    break;
                case "dough":
                    Dough newDough = Dough.getValue(value);

                    if (newDough != null) {
                        dough = newDough;
                    }
                    break;
                case "sauce":
                    Sauce newSauce = Sauce.getValue(value);

                    if (newSauce != null) {
                        sauce = newSauce;
                    }
                    break;
                case "size":
                    try {
                        Integer sizecheck = Integer.valueOf(value);
                        if (sizecheck > 0) {
                            size = sizecheck;
                        }
                    } catch (NumberFormatException ex) {
                        // We don't need any code here.
                    }
                    break;

            }

        }

        return new PizzaImpl(toppings, dough, sauce, size);
    }
}
