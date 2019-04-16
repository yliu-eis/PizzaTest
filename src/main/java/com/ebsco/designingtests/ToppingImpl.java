package com.ebsco.designingtests;

public class ToppingImpl implements Topping {

    private final Side side;
    private final ToppingType toppingType;

    public ToppingImpl(Side side, ToppingType toppingType) {
        this.side = side;
        this.toppingType = toppingType;
    }

    public Side getSide() {
        return side;
    }

    public ToppingType getType() {
        return toppingType;
    }

    @Override
    public String toString() {
        return toppingType.name();
    }
}
