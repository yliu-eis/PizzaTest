package com.ebsco.designingtests;

import java.util.List;


public interface Pizza extends Harold {

    List<Topping> getToppings();

    Dough getDough();

    Sauce getSauce();

    int getPrice();

}
