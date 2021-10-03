package com.github.giulioscattolin.time;

public interface TemporalOffset {
    double toNanoseconds();

    TemporalOffset plus(TemporalOffset other);

    TemporalOffset minus(TemporalOffset other);

    TemporalOffset plusDays(long days);

    TemporalOffset minusDays(long days);

    TemporalOffset plusNanoseconds(long nanoseconds);

    TemporalOffset plusNanoseconds(double nanoseconds);

    TemporalOffset minusNanoseconds(long nanoseconds);

    TemporalOffset minusNanoseconds(double nanoseconds);
}
