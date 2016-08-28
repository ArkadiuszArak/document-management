package pl.com.bottega.coffee_chain;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public abstract class Ingridient {

    private Ingridient next;

    public Ingridient(){}

    public Ingridient(Ingridient next) {
        this.next = next;
    }

    public BigDecimal cost(){
        if (next != null)
            return next.cost().add(ingridientCost());
        else
            return ingridientCost();
    }

    public String name(){
        if (next != null)
            return ingridientName() + " with " + next.name();
        else
            return ingridientName();
    }

    protected abstract BigDecimal ingridientCost();
    protected abstract String ingridientName();

}
