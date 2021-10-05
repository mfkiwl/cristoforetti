package com.github.giulioscattolin.demo;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataCollection;
import com.github.giulioscattolin.data.DataCollectionEmitter;
import com.github.giulioscattolin.data.DataProcessor;
import com.github.giulioscattolin.logger.GnssLoggerFileProcessor;
import com.github.giulioscattolin.measurement.DataCollectionEmitterStrategies.GroupRawMeasurementsByElapsedRealtimeMillisEagerly;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.atomic.LongAdder;

import static com.github.giulioscattolin.TestHelper.asDataFile;
import static com.google.common.truth.Truth.assertThat;

public class CountRawGnssMeasurementEpochsTest {
    DataProcessor itsProcessor;
    Collection<Data> itsEpochs;

    @Before
    public void clear() {
        itsEpochs = new LinkedList<>();
        itsProcessor =
            new GnssLoggerFileProcessor(
                new DataCollectionEmitter(
                    GroupRawMeasurementsByElapsedRealtimeMillisEagerly::new,
                    itsEpochs::add));
    }

    @Test
    public void countEpochs() {
        itsProcessor.process(asDataFile("gnss_log_2021_04_24_16_41_00.txt"));

        // This file contains 69 epochs
        assertThat(itsEpochs).hasSize(69);

        LongAdder measurementsCount = new LongAdder();
        itsEpochs.forEach(data -> measurementsCount.add(((DataCollection) data).size()));
        int averageMeasurementCountPerEpoch = measurementsCount.intValue() / itsEpochs.size();

        // The average number of measurements per epoch is 37
        assertThat(averageMeasurementCountPerEpoch).isEqualTo(37);
    }
}
