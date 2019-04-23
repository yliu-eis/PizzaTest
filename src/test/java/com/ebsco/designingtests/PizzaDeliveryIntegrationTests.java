package com.ebsco.designingtests;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PizzaDeliveryIntegrationTests {

    @Test
    public void testDelivery1(){
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-toppings","MUsHROOM", "-dough","WHITE", "-size", "9"});

        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.MUSHROOM)));
        assertEquals(9, ((SizedPizza) pizza).getSize());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
    }

    @Test
    public void testDelivery2(){
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-Toppings","MUSHROOM"});

        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.MUSHROOM)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(9, ((SizedPizza) pizza).getSize());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
    }
    @Test
    public void testDelivery3(){
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-toppings","..", "-dough",".."});
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }
    @Test
    public void testDelivery4(){
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-size", "-98"});
        assertTrue(pizza.getToppings().isEmpty());
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }
    @Test
    public void testDelivery5(){
        Pizza pizza = OrderPizzaApplication.deliverPizza(new String[]{"-toppings","RANCH, PEPPERONI"});

        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.RANCH)));
        assertTrue(pizza.getToppings().contains(new ToppingImpl(Side.ENTIRE, ToppingType.PEPPERONI)));
        assertEquals(Dough.WHITE, pizza.getDough());
        assertEquals(Sauce.MARINARA, pizza.getSauce());
        assertEquals(9, ((SizedPizza) pizza).getSize());
    }
}
