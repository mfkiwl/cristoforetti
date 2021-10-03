package com.github.giulioscattolin.time;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.giulioscattolin.time.GpsTime.*;
import static com.google.common.truth.Truth.assertThat;

public class GpsTimeTest {
    @BeforeClass
    public static void inject() {
        TemporalOffsetFactoryService.inject(new BigDecimalTemporalOffsetFactory());
    }

    @AfterClass
    public static void reset() {
        TemporalOffsetFactoryService.reset();
    }

    @Test
    public void verifyGetDaysSinceEpoch() {
        assertThat(getDaysSinceEpoch(1980, 1, 6)).isEqualTo(0);
        assertThat(getDaysSinceEpoch(1980, 1, 7)).isEqualTo(1);
        assertThat(getDaysSinceEpoch(1981, 1, 6)).isEqualTo(366);
    }

    @Test
    public void verifySecondsInWeek() {
        assertThat(getSecondsInWeek(asTemporalOffset(1980, 1, 6))).isWithin(1E-9).of(0);
        assertThat(getSecondsInWeek(asTemporalOffset(2000, 1, 1))).isWithin(1E-9).of(518400.0);
        assertThat(getSecondsInWeek(asTemporalOffset(2000, 1, 1, 1, 0, 0))).isWithin(1E-9).of(522000.0);
        assertThat(getSecondsInWeek(asTemporalOffset(2000, 1, 1, 1, 1, 0))).isWithin(1E-9).of(522060.0);
        assertThat(getSecondsInWeek(asTemporalOffset(2000, 1, 1, 1, 1, 1))).isWithin(1E-9).of(522061.0);
        assertThat(getSecondsInWeek(asTemporalOffset(2020, 1, 1))).isWithin(1E-9).of(259200.0);
    }
}