package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataVisitor;

public interface RawGnssMeasurement extends Data {
    default void accept(DataVisitor visitor) {
        if (visitor instanceof RawGnssMeasurementVisitor)
            ((RawGnssMeasurementVisitor) visitor).visit(this);
    }

    boolean hasBiasNanos();

    double getBiasNanos();

    boolean hasConstellationType();

    int getConstellationType();

    boolean hasFullBiasNanos();

    long getFullBiasNanos();

    boolean hasDriftNanosPerSecond();

    double getDriftNanosPerSecond();

    boolean hasReceivedSvTimeNanos();

    long getReceivedSvTimeNanos();

    boolean hasState();

    long getState();

    boolean hasHardwareClockDiscontinuityCount();

    int getHardwareClockDiscontinuityCount();

    boolean hasSvid();

    int getSvid();

    boolean hasTimeNanos();

    long getTimeNanos();

    boolean hasElapsedRealtimeMillis();

    long getElapsedRealtimeMillis();

    boolean hasTimeOffsetNanos();

    long getTimeOffsetNanos();

    boolean hasCarrierFrequencyHz();

    double getCarrierFrequencyHz();

    default boolean doesStateMatch(int mask) {
        return (getState() & mask) == mask;
    }

    interface ConstellationType {
        int BEIDOU = 5;
        int GALILEO = 6;
        int GLONASS = 3;
        int GPS = 1;
        int IRNSS = 7;
        int QZSS = 4;
        int SBAS = 2;
        int UNKNOWN = 0;
    }

    interface StateFlag {
        int STATE_2ND_CODE_LOCK = 65536;
        int STATE_BDS_D2_BIT_SYNC = 256;
        int STATE_BDS_D2_SUBFRAME_SYNC = 512;
        int STATE_BIT_SYNC = 2;
        int STATE_CODE_LOCK = 1;
        int STATE_GAL_E1BC_CODE_LOCK = 1024;
        int STATE_GAL_E1B_PAGE_SYNC = 4096;
        int STATE_GAL_E1C_2ND_CODE_LOCK = 2048;
        int STATE_GLO_STRING_SYNC = 64;
        int STATE_GLO_TOD_DECODED = 128;
        int STATE_GLO_TOD_KNOWN = 32768;
        int STATE_MSEC_AMBIGUOUS = 16;
        int STATE_SBAS_SYNC = 8192;
        int STATE_SUBFRAME_SYNC = 4;
        int STATE_SYMBOL_SYNC = 32;
        int STATE_TOW_DECODED = 8;
        int STATE_TOW_KNOWN = 16384;
        int STATE_UNKNOWN = 0;
    }
}
