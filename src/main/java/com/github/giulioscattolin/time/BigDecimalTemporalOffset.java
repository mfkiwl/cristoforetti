package com.github.giulioscattolin.time;

import java.math.BigDecimal;

class BigDecimalTemporalOffset implements TemporalOffset {
    private final BigDecimal itsNanoseconds;

    BigDecimalTemporalOffset(BigDecimal nanoseconds) {
        itsNanoseconds = nanoseconds;
    }

    public double toNanoseconds() {
        return itsNanoseconds.doubleValue();
    }

    public TemporalOffset plusDays(long days) {
        long hours = 24 * days;
        long minutes = 60 * hours;
        long seconds = 60 * minutes;
        long nanoseconds = 1_000_000_000L * seconds;
        return new BigDecimalTemporalOffset(itsNanoseconds.add(new BigDecimal(nanoseconds)));
    }
}
