package com.ebsco.designingtests;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CheeseImpl implements Topping {//implements call Topping
    //what is the purpose of implements Topping here?

    private final Side side;
    private final ToppingType toppingType;
    private static final List<ToppingType> allowedCheeses =
            Arrays.asList(ToppingType.MOZZAERELLA, ToppingType.PROVOLONE);

    public CheeseImpl(Side side, ToppingType toppingType) {
        this.side = side;

        if(!allowedCheeses.contains(toppingType)) {
            this.toppingType = ToppingType.MOZZAERELLA;
        } else {
            this.toppingType = toppingType;
        }
    }
    @Override
    public Side getSide() {
        return side;
    }//the purpose of implementing Topping

    @Override
    public ToppingType getType() {
        return toppingType;
    }

    @Override
    public String toString() {
        return toppingType.name();
    }//.name() works for enum

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheeseImpl topping = (CheeseImpl) o;
        return side == topping.side &&
                toppingType == topping.toppingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side, toppingType);
    }
}
