package com.github.giulioscattolin.time;

public interface TemporalOffset {
    double toSeconds();

    double toNanoseconds();

    TemporalOffset plus(TemporalOffset other);

    TemporalOffset minus(TemporalOffset other);

    TemporalOffset plusDays(long days);

    TemporalOffset minusDays(long days);

    TemporalOffset plusHours(long hours);

    TemporalOffset plusMinutes(long minutes);

    TemporalOffset plusSeconds(long seconds);

    TemporalOffset plusNanoseconds(long nanoseconds);

    TemporalOffset plusNanoseconds(double nanoseconds);

    TemporalOffset minusNanoseconds(long nanoseconds);

    TemporalOffset minusNanoseconds(double nanoseconds);

    TemporalOffset remSeconds(long seconds);
}
