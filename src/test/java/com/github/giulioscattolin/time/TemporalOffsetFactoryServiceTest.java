package com.github.giulioscattolin.time;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

public class TemporalOffsetFactoryServiceTest {
    TemporalOffsetFactoryStub itsFactoryStub;
    TemporalOffset itsExpectedZeroOffset;

    @Before
    public void reset() {
        TemporalOffsetFactoryService.reset();
        makeFactoryStub();
    }

    private void makeFactoryStub() {
        itsFactoryStub = new TemporalOffsetFactoryStub();
        itsExpectedZeroOffset = new TemporalOffset() {};
        itsFactoryStub.itsZeroOffset = itsExpectedZeroOffset;
    }

    @Test(expected = IllegalStateException.class)
    public void verifyUndefinedFactoryBehavior() {
        TemporalOffsetFactoryService.getZeroOffset();
    }

    @Test
    public void verifyServiceUsesInjectedFactory() {
        TemporalOffsetFactoryService.inject(itsFactoryStub);

        assertThat(TemporalOffsetFactoryService.getZeroOffset()).isEqualTo(itsExpectedZeroOffset);
    }
}