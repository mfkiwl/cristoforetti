package com.github.giulioscattolin.time;

public interface TemporalOffset {
    double toNanoseconds();

    TemporalOffset plusDays(long days);

    TemporalOffset minusDays(long days);

    TemporalOffset plusNanoseconds(long nanoseconds);
}
