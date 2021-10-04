package com.github.giulioscattolin.logger;

abstract class GnssLoggerReaderProxy implements GnssLoggerReader {
    public GnssLoggerData read(GnssLoggerSource source) {
        return getGnssLoggerReader().read(source);
    }

    protected abstract GnssLoggerReader getGnssLoggerReader();
}
