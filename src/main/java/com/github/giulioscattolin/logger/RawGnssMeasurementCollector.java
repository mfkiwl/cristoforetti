package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;

import java.util.function.Consumer;

class RawGnssMeasurementCollector extends GnssLoggerRecordVisitor {
    private final Consumer<Data> itsDataCollector;

    RawGnssMeasurementCollector(Consumer<Data> dataCollector) {
        itsDataCollector = dataCollector;
    }

    void visit(RawGnssMeasurementRecord rawGnssMeasurementRecord) {
        itsDataCollector.accept(RawGnssMeasurementParser.parse(rawGnssMeasurementRecord));
    }
}
