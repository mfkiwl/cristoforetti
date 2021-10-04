package com.github.giulioscattolin.logger;

interface GnssLoggerRecord {
    void accept(GnssLoggerRecordVisitor visitor);
}
