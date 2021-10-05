package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.EagerIterableDataVisitor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class RawGnssMeasurementProcessors {
    public static class GroupByConstellationTypeEagerly extends GroupByConstellationTypeTemplate implements EagerIterableDataVisitor {
        private final Map<Integer, Collection<RawGnssMeasurement>> itsMeasurementsByConstellationType;

        public GroupByConstellationTypeEagerly(Map<Integer, Collection<RawGnssMeasurement>> measurementsByConstellationType) {
            this.itsMeasurementsByConstellationType = measurementsByConstellationType;
        }

        public Map<Integer, Collection<RawGnssMeasurement>> getMeasurementsByConstellationType() {
            return itsMeasurementsByConstellationType;
        }

        protected Collection<RawGnssMeasurement> getEmptyCollectionByConstellationType(int constellationType) {
            return new LinkedList<>();
        }
    }
}
