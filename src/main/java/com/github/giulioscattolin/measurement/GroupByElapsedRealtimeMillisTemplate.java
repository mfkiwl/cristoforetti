package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataCollectionEmitterStrategy;

import java.util.Collection;

abstract class GroupByElapsedRealtimeMillisTemplate implements DataCollectionEmitterStrategy, RawGnssMeasurementVisitor {
    public void visit(RawGnssMeasurement measurement) {
        if (measurement.hasElapsedRealtimeMillis()) {
            if (!getCollection().isEmpty() && getAnyCollectedMeasurement().getElapsedRealtimeMillis() < measurement.getElapsedRealtimeMillis())
                getCollectionEmitter().run();
            getCollection().add(measurement);
        }
    }

    protected abstract Runnable getCollectionEmitter();

    protected abstract Collection<Data> getCollection();

    private RawGnssMeasurement getAnyCollectedMeasurement() {
        return (RawGnssMeasurement) getCollection().iterator().next();
    }
}
