package com.ebsco.designingtests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToppingTest {

    @Test
    public void testTopping(){
        for(Side side : Side.values()) {
            int j=1;
            for(ToppingType type : ToppingType.values()) {
                Topping topping = new ToppingImpl(side, type);
                //why use "Topping" from Interface here?
                System.out.println(topping);
                System.out.println(j+1);
                assertEquals(side, topping.getSide());//cause we need Topping here
                assertEquals(type, topping.getType());
            }
        }
    }

}
