package com.github.giulioscattolin.time;

import java.math.BigDecimal;

class BigDecimalTemporalOffset implements TemporalOffset {
    public static final long NANOSECONDS_IN_SECOND = 1_000_000_000L;
    public static final int SECONDS_IN_MINUTES = 60;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int HOURS_IN_DAY = 24;
    private final BigDecimal itsNanoseconds;

    BigDecimalTemporalOffset(BigDecimal nanoseconds) {
        itsNanoseconds = nanoseconds;
    }

    public double toSeconds() {
        return toNanoseconds() / NANOSECONDS_IN_SECOND;
    }

    public double toNanoseconds() {
        return itsNanoseconds.doubleValue();
    }

    public TemporalOffset plus(TemporalOffset temporalOffset) {
        BigDecimalTemporalOffset other = (BigDecimalTemporalOffset) temporalOffset;
        return new BigDecimalTemporalOffset(itsNanoseconds.add(other.itsNanoseconds));
    }

    public TemporalOffset minus(TemporalOffset otherOffset) {
        BigDecimalTemporalOffset other = (BigDecimalTemporalOffset) otherOffset;
        return new BigDecimalTemporalOffset(itsNanoseconds.subtract(other.itsNanoseconds));
    }

    public TemporalOffset plusDays(long days) {
        return plusHours(HOURS_IN_DAY * days);
    }

    public TemporalOffset minusDays(long days) {
        return plusDays(-days);
    }

    public TemporalOffset plusHours(long hours) {
        return plusMinutes(MINUTES_IN_HOUR * hours);
    }

    public TemporalOffset plusMinutes(long minutes) {
        return plusSeconds(SECONDS_IN_MINUTES * minutes);
    }

    public TemporalOffset plusSeconds(long seconds) {
        return plusNanoseconds(NANOSECONDS_IN_SECOND * seconds);
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

    public TemporalOffset remSeconds(long seconds) {
        return remNanoseconds(NANOSECONDS_IN_SECOND * seconds);
    }

    public TemporalOffset remNanoseconds(long nanoseconds) {
        return new BigDecimalTemporalOffset(itsNanoseconds.remainder(new BigDecimal(nanoseconds)));
    }
}
