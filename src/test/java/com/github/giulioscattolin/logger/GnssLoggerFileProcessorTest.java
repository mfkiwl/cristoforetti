package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.*;
import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import com.github.giulioscattolin.measurement.RawGnssMeasurementVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static com.google.common.truth.Truth.assertThat;

public class GnssLoggerFileProcessorTest implements IterableDataVisitor, DataCollector, RawGnssMeasurementVisitor {
    DataProcessor itsProcessor;
    Collection<Data> itsDataCollection;
    Collection<RawGnssMeasurement> itsGpsRawGnssMeasurements;
    Collection<RawGnssMeasurement> itsGalileoRawGnssMeasurements;

    @Before
    public void clear() {
        itsDataCollection = new LinkedList<>();
        itsProcessor = new GnssLoggerFileProcessor(this);
        itsGpsRawGnssMeasurements = new LinkedList<>();
        itsGalileoRawGnssMeasurements = new LinkedList<>();
    }

    @Test
    public void verifyDataCollection() {
        itsProcessor.process(getDataFile("gnss_log_2021_04_25_12_18_31.txt"));

        // Verify data collection size
        assertThat(itsDataCollection).hasSize(51);

        // Collect GPS and Galileo measurements
        itsDataCollection.forEach((data) -> data.accept(this));

        // Verify GPS and Galileo measurements size
        assertThat(itsGpsRawGnssMeasurements).hasSize(12);
        assertThat(itsGalileoRawGnssMeasurements).hasSize(15);
    }

    private DataFile getDataFile(String name) {
        return new DataFile(getClass().getClassLoader().getResource(name).getFile());
    }

    public void visit(IterableData iterableData) {
        iterableData.forEach(itsDataCollection::add);
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

    public void accept(Data data) {
        data.accept(this);
    }
}