package com.github.giulioscattolin.time;

public class BigDecimalTemporalOffsetTest extends TemporalOffsetTest {
    protected TemporalOffsetFactory getFactory() {
        return new BigDecimalTemporalOffsetFactory();
    }
}
