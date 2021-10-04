package com.github.giulioscattolin.time;

public abstract class TemporalOffsetFactoryProxy implements TemporalOffsetFactory {
    public TemporalOffset getZeroOffset() {
        return getTemporalOffsetFactory().getZeroOffset();
    }

    protected abstract TemporalOffsetFactory getTemporalOffsetFactory();
}
