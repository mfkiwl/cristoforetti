package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RawGnssMeasurementParserTest {
    RawGnssMeasurement itsRawGnssMeasurement;

    @Test
    public void t() {
        String line = "Raw,189362621,147710246000000,18,,-1292032448199080441,-0.6313767433166504,131.93707854952663,5.41916040414302,13.162864206221524,55,2,0.0,16399,327358369549839,6,43.4,-53.141605377197266,0.0333000011742115,16,-0.0,1902.9177342976868,1.57542003E9,,,,0,,1,0.56,1.57542003E9";

        parse(line);

        assertThat(itsRawGnssMeasurement.getElapsedRealtimeMillis()).isEqualTo(189362621);
        assertThat(itsRawGnssMeasurement.getTimeNanos()).isEqualTo(147710246000000L);
        assertThat(itsRawGnssMeasurement.getFullBiasNanos()).isEqualTo(-1292032448199080441L);
        assertThat(itsRawGnssMeasurement.getBiasNanos()).isEqualTo(-0.6313767433166504);
        assertThat(itsRawGnssMeasurement.getDriftNanosPerSecond()).isEqualTo(5.41916040414302);
        assertThat(itsRawGnssMeasurement.getHardwareClockDiscontinuityCount()).isEqualTo(55);
        assertThat(itsRawGnssMeasurement.getSvid()).isEqualTo(2);
        assertThat(itsRawGnssMeasurement.getState()).isEqualTo(16399);
        assertThat(itsRawGnssMeasurement.getReceivedSvTimeNanos()).isEqualTo(327358369549839L);
        assertThat(itsRawGnssMeasurement.getCarrierFrequencyHz()).isEqualTo(1.57542003E9);
        assertThat(itsRawGnssMeasurement.getConstellationType()).isEqualTo(1);
    }

    private void parse(String line) {
        itsRawGnssMeasurement =
            RawGnssMeasurementParser.parse(
                RawGnssMeasurementRecordParser.parse(line));
    }
}
