package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataProcessor;
import com.github.giulioscattolin.data.EagerIterableDataVisitor;

import java.util.Collection;
import java.util.Map;

abstract class GroupByConstellationTypeTemplate implements
    DataProcessor,
    EagerIterableDataVisitor,
    RawGnssMeasurementVisitor {
    public abstract Map<Integer, Collection<RawGnssMeasurement>> getMeasurementsByConstellationType();

    public void process(Data data) {
        data.accept(this);
    }

    public void visit(RawGnssMeasurement rawGnssMeasurement) {
        if (rawGnssMeasurement.hasConstellationType())
            put(rawGnssMeasurement.getConstellationType(), rawGnssMeasurement);
    }

    private void put(int constellationType, RawGnssMeasurement rawGnssMeasurement) {
        getMeasurementsByConstellationType(constellationType).add(rawGnssMeasurement);
    }

    private Collection<RawGnssMeasurement> getMeasurementsByConstellationType(int constellationType) {
        return getMeasurementsByConstellationType().computeIfAbsent(constellationType, this::getEmptyCollectionByConstellationType);
    }

    protected abstract Collection<RawGnssMeasurement> getEmptyCollectionByConstellationType(int constellationType);
}
