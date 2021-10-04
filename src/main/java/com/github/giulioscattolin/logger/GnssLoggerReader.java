package com.github.giulioscattolin.logger;

public interface GnssLoggerReader {
    GnssLoggerData read(GnssLoggerSource source);
}
