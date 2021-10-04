package com.github.giulioscattolin.logger;

interface RawGnssMeasurementRecord extends GnssLoggerRecord {
    String getElapsedRealtimeMillis();

    String getTimeNanos();

    String getLeapSecond();

    String getTimeUncertaintyNanos();

    String getFullBiasNanos();

    String getBiasNanos();

    String getBiasUncertaintyNanos();

    String getDriftNanosPerSecond();

    String getDriftUncertaintyNanosPerSecond();

    String getHardwareClockDiscontinuityCount();

    String getSvid();

    String getTimeOffsetNanos();

    String getState();

    String getReceivedSvTimeNanos();

    String getReceivedSvTimeUncertaintyNanos();

    String getCn0DbHz();

    String getPseudorangeRateMetersPerSecond();

    String getPseudorangeRateUncertaintyMetersPerSecond();

    String getAccumulatedDeltaRangeState();

    String getAccumulatedDeltaRangeMeters();

    String getAccumulatedDeltaRangeUncertaintyMeters();

    String getCarrierFrequencyHz();

    String getCarrierCycles();

    String getCarrierPhase();

    String getCarrierPhaseUncertainty();

    String getMultipathIndicator();

    String getSnrInDb();

    String getConstellationType();

    String getAgcDb();

    default void accept(GnssLoggerRecordVisitor visitor) {
        visitor.visit(this);
    }
}
