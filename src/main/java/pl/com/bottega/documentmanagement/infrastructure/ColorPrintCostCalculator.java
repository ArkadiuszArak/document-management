package pl.com.bottega.documentmanagement.infrastructure;

import pl.com.bottega.documentmanagement.domain.PrintingCostCalculator;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 20/08/2016.
 */
public class ColorPrintCostCalculator implements PrintingCostCalculator {
    @Override
    public BigDecimal cost(int pagesCount) {
        return new BigDecimal(pagesCount * 0.1);
    }
}
