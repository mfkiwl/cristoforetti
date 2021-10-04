package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;

import java.util.function.Consumer;

import static com.github.giulioscattolin.logger.RawGnssMeasurementTranslator.translate;

class RawGnssMeasurementCollector extends GnssLoggerRecordVisitor {
    private final Consumer<Data> itsDataCollector;

    RawGnssMeasurementCollector(Consumer<Data> dataCollector) {
        itsDataCollector = dataCollector;
    }

    void visit(RawGnssMeasurementRecord rawGnssMeasurementRecord) {
        itsDataCollector.accept(translate(rawGnssMeasurementRecord));
    }
}
