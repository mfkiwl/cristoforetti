package com.github.giulioscattolin.logger;

import java.util.function.Consumer;

class RawGnssMeasurementRecordParser {
    private final String[] itsFields;

    private RawGnssMeasurementRecordParser(String line) {
        itsFields = line.split(",");
    }

    static void parse(String line, Consumer<GnssLoggerRecord> collector) {
        if (line.startsWith("Raw"))
            collector.accept(parse(line));
    }

    static RawGnssMeasurementRecord parse(String line) {
        return new RawGnssMeasurementRecordParser(line).getRecord();
    }

    private RawGnssMeasurementRecord getRecord() {
        return
            ImmutableRawGnssMeasurementRecord
                .getBuilder()
                .setElapsedRealtimeMillis(getFieldAt(1))
                .setTimeNanos(getFieldAt(2))
                .setLeapSecond(getFieldAt(3))
                .setTimeUncertaintyNanos(getFieldAt(4))
                .setFullBiasNanos(getFieldAt(5))
                .setBiasNanos(getFieldAt(6))
                .setBiasUncertaintyNanos(getFieldAt(7))
                .setDriftNanosPerSecond(getFieldAt(8))
                .setDriftUncertaintyNanosPerSecond(getFieldAt(9))
                .setHardwareClockDiscontinuityCount(getFieldAt(10))
                .setSvid(getFieldAt(11))
                .setTimeOffsetNanos(getFieldAt(12))
                .setState(getFieldAt(13))
                .setReceivedSvTimeNanos(getFieldAt(14))
                .setReceivedSvTimeUncertaintyNanos(getFieldAt(15))
                .setCn0DbHz(getFieldAt(16))
                .setPseudorangeRateMetersPerSecond(getFieldAt(17))
                .setPseudorangeRateUncertaintyMetersPerSecond(getFieldAt(18))
                .setAccumulatedDeltaRangeState(getFieldAt(19))
                .setAccumulatedDeltaRangeMeters(getFieldAt(20))
                .setAccumulatedDeltaRangeUncertaintyMeters(getFieldAt(21))
                .setCarrierFrequencyHz(getFieldAt(22))
                .setCarrierCycles(getFieldAt(23))
                .setCarrierPhase(getFieldAt(24))
                .setCarrierPhaseUncertainty(getFieldAt(25))
                .setMultipathIndicator(getFieldAt(26))
                .setSnrInDb(getFieldAt(27))
                .setConstellationType(getFieldAt(28))
                .setAgcDb(getFieldAt(29))
                .build();
    }

    private String getFieldAt(int index) {
        if (index < itsFields.length)
            return itsFields[index];
        else
            return "";
    }
}
