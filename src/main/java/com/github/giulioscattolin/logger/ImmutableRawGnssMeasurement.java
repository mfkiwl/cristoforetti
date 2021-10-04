package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.measurement.RawGnssMeasurement;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class ImmutableRawGnssMeasurement implements RawGnssMeasurement {
    static Builder getBuilder() {
        return new AutoValue_ImmutableRawGnssMeasurement.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder hasBiasNanos(boolean hasBiasNanos);

        abstract Builder getBiasNanos(double getBiasNanos);

        abstract Builder hasConstellationType(boolean hasConstellationType);

        abstract Builder getConstellationType(int getConstellationType);

        abstract Builder hasFullBiasNanos(boolean hasFullBiasNanos);

        abstract Builder getFullBiasNanos(long getFullBiasNanos);

        abstract Builder hasDriftNanosPerSecond(boolean hasDriftNanosPerSecond);

        abstract Builder getDriftNanosPerSecond(double getDriftNanosPerSecond);

        abstract Builder hasReceivedSvTimeNanos(boolean hasReceivedSvTimeNanos);

        abstract Builder getReceivedSvTimeNanos(long getReceivedSvTimeNanos);

        abstract Builder hasState(boolean hasState);

        abstract Builder getState(long getState);

        abstract Builder hasHardwareClockDiscontinuityCount(boolean hasHardwareClockDiscontinuityCount);

        abstract Builder getHardwareClockDiscontinuityCount(int getHardwareClockDiscontinuityCount);

        abstract Builder hasSvid(boolean hasSvid);

        abstract Builder getSvid(int getSvid);

        abstract Builder hasTimeNanos(boolean hasTimeNanos);

        abstract Builder getTimeNanos(long getTimeNanos);

        abstract Builder hasElapsedRealtimeMillis(boolean hasElapsedRealtimeMillis);

        abstract Builder getElapsedRealtimeMillis(long getElapsedRealtimeMillis);

        abstract Builder hasTimeOffsetNanos(boolean hasTimeOffsetNanos);

        abstract Builder getTimeOffsetNanos(long getTimeOffsetNanos);

        abstract Builder hasCarrierFrequencyHz(boolean hasCarrierFrequencyHz);

        abstract Builder getCarrierFrequencyHz(double getCarrierFrequencyHz);

        abstract ImmutableRawGnssMeasurement build();
    }
}
