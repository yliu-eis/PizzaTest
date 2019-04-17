package com.ebsco.designingtests;

import java.util.List;


public interface Pizza {

    List<Topping> getToppings();

    Dough getDough();

    Sauce getSauce();

    int getPrice();

}
