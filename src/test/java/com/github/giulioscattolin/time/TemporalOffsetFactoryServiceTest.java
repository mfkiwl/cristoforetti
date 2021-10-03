package com.github.giulioscattolin.time;

import org.junit.Test;

public class TemporalOffsetFactoryServiceTest {
    @Test(expected = IllegalStateException.class)
    public void verifyUndefinedFactoryBehavior() {
        TemporalOffsetFactoryService.getZeroOffset();
    }
}