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

    @Test
    public void verifyPlusNanoseconds() {
        assertThat(getFactory().getZeroOffset().plusNanoseconds(1).toNanoseconds()).isEqualTo(1);
        assertThat(getFactory().getZeroOffset().plusNanoseconds(1E-9).toNanoseconds()).isEqualTo(1E-9);
    }

    @Test
    public void verifyMinusNanoseconds() {
        assertThat(getFactory().getZeroOffset().minusNanoseconds(1).toNanoseconds()).isEqualTo(-1);
        assertThat(getFactory().getZeroOffset().minusNanoseconds(1E-9).toNanoseconds()).isEqualTo(-1E-9);
    }
}
