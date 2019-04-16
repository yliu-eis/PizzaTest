package com.ebsco.designingtests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderPizzaApplication {

    public static void main(String[] args) {
        Iterator<String> it = Arrays.stream(args).iterator();
        Map<String, String> flags = new HashMap<>();
        while (it.hasNext()) {
            String flag = it.next();
            if(flag.startsWith("-")) {
                flags.put(flag.substring(1), it.next());
            }
        }

        List<Topping> toppings = new ArrayList<>();
        Dough dough = Dough.WHITE;
        Sauce sauce = Sauce.NONE;
        Integer size = null;

        for(Map.Entry<String, String> e : flags.entrySet()) {
            switch (e.getKey()) {
                case "t":
                    toppings.add(new ToppingImpl(Side.ENTIRE, ToppingType.valueOf(e.getValue())));
                    break;
                case "d":
                    dough = Dough.valueOf(e.getValue());
                    break;
                case "s":
                    sauce = Sauce.valueOf(e.getValue());
                    break;
                case "size":
                    size = Integer.valueOf(e.getValue());
                    break;

            }
        }

        Pizza pizza = new PizzaImpl(toppings, dough, sauce, size);
        System.out.println(pizza.toString());

    }
}
