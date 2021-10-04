package com.github.giulioscattolin.logger;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class ImmutableRawGnssMeasurementRecord implements RawGnssMeasurementRecord {
    static Builder getBuilder() {
        return new AutoValue_ImmutableRawGnssMeasurementRecord.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setElapsedRealtimeMillis(String newElapsedRealtimeMillis);

        abstract Builder setTimeNanos(String newTimeNanos);

        abstract Builder setLeapSecond(String newLeapSecond);

        abstract Builder setTimeUncertaintyNanos(String newTimeUncertaintyNanos);

        abstract Builder setFullBiasNanos(String newFullBiasNanos);

        abstract Builder setBiasNanos(String newBiasNanos);

        abstract Builder setBiasUncertaintyNanos(String newBiasUncertaintyNanos);

        abstract Builder setDriftNanosPerSecond(String newDriftNanosPerSecond);

        abstract Builder setDriftUncertaintyNanosPerSecond(String newDriftUncertaintyNanosPerSecond);

        abstract Builder setHardwareClockDiscontinuityCount(String newHardwareClockDiscontinuityCount);

        abstract Builder setSvid(String newSvid);

        abstract Builder setTimeOffsetNanos(String newTimeOffsetNanos);

        abstract Builder setState(String newState);

        abstract Builder setReceivedSvTimeNanos(String newReceivedSvTimeNanos);

        abstract Builder setReceivedSvTimeUncertaintyNanos(String newReceivedSvTimeUncertaintyNanos);

        abstract Builder setCn0DbHz(String newCn0DbHz);

        abstract Builder setPseudorangeRateMetersPerSecond(String newPseudorangeRateMetersPerSecond);

        abstract Builder setPseudorangeRateUncertaintyMetersPerSecond(String newPseudorangeRateUncertaintyMetersPerSecond);

        abstract Builder setAccumulatedDeltaRangeState(String newAccumulatedDeltaRangeState);

        abstract Builder setAccumulatedDeltaRangeMeters(String newAccumulatedDeltaRangeMeters);

        abstract Builder setAccumulatedDeltaRangeUncertaintyMeters(String newAccumulatedDeltaRangeUncertaintyMeters);

        abstract Builder setCarrierFrequencyHz(String newCarrierFrequencyHz);

        abstract Builder setCarrierCycles(String newCarrierCycles);

        abstract Builder setCarrierPhase(String newCarrierPhase);

        abstract Builder setCarrierPhaseUncertainty(String newCarrierPhaseUncertainty);

        abstract Builder setMultipathIndicator(String newMultipathIndicator);

        abstract Builder setSnrInDb(String newSnrInDb);

        abstract Builder setConstellationType(String newConstellationType);

        abstract Builder setAgcDb(String newAgcDb);

        abstract ImmutableRawGnssMeasurementRecord build();
    }
}
