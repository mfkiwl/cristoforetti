package com.github.giulioscattolin.logger;

public interface GnssLoggerSource {
    void accept(GnssLoggerSourceVisitor visitor);
}
