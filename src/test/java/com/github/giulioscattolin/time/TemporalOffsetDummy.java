package com.github.giulioscattolin.time;

class TemporalOffsetDummy implements TemporalOffset {
    public double toNanoseconds() {
        return 0;
    }

    public TemporalOffset plus(TemporalOffset temporalOffset) {
        return null;
    }

    public TemporalOffset plusDays(long days) {
        return null;
    }

    public TemporalOffset minusDays(long days) {
        return null;
    }

    public TemporalOffset plusNanoseconds(long nanoseconds) {
        return null;
    }

    public TemporalOffset plusNanoseconds(double nanoseconds) {
        return null;
    }

    public TemporalOffset minusNanoseconds(long nanoseconds) {
        return null;
    }

    public TemporalOffset minusNanoseconds(double nanoseconds) {
        return null;
    }
}
