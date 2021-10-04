package com.github.giulioscattolin.time;

public class TemporalOffsetFactoryService extends TemporalOffsetFactoryProxy {
    private static TemporalOffsetFactory itsFactory;

    static {
        reset();
    }

    public static void inject(TemporalOffsetFactory factory) {
        itsFactory = factory;
    }

    protected TemporalOffsetFactory getTemporalOffsetFactory() {
        return itsFactory;
    }

    static void reset() {
        itsFactory = new UndefinedTemporalOffsetFactory();
    }
}
