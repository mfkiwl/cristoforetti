package com.github.giulioscattolin.logger;

public class GnssLoggerReaderService extends GnssLoggerReaderProxy {
    private static GnssLoggerReader itsReader;

    static {
        reset();
    }

    public static void inject(GnssLoggerReader reader) {
        itsReader = reader;
    }

    static void reset() {
        itsReader = new UndefinedGnssLoggerReader();
    }

    protected GnssLoggerReader getGnssLoggerReader() {
        return itsReader;
    }
}