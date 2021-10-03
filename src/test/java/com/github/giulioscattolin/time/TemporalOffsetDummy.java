package com.github.giulioscattolin.time;

class TemporalOffsetDummy implements TemporalOffset {
    public double toNanoseconds() {
        return 0;
    }

    public TemporalOffset plusDays(long days) {
        return null;
    }

    @Override
    public TemporalOffset minusDays(long days) {
        return null;
    }
}
