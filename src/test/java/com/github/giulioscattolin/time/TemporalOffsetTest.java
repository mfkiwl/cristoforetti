package com.github.giulioscattolin.time;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public abstract class TemporalOffsetTest {
    protected abstract TemporalOffsetFactory getFactory();

    @Test
    public void verifyZeroOffsetIsZeroNanoseconds() {
        assertThat(getFactory().getZeroOffset().toNanoseconds()).isEqualTo(0);
    }

    @Test
    public void verifyPlusDays() {
        assertThat(getFactory().getZeroOffset().plusDays(1).toNanoseconds()).isEqualTo(86_400_000_000_000.0);
    }

    @Test
    public void verifyMinusDays() {
        assertThat(getFactory().getZeroOffset().minusDays(1).toNanoseconds()).isEqualTo(-86_400_000_000_000.0);
    }
}
