package com.github.giulioscattolin.time;

import java.math.BigDecimal;

public class BigDecimalTemporalOffsetFactory implements TemporalOffsetFactory {
    public TemporalOffset getZeroOffset() {
        return new BigDecimalTemporalOffset(BigDecimal.ZERO);
    }
}
