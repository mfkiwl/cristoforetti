package com.github.giulioscattolin.time;

class UndefinedTemporalOffsetFactory implements TemporalOffsetFactory {
    private static final String MESSAGE = "No service provider for TemporalOffsetFactory has been defined.";

    public TemporalOffset getZeroOffset() {
        throw new IllegalStateException(MESSAGE);
    }
}
