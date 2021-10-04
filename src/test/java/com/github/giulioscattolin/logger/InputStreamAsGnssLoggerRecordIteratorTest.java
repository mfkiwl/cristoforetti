package com.github.giulioscattolin.logger;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import static com.google.common.truth.Truth.assertThat;

public class InputStreamAsGnssLoggerRecordIteratorTest {
    RawGnssMeasurementRecord itsRawGnssMeasurementRecord;

    @Test
    public void verifyBehavior() {
        String text = ""
            + "Raw,189362621,147710246000000,18,,-1292032448199080441,-0.6313767433166504,131.93707854952663,5.41916040414302,13.162864206221524,55,2,0.0,16399,327358369549839,6,43.4,-53.141605377197266,0.0333000011742115,16,-0.0,1902.9177342976868,1.57542003E9,,,,0,,1,0.56,1.57542003E9\n"
            + "Unknown,1234,Hello,World\n"
            + "Raw,189362622,147710246000000,18,,-1292032448199080441,-0.6313767433166504,131.93707854952663,5.41916040414302,13.162864206221524,55,6,0.0,16399,327358365906996,11,37.2,318.9681396484375,0.030700000002980232,16,-0.0,1902.9177342976868,1.57542003E9,,,,0,,1,0.56,1.57542003E9";
        InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Iterator<GnssLoggerRecord> iterator = new InputStreamAsGnssLoggerRecordIterator(inputStream);

        assertThat(iterator.hasNext()).isTrue();
        itsRawGnssMeasurementRecord = (RawGnssMeasurementRecord) iterator.next();
        assertThat(itsRawGnssMeasurementRecord.getElapsedRealtimeMillis()).isEqualTo("189362621");
        assertThat(itsRawGnssMeasurementRecord.getTimeNanos()).isEqualTo("147710246000000");
        assertThat(itsRawGnssMeasurementRecord.getLeapSecond()).isEqualTo("18");
        assertThat(itsRawGnssMeasurementRecord.getTimeUncertaintyNanos()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getFullBiasNanos()).isEqualTo("-1292032448199080441");
        assertThat(itsRawGnssMeasurementRecord.getBiasNanos()).isEqualTo("-0.6313767433166504");
        assertThat(itsRawGnssMeasurementRecord.getBiasUncertaintyNanos()).isEqualTo("131.93707854952663");
        assertThat(itsRawGnssMeasurementRecord.getDriftNanosPerSecond()).isEqualTo("5.41916040414302");
        assertThat(itsRawGnssMeasurementRecord.getDriftUncertaintyNanosPerSecond()).isEqualTo("13.162864206221524");
        assertThat(itsRawGnssMeasurementRecord.getHardwareClockDiscontinuityCount()).isEqualTo("55");
        assertThat(itsRawGnssMeasurementRecord.getSvid()).isEqualTo("2");
        assertThat(itsRawGnssMeasurementRecord.getTimeOffsetNanos()).isEqualTo("0.0");
        assertThat(itsRawGnssMeasurementRecord.getState()).isEqualTo("16399");
        assertThat(itsRawGnssMeasurementRecord.getReceivedSvTimeNanos()).isEqualTo("327358369549839");
        assertThat(itsRawGnssMeasurementRecord.getReceivedSvTimeUncertaintyNanos()).isEqualTo("6");
        assertThat(itsRawGnssMeasurementRecord.getCn0DbHz()).isEqualTo("43.4");
        assertThat(itsRawGnssMeasurementRecord.getPseudorangeRateMetersPerSecond()).isEqualTo("-53.141605377197266");
        assertThat(itsRawGnssMeasurementRecord.getPseudorangeRateUncertaintyMetersPerSecond()).isEqualTo("0.0333000011742115");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeState()).isEqualTo("16");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeMeters()).isEqualTo("-0.0");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeUncertaintyMeters()).isEqualTo("1902.9177342976868");
        assertThat(itsRawGnssMeasurementRecord.getCarrierFrequencyHz()).isEqualTo("1.57542003E9");
        assertThat(itsRawGnssMeasurementRecord.getCarrierCycles()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getCarrierPhase()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getCarrierPhaseUncertainty()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getMultipathIndicator()).isEqualTo("0");
        assertThat(itsRawGnssMeasurementRecord.getSnrInDb()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getConstellationType()).isEqualTo("1");
        assertThat(itsRawGnssMeasurementRecord.getAgcDb()).isEqualTo("0.56");

        assertThat(iterator.hasNext()).isTrue();
        itsRawGnssMeasurementRecord = (RawGnssMeasurementRecord) iterator.next();
        assertThat(itsRawGnssMeasurementRecord.getElapsedRealtimeMillis()).isEqualTo("189362622");
        assertThat(itsRawGnssMeasurementRecord.getTimeNanos()).isEqualTo("147710246000000");
        assertThat(itsRawGnssMeasurementRecord.getLeapSecond()).isEqualTo("18");
        assertThat(itsRawGnssMeasurementRecord.getTimeUncertaintyNanos()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getFullBiasNanos()).isEqualTo("-1292032448199080441");
        assertThat(itsRawGnssMeasurementRecord.getBiasNanos()).isEqualTo("-0.6313767433166504");
        assertThat(itsRawGnssMeasurementRecord.getBiasUncertaintyNanos()).isEqualTo("131.93707854952663");
        assertThat(itsRawGnssMeasurementRecord.getDriftNanosPerSecond()).isEqualTo("5.41916040414302");
        assertThat(itsRawGnssMeasurementRecord.getDriftUncertaintyNanosPerSecond()).isEqualTo("13.162864206221524");
        assertThat(itsRawGnssMeasurementRecord.getHardwareClockDiscontinuityCount()).isEqualTo("55");
        assertThat(itsRawGnssMeasurementRecord.getSvid()).isEqualTo("6");
        assertThat(itsRawGnssMeasurementRecord.getTimeOffsetNanos()).isEqualTo("0.0");
        assertThat(itsRawGnssMeasurementRecord.getState()).isEqualTo("16399");
        assertThat(itsRawGnssMeasurementRecord.getReceivedSvTimeNanos()).isEqualTo("327358365906996");
        assertThat(itsRawGnssMeasurementRecord.getReceivedSvTimeUncertaintyNanos()).isEqualTo("11");
        assertThat(itsRawGnssMeasurementRecord.getCn0DbHz()).isEqualTo("37.2");
        assertThat(itsRawGnssMeasurementRecord.getPseudorangeRateMetersPerSecond()).isEqualTo("318.9681396484375");
        assertThat(itsRawGnssMeasurementRecord.getPseudorangeRateUncertaintyMetersPerSecond()).isEqualTo("0.030700000002980232");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeState()).isEqualTo("16");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeMeters()).isEqualTo("-0.0");
        assertThat(itsRawGnssMeasurementRecord.getAccumulatedDeltaRangeUncertaintyMeters()).isEqualTo("1902.9177342976868");
        assertThat(itsRawGnssMeasurementRecord.getCarrierFrequencyHz()).isEqualTo("1.57542003E9");
        assertThat(itsRawGnssMeasurementRecord.getCarrierCycles()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getCarrierPhase()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getCarrierPhaseUncertainty()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getMultipathIndicator()).isEqualTo("0");
        assertThat(itsRawGnssMeasurementRecord.getSnrInDb()).isEmpty();
        assertThat(itsRawGnssMeasurementRecord.getConstellationType()).isEqualTo("1");
        assertThat(itsRawGnssMeasurementRecord.getAgcDb()).isEqualTo("0.56");

        assertThat(iterator.hasNext()).isFalse();
    }
}