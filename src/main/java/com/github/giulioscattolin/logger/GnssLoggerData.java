package com.github.giulioscattolin.logger;

public interface GnssLoggerData {
    void accept(GnssLoggerDataVisitor visitor);
}
