package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.*;
import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import com.github.giulioscattolin.measurement.RawGnssMeasurementVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static com.github.giulioscattolin.TestHelper.asDataFile;
import static com.google.common.truth.Truth.assertThat;

public class GnssLoggerFileProcessorTest {
    DataProcessor itsProcessor;
    Collection<RawGnssMeasurement> itsGpsRawGnssMeasurements;
    Collection<RawGnssMeasurement> itsGalileoRawGnssMeasurements;

    @Before
    public void clear() {
        itsProcessor = new GnssLoggerFileProcessor(new Collector());
        itsGpsRawGnssMeasurements = new LinkedList<>();
        itsGalileoRawGnssMeasurements = new LinkedList<>();
    }

    @Test
    public void verifyDataCollection() {
        itsProcessor.process(asDataFile("gnss_log_2021_04_25_12_18_31.txt"));

        // Verify GPS and Galileo measurements size
        assertThat(itsGpsRawGnssMeasurements).hasSize(12);
        assertThat(itsGalileoRawGnssMeasurements).hasSize(15);
    }

    private class Collector implements
        DataCollector,
        EagerIterableDataVisitor,
        RawGnssMeasurementVisitor {

        public void accept(Data data) {
            data.accept(this);
        }

        public void visit(RawGnssMeasurement rawGnssMeasurement) {
            if (rawGnssMeasurement.hasConstellationType())
                switch (rawGnssMeasurement.getConstellationType()) {
                    case RawGnssMeasurement.ConstellationType.GPS:
                        itsGpsRawGnssMeasurements.add(rawGnssMeasurement);
                        break;
                    case RawGnssMeasurement.ConstellationType.GALILEO:
                        itsGalileoRawGnssMeasurements.add(rawGnssMeasurement);
                        break;
                }
        }
    }
}