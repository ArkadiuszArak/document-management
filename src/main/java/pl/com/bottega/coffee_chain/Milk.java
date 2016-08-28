package pl.com.bottega.coffee_chain;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class Milk extends Ingridient {
    public Milk(Ingridient next) {
        super(next);
    }

    public Milk() {

    }

    @Override
    protected BigDecimal ingridientCost() {
        return new BigDecimal(0.5);
    }

    @Override
    protected String ingridientName() {
        return "Milk";
    }
}
