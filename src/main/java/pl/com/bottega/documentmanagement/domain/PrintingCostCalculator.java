package pl.com.bottega.documentmanagement.domain;

import java.math.BigDecimal;

/**
 * Created by arkadiuszarak on 20/08/2016.
 */
public interface PrintingCostCalculator {
    BigDecimal cost(int pagesCount);
}
