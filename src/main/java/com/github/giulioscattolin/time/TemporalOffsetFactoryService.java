package com.github.giulioscattolin.time;

public class TemporalOffsetFactoryService {
    private static TemporalOffsetFactory itsFactory = new UndefinedTemporalOffsetFactory();

    public static TemporalOffset getZeroOffset() {
        return itsFactory.getZeroOffset();
    }
}
