package pl.com.bottega.coffee_chain;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class LargeCoffee extends Ingridient {
    public LargeCoffee(Ingridient next) {
        super(next);
    }

    public LargeCoffee() {

    }

    @Override
    protected BigDecimal ingridientCost() {
        return new BigDecimal(4.5);
    }

    @Override
    protected String ingridientName() {
        return "Large Coffee";
    }
}
