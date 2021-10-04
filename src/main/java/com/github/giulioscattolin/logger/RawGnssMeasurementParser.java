package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.measurement.ImmutableRawGnssMeasurement;
import com.github.giulioscattolin.measurement.RawGnssMeasurement;

import java.util.function.Consumer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class RawGnssMeasurementParser {
    private final RawGnssMeasurementRecord itsRecord;

    private RawGnssMeasurementParser(RawGnssMeasurementRecord record) {
        itsRecord = record;
    }

    static RawGnssMeasurement parse(RawGnssMeasurementRecord record) {
        return new RawGnssMeasurementParser(record).getMeasurement();
    }

    private RawGnssMeasurement getMeasurement() {
        ImmutableRawGnssMeasurement.Builder builder = ImmutableRawGnssMeasurement.getBuilder();
        asDouble(itsRecord.getBiasNanos(), builder::hasBiasNanos, builder::getBiasNanos);
        asInteger(itsRecord.getConstellationType(), builder::hasConstellationType, builder::getConstellationType);
        asLong(itsRecord.getFullBiasNanos(), builder::hasFullBiasNanos, builder::getFullBiasNanos);
        asDouble(itsRecord.getDriftNanosPerSecond(), builder::hasDriftNanosPerSecond, builder::getDriftNanosPerSecond);
        asLong(itsRecord.getReceivedSvTimeNanos(), builder::hasReceivedSvTimeNanos, builder::getReceivedSvTimeNanos);
        asLong(itsRecord.getState(), builder::hasState, builder::getState);
        asInteger(itsRecord.getHardwareClockDiscontinuityCount(), builder::hasHardwareClockDiscontinuityCount, builder::getHardwareClockDiscontinuityCount);
        asInteger(itsRecord.getSvid(), builder::hasSvid, builder::getSvid);
        asLong(itsRecord.getTimeNanos(), builder::hasTimeNanos, builder::getTimeNanos);
        asLong(itsRecord.getElapsedRealtimeMillis(), builder::hasElapsedRealtimeMillis, builder::getElapsedRealtimeMillis);
        asLong(itsRecord.getTimeOffsetNanos(), builder::hasTimeOffsetNanos, builder::getTimeOffsetNanos);
        asDouble(itsRecord.getCarrierFrequencyHz(), builder::hasCarrierFrequencyHz, builder::getCarrierFrequencyHz);
        return builder.build();
    }

    private static void asDouble(String field, Consumer<Boolean> flagSetter, Consumer<Double> valueSetter) {
        if (field.isEmpty()) {
            valueSetter.accept(0.0);
            flagSetter.accept(false);
            return;
        }
        try {
            valueSetter.accept(parseDouble(field));
            flagSetter.accept(true);
        } catch (NumberFormatException ignored) {
            valueSetter.accept(0.0);
            flagSetter.accept(false);
        }
    }

    private static void asInteger(String field, Consumer<Boolean> flagSetter, Consumer<Integer> valueSetter) {
        if (field.isEmpty()) {
            valueSetter.accept(0);
            flagSetter.accept(false);
            return;
        }
        try {
            valueSetter.accept(parseInt(field));
            flagSetter.accept(true);
        } catch (NumberFormatException ignored) {
            valueSetter.accept(0);
            flagSetter.accept(false);
        }
    }

    private static void asLong(String field, Consumer<Boolean> flagSetter, Consumer<Long> valueSetter) {
        if (field.isEmpty()) {
            valueSetter.accept(0L);
            flagSetter.accept(false);
            return;
        }
        try {
            valueSetter.accept(parseLong(field));
            flagSetter.accept(true);
        } catch (NumberFormatException ignored) {
            valueSetter.accept(0L);
            flagSetter.accept(false);
        }
    }
}
