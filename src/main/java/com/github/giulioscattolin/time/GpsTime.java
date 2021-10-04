package com.github.giulioscattolin.time;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class GpsTime {
    private static final int SECONDS_IN_WEEK = 604800;
    private static final LocalDate EPOCH = LocalDate.of(1980, 1, 6);
    private static final TemporalOffsetFactory TEMPORAL_OFFSET_FACTORY = new TemporalOffsetFactoryService();

    public static TemporalOffset asTemporalOffset(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        return
            asTemporalOffset(year, month, dayOfMonth)
                .plusHours(hour)
                .plusMinutes(minute)
                .plusSeconds(second);
    }

    public static TemporalOffset asTemporalOffset(int year, int month, int dayOfMonth) {
        return
            TEMPORAL_OFFSET_FACTORY
                .getZeroOffset()
                .plusDays(getDaysSinceEpoch(year, month, dayOfMonth));
    }

    static long getDaysSinceEpoch(int year, int month, int dayOfMonth) {
        return EPOCH.until(LocalDate.of(year, month, dayOfMonth), DAYS);
    }

    public static double getSecondsInWeek(TemporalOffset temporalOffset) {
        return sinceStartOfWeek(temporalOffset).toSeconds();
    }

    public static TemporalOffset sinceStartOfWeek(TemporalOffset temporalOffset) {
        return temporalOffset.remSeconds(SECONDS_IN_WEEK);
    }
}
