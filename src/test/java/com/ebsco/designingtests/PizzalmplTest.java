package com.ebsco.designingtests;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class PizzalmplTest {
    @Test
    public void pizza_test_get_toppings() {
        List<Topping> toppingList = Arrays.asList(
                new ToppingImpl(Side.LEFT, ToppingType.BBQ_CHICKEN),
                new ToppingImpl(Side.RIGHT, ToppingType.CLAMS));

        Pizza pizza = new PizzaImpl(toppingList, Dough.WHITE, Sauce.MARINARA, 9);
        assertEquals(toppingList, pizza.getToppings());
    }

    @Test
    public void pizza_test_get_toppings_2() {
        List<Topping> toppingList = Arrays.asList(
                new ToppingImpl(Side.LEFT, ToppingType.BBQ_CHICKEN),
                new ToppingImpl(Side.RIGHT, ToppingType.CLAMS));

        Pizza pizza = new PizzaImpl(toppingList, Dough.WHITE, Sauce.MARINARA, 9);

        List<Topping> expected = Arrays.asList(
                new ToppingImpl(Side.LEFT, ToppingType.BBQ_CHICKEN),
                new ToppingImpl(Side.RIGHT, ToppingType.CLAMS));

        List<String> exp = Arrays.asList("BBQ_CHICKEN", "CLAMS");
        List<String> act = Arrays.asList("BBQ_CHICKEN", "CLAMS");

        assertEquals(exp, act);
        assertNotSame(exp, act);


        assertEquals(expected, pizza.getToppings());

    }

    //    @Test
//    public void pizza_test_get_toppings() {
//        List<Topping> toppingList = Arrays.asList(
//                new ToppingImpl(Side.LEFT, ToppingType.BBQ_CHICKEN),
//                new ToppingImpl(Side.RIGHT, ToppingType.CLAMS));
//
//        Pizza pizza = new PizzaImpl(toppingList, Dough.WHITE, Sauce.MARINARA, 9);
//        assertEquals(toppingList, pizza.getToppings());
//    }
//
    @Test
    public void pizza_test_get_dough() {
        for (Dough dough : Dough.values()) {
            Pizza pizza = new PizzaImpl(Collections.emptyList(), dough, Sauce.MARINARA, 9);
            assertEquals(dough, pizza.getDough());
        }
    }

    @Test
    public void pizza_test_get_sauce() {
        for (Sauce sauce : Sauce.values()) {
            Pizza pizza = new PizzaImpl(Collections.emptyList(), Dough.WHITE, sauce, 9);
            assertEquals(sauce, pizza.getSauce());
        }
    }

    @Test
    public void pizza_test_get_size() {
        int size = 9;
        SizedPizza pizza = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, size);
        assertEquals(size, pizza.getSize());

    }

    @Test
    public void pizza_test_get_price() {
        Map<Integer, Integer> pricelist = new HashMap<>();
        pricelist.put(9, 10);
        pricelist.put(12, 15);
        pricelist.put(15, 20);

        for (Map.Entry<Integer, Integer> sizeint : pricelist.entrySet()) {
            Pizza pizza = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, sizeint.getKey());
            assertEquals(sizeint.getValue().intValue(), pizza.getPrice());
        }
    }

    @Test
    public void pizza_test_get_price2() {
        Pizza pizza9 = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, 9);
        assertEquals(10, pizza9.getPrice());

        Pizza pizza12 = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, 12);
        assertEquals(15, pizza12.getPrice());

        Pizza pizza15 = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, 15);
        assertEquals(20, pizza15.getPrice());
    }

    @Test
    public void pizza_test_get_price3() {
        for (int s = 9, p = 10; s < 15; s += 3, p += 5) {
            Pizza pizza = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, s);
            assertEquals(p, pizza.getPrice());
        }
    }

    @Test
    public void bad_pizza_test_get_price() {
        Map<Integer, Integer> pricelist = new HashMap<>();
        pricelist.put(9, 10);
        pricelist.put(12, 15);
        pricelist.put(15, 20);

        for (int s = 1; s < 100; s += 1) {
            Pizza pizza = new PizzaImpl(Collections.emptyList(), Dough.WHITE, Sauce.MARINARA, s);
            if(pricelist.containsKey(s)) {
                assertEquals((int)pricelist.get(s), pizza.getPrice());
            } else {
                assertEquals((s / 3) * 5, pizza.getPrice());
            }
        }
    }
}
