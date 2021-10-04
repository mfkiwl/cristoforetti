package com.github.giulioscattolin.logger;

class UndefinedGnssLoggerReader implements GnssLoggerReader {
    private static final String MESSAGE = "No GnssLoggerReader implementation has been injected.";

    public GnssLoggerData read(GnssLoggerSource source) {
        throw new IllegalStateException(MESSAGE);
    }
}
