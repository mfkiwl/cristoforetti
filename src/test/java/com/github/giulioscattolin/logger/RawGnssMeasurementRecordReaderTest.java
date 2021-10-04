package com.github.giulioscattolin.logger;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RawGnssMeasurementRecordReaderTest {
    RawGnssMeasurementRecord itsRecord;

    @Test
    public void verifyExpectedResult() {
        String line = "Raw,189362621,147710246000000,18,,-1292032448199080441,-0.6313767433166504,131.93707854952663,5.41916040414302,13.162864206221524,55,2,0.0,16399,327358369549839,6,43.4,-53.141605377197266,0.0333000011742115,16,-0.0,1902.9177342976868,1.57542003E9,,,,0,,1,0.56,1.57542003E9";

        itsRecord = RawGnssMeasurementRecordReader.read(line);

        assertThat(itsRecord.getElapsedRealtimeMillis()).isEqualTo("189362621");
        assertThat(itsRecord.getTimeNanos()).isEqualTo("147710246000000");
        assertThat(itsRecord.getLeapSecond()).isEqualTo("18");
        assertThat(itsRecord.getTimeUncertaintyNanos()).isEmpty();
        assertThat(itsRecord.getFullBiasNanos()).isEqualTo("-1292032448199080441");
        assertThat(itsRecord.getBiasNanos()).isEqualTo("-0.6313767433166504");
        assertThat(itsRecord.getBiasUncertaintyNanos()).isEqualTo("131.93707854952663");
        assertThat(itsRecord.getDriftNanosPerSecond()).isEqualTo("5.41916040414302");
        assertThat(itsRecord.getDriftUncertaintyNanosPerSecond()).isEqualTo("13.162864206221524");
        assertThat(itsRecord.getHardwareClockDiscontinuityCount()).isEqualTo("55");
        assertThat(itsRecord.getSvid()).isEqualTo("2");
        assertThat(itsRecord.getTimeOffsetNanos()).isEqualTo("0.0");
        assertThat(itsRecord.getState()).isEqualTo("16399");
        assertThat(itsRecord.getReceivedSvTimeNanos()).isEqualTo("327358369549839");
        assertThat(itsRecord.getReceivedSvTimeUncertaintyNanos()).isEqualTo("6");
        assertThat(itsRecord.getCn0DbHz()).isEqualTo("43.4");
        assertThat(itsRecord.getPseudorangeRateMetersPerSecond()).isEqualTo("-53.141605377197266");
        assertThat(itsRecord.getPseudorangeRateUncertaintyMetersPerSecond()).isEqualTo("0.0333000011742115");
        assertThat(itsRecord.getAccumulatedDeltaRangeState()).isEqualTo("16");
        assertThat(itsRecord.getAccumulatedDeltaRangeMeters()).isEqualTo("-0.0");
        assertThat(itsRecord.getAccumulatedDeltaRangeUncertaintyMeters()).isEqualTo("1902.9177342976868");
        assertThat(itsRecord.getCarrierFrequencyHz()).isEqualTo("1.57542003E9");
        assertThat(itsRecord.getCarrierCycles()).isEmpty();
        assertThat(itsRecord.getCarrierPhase()).isEmpty();
        assertThat(itsRecord.getCarrierPhaseUncertainty()).isEmpty();
        assertThat(itsRecord.getMultipathIndicator()).isEqualTo("0");
        assertThat(itsRecord.getSnrInDb()).isEmpty();
        assertThat(itsRecord.getConstellationType()).isEqualTo("1");
        assertThat(itsRecord.getAgcDb()).isEqualTo("0.56");
    }

    @Test
    public void testIncompleteLine() {
        String line = "Raw,189362621,147710246000000,";

        itsRecord = RawGnssMeasurementRecordReader.read(line);

        assertThat(itsRecord.getElapsedRealtimeMillis()).isEqualTo("189362621");
        assertThat(itsRecord.getTimeNanos()).isEqualTo("147710246000000");
        assertThat(itsRecord.getLeapSecond()).isEmpty();
        assertThat(itsRecord.getTimeUncertaintyNanos()).isEmpty();
        assertThat(itsRecord.getFullBiasNanos()).isEmpty();
        assertThat(itsRecord.getBiasNanos()).isEmpty();
        assertThat(itsRecord.getBiasUncertaintyNanos()).isEmpty();
        assertThat(itsRecord.getDriftNanosPerSecond()).isEmpty();
        assertThat(itsRecord.getDriftUncertaintyNanosPerSecond()).isEmpty();
        assertThat(itsRecord.getHardwareClockDiscontinuityCount()).isEmpty();
        assertThat(itsRecord.getSvid()).isEmpty();
        assertThat(itsRecord.getTimeOffsetNanos()).isEmpty();
        assertThat(itsRecord.getState()).isEmpty();
        assertThat(itsRecord.getReceivedSvTimeNanos()).isEmpty();
        assertThat(itsRecord.getReceivedSvTimeUncertaintyNanos()).isEmpty();
        assertThat(itsRecord.getCn0DbHz()).isEmpty();
        assertThat(itsRecord.getPseudorangeRateMetersPerSecond()).isEmpty();
        assertThat(itsRecord.getPseudorangeRateUncertaintyMetersPerSecond()).isEmpty();
        assertThat(itsRecord.getAccumulatedDeltaRangeState()).isEmpty();
        assertThat(itsRecord.getAccumulatedDeltaRangeMeters()).isEmpty();
        assertThat(itsRecord.getAccumulatedDeltaRangeUncertaintyMeters()).isEmpty();
        assertThat(itsRecord.getCarrierFrequencyHz()).isEmpty();
        assertThat(itsRecord.getCarrierCycles()).isEmpty();
        assertThat(itsRecord.getCarrierPhase()).isEmpty();
        assertThat(itsRecord.getCarrierPhaseUncertainty()).isEmpty();
        assertThat(itsRecord.getMultipathIndicator()).isEmpty();
        assertThat(itsRecord.getSnrInDb()).isEmpty();
        assertThat(itsRecord.getConstellationType()).isEmpty();
        assertThat(itsRecord.getAgcDb()).isEmpty();
    }
}