package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataFile;
import com.github.giulioscattolin.data.IterableData;
import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import com.github.giulioscattolin.measurement.RawGnssMeasurementVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static com.google.common.truth.Truth.assertThat;

public class GnssLoggerFileReaderTest {
    GnssLoggerFileReader itsReader;
    IterableData itsDataIterable;
    Collection<Data> itsDataCollection;
    Collection<RawGnssMeasurement> itsGpsRawGnssMeasurements;
    Collection<RawGnssMeasurement> itsGalileoRawGnssMeasurements;

    @Before
    public void clear() {
        itsReader = new GnssLoggerFileReader();
        itsDataCollection = new LinkedList<>();
        itsGpsRawGnssMeasurements = new LinkedList<>();
        itsGalileoRawGnssMeasurements = new LinkedList<>();
    }

    @Test
    public void verifyDataCollection() {
        itsDataIterable = (IterableData) itsReader.read(getDataFile("gnss_log_2021_04_25_12_18_31.txt"));
        itsDataIterable.forEach(itsDataCollection::add);

        // Verify data collection size
        assertThat(itsDataCollection).hasSize(51);

        // Collect GPS and Galileo measurements
        class Visitor implements RawGnssMeasurementVisitor {
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
        Visitor visitor = new Visitor();
        itsDataCollection.forEach((data) -> data.accept(visitor));

        // Verify GPS and Galileo measurements size
        assertThat(itsGpsRawGnssMeasurements).hasSize(12);
        assertThat(itsGalileoRawGnssMeasurements).hasSize(15);
    }

    private DataFile getDataFile(String name) {
        return new DataFile(getClass().getClassLoader().getResource(name).getFile());
    }
}