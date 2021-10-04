package com.github.giulioscattolin.measurement;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ImmutableRawGnssMeasurement implements RawGnssMeasurement {
    public static Builder getBuilder() {
        return new AutoValue_ImmutableRawGnssMeasurement.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder hasBiasNanos(boolean hasBiasNanos);

        public abstract Builder getBiasNanos(double getBiasNanos);

        public abstract Builder hasConstellationType(boolean hasConstellationType);

        public abstract Builder getConstellationType(int getConstellationType);

        public abstract Builder hasFullBiasNanos(boolean hasFullBiasNanos);

        public abstract Builder getFullBiasNanos(long getFullBiasNanos);

        public abstract Builder hasDriftNanosPerSecond(boolean hasDriftNanosPerSecond);

        public abstract Builder getDriftNanosPerSecond(double getDriftNanosPerSecond);

        public abstract Builder hasReceivedSvTimeNanos(boolean hasReceivedSvTimeNanos);

        public abstract Builder getReceivedSvTimeNanos(long getReceivedSvTimeNanos);

        public abstract Builder hasState(boolean hasState);

        public abstract Builder getState(long getState);

        public abstract Builder hasHardwareClockDiscontinuityCount(boolean hasHardwareClockDiscontinuityCount);

        public abstract Builder getHardwareClockDiscontinuityCount(int getHardwareClockDiscontinuityCount);

        public abstract Builder hasSvid(boolean hasSvid);

        public abstract Builder getSvid(int getSvid);

        public abstract Builder hasTimeNanos(boolean hasTimeNanos);

        public abstract Builder getTimeNanos(long getTimeNanos);

        public abstract Builder hasElapsedRealtimeMillis(boolean hasElapsedRealtimeMillis);

        public abstract Builder getElapsedRealtimeMillis(long getElapsedRealtimeMillis);

        public abstract Builder hasTimeOffsetNanos(boolean hasTimeOffsetNanos);

        public abstract Builder getTimeOffsetNanos(long getTimeOffsetNanos);

        public abstract Builder hasCarrierFrequencyHz(boolean hasCarrierFrequencyHz);

        public abstract Builder getCarrierFrequencyHz(double getCarrierFrequencyHz);

        public abstract ImmutableRawGnssMeasurement build();
    }
}
