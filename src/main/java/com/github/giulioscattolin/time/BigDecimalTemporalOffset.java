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

    public TemporalOffset plus(TemporalOffset temporalOffset) {
        BigDecimalTemporalOffset other = (BigDecimalTemporalOffset) temporalOffset;
        return new BigDecimalTemporalOffset(itsNanoseconds.add(other.itsNanoseconds));
    }

    public TemporalOffset plusDays(long days) {
        long hours = 24 * days;
        long minutes = 60 * hours;
        long seconds = 60 * minutes;
        long nanoseconds = 1_000_000_000L * seconds;
        return plusNanoseconds(nanoseconds);
    }

    public TemporalOffset minusDays(long days) {
        return plusDays(-days);
    }

    public TemporalOffset plusNanoseconds(long nanoseconds) {
        return new BigDecimalTemporalOffset(itsNanoseconds.add(new BigDecimal(nanoseconds)));
    }

    public TemporalOffset plusNanoseconds(double nanoseconds) {
        return new BigDecimalTemporalOffset(itsNanoseconds.add(new BigDecimal(nanoseconds)));
    }

    public TemporalOffset minusNanoseconds(long nanoseconds) {
        return plusNanoseconds(-nanoseconds);
    }

    public TemporalOffset minusNanoseconds(double nanoseconds) {
        return plusNanoseconds(-nanoseconds);
    }
}
