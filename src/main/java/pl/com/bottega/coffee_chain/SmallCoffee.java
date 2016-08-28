package pl.com.bottega.coffee_chain;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class SmallCoffee extends Ingridient {
    public SmallCoffee(Ingridient next) {
        super(next);
    }

    @Override
    protected BigDecimal ingridientCost() {
        return new BigDecimal(2.5);
    }

    @Override
    protected String ingridientName() {
        return "Small caffee";
    }
}
