package com.github.giulioscattolin.time;

class TemporalOffsetDummy implements TemporalOffset {
    public double toSeconds() {
        return 0;
    }

    public double toNanoseconds() {
        return 0;
    }

    public TemporalOffset plus(TemporalOffset temporalOffset) {
        return null;
    }

    public TemporalOffset minus(TemporalOffset other) {
        return null;
    }

    public TemporalOffset plusDays(long days) {
        return null;
    }

    public TemporalOffset minusDays(long days) {
        return null;
    }

    public TemporalOffset plusHours(long hours) {
        return null;
    }

    public TemporalOffset plusMinutes(long minutes) {
        return null;
    }

    public TemporalOffset plusSeconds(long seconds) {
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

    public TemporalOffset remSeconds(long seconds) {
        return null;
    }
}
