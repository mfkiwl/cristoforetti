package com.github.giulioscattolin.logger;

import java.util.function.Consumer;

class RawGnssMeasurementRecordCollector {
    private final Consumer<GnssLoggerRecord> itsRecordCollector;

    RawGnssMeasurementRecordCollector(Consumer<GnssLoggerRecord> recordCollector) {
        itsRecordCollector = recordCollector;
    }

    void accept(String line) {
        if (line.startsWith("Raw"))
            itsRecordCollector.accept(RawGnssMeasurementRecordParser.parse(line));
    }
}