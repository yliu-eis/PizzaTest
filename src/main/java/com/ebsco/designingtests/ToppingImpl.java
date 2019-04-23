package com.ebsco.designingtests;

import java.util.Objects;

public class ToppingImpl implements Topping {//implements call Topping
    //what is the purpose of implements Topping here?

    private final Side side;
    private final ToppingType toppingType;

    public ToppingImpl(Side side, ToppingType toppingType) {
        this.side = side;
        this.toppingType = toppingType;
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
        return toppingType.name() + ":" + side;
    }//.name() works for enum

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToppingImpl topping = (ToppingImpl) o;
        return side == topping.side &&
                toppingType == topping.toppingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side, toppingType);
    }
}
