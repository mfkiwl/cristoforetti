package com.github.giulioscattolin.demo;

import com.github.giulioscattolin.data.*;
import com.github.giulioscattolin.logger.GnssLoggerFileProcessor;
import com.github.giulioscattolin.measurement.GroupRawGnssMeasurementsByConstellationTypeEagerly;
import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import com.github.giulioscattolin.measurement.RawGnssMeasurement.ConstellationType;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.github.giulioscattolin.TestHelper.asDataFile;
import static com.google.common.truth.Truth.assertThat;

public class GroupGnssRawMeasurementsByConstellationType {
    DataProcessor itsProcessor;
    GroupRawGnssMeasurementsByConstellationTypeEagerly itsCollector;

    @Before
    public void clear() {
        itsCollector = new GroupRawGnssMeasurementsByConstellationTypeEagerly(new HashMap<>());
        itsProcessor = new GnssLoggerFileProcessor(itsCollector);
    }

    @Test
    public void verifyDataCollection() {
        itsProcessor.process(asDataFile("gnss_log_2021_04_25_12_18_31.txt"));

        Map<Integer, Collection<RawGnssMeasurement>> measurementsByConstellationType = itsCollector.getMeasurementsByConstellationType();

        assertThat(measurementsByConstellationType.get(ConstellationType.GALILEO)).hasSize(15);
        assertThat(measurementsByConstellationType.get(ConstellationType.GPS)).hasSize(12);
        assertThat(measurementsByConstellationType.get(ConstellationType.BEIDOU)).hasSize(12);
        assertThat(measurementsByConstellationType.get(ConstellationType.GLONASS)).hasSize(8);
        assertThat(measurementsByConstellationType.get(ConstellationType.IRNSS)).hasSize(4);
        assertThat(measurementsByConstellationType.containsKey(ConstellationType.QZSS)).isFalse();
        assertThat(measurementsByConstellationType.containsKey(ConstellationType.SBAS)).isFalse();
        assertThat(measurementsByConstellationType.containsKey(ConstellationType.UNKNOWN)).isFalse();
    }
}