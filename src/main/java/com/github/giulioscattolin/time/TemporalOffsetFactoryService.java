package com.github.giulioscattolin.time;

public class TemporalOffsetFactoryService {
    private static TemporalOffsetFactory itsFactory;

    TemporalOffsetFactoryService() {
        reset();
    }

    public static void inject(TemporalOffsetFactory factory) {
        itsFactory = factory;
    }

    public static TemporalOffset getZeroOffset() {
        return itsFactory.getZeroOffset();
    }

    static void reset() {
        itsFactory = new UndefinedTemporalOffsetFactory();
    }
}
