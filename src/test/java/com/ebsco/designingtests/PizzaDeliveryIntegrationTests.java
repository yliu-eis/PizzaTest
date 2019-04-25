package com.ebsco.designingtests;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PizzaDeliveryIntegrationTests {

    @Test
    public void testDelivery_value_multicase() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "MUsHROOM", "-dough", "WHITE", "-size", "9"});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.MUSHROOM)));
        assertEquals(9, ((SizedPizza) pizza).getSize());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
    }

    @Test
    public void testDelivery_key_capital() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-LEFT", "MUSHROOM"});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.MUSHROOM)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(9, ((SizedPizza) pizza).getSize());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
    }

    @Test
    public void testDelivery_value_word_incorrect() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "yifu", "-dough", ".."});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_value_non_alphanumeric() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "..", "-dough", ".."});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_value_empty() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "", "-dough", ".."});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_size_negative() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-size", "-98"});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_multple_toppings() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-entire", "RANCH, PEPPERONI"});
        System.out.println(pizza.toString());
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.RANCH)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.PEPPERONI)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_pizza_toppings_allsides() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "RANCH, PEPPERONI", "-right", "MUSHROOM", "-entire", "BBQ_CHICKEN"});

        System.out.println(pizza.toString());//question about toString();
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.RANCH)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.PEPPERONI)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.RIGHT, ToppingType.MUSHROOM)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.BBQ_CHICKEN)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_pizza_not_valid_key() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-..", "RANCH, PEPPERONI", "-right", "MUSHROOM", "-entire", "BBQ_CHICKEN"});

        System.out.println(pizza.toString());//question about toString();
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.RIGHT, ToppingType.MUSHROOM)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.BBQ_CHICKEN)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_pizza_duplicates_topping_in_side() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "RANCH, RANCH, PEPPERONI", "-right", "MUSHROOM", "-entire", "BBQ_CHICKEN"});

        System.out.println(pizza.toString());//question about toString();
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.RANCH)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.PEPPERONI)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.RIGHT, ToppingType.MUSHROOM)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.BBQ_CHICKEN)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }

    @Test
    public void testDelivery_pizza_duplicates_topping_across_sides() {
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-left", "RANCH, PEPPERONI", "-right", "RANCH, MUSHROOM", "-entire", "RANCH, BBQ_CHICKEN"});

        System.out.println(pizza.toString());//question about toString();
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.LEFT, ToppingType.PEPPERONI)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.RIGHT, ToppingType.MUSHROOM)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.BBQ_CHICKEN)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.RANCH)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }
}
