package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.EagerIterableDataVisitor;

import java.util.Collection;

public class DataCollectionEmitterStrategies {
    public static class GroupRawMeasurementsByElapsedRealtimeMillisEagerly extends GroupByElapsedRealtimeMillisTemplate implements EagerIterableDataVisitor {
        private final Collection<Data> itsCollection;
        private final Runnable itsCollectionEmitter;

        public GroupRawMeasurementsByElapsedRealtimeMillisEagerly(Collection<Data> collection, Runnable emitter) {
            itsCollection = collection;
            itsCollectionEmitter = emitter;
        }

        protected Runnable getCollectionEmitter() {
            return itsCollectionEmitter;
        }

        protected Collection<Data> getCollection() {
            return itsCollection;
        }
    }
}
