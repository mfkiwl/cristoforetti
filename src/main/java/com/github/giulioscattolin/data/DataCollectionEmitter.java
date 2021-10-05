package com.github.giulioscattolin.data;

import java.util.LinkedList;
import java.util.Queue;

public class DataCollectionEmitter implements DataProcessor {
    private final Queue<Data> itsCollection = new LinkedList<>();
    private final DataCollectionEmitterStrategy itsStrategy;
    private final DataProcessor itsNextProcessor;

    public DataCollectionEmitter(DataCollectionEmitterStrategyFactory strategyFactory, DataProcessor nextProcessor) {
        itsNextProcessor = nextProcessor;
        itsStrategy = strategyFactory.makeStrategy(itsCollection, this::emitCollection);
    }

    public void process(Data data) {
        data.accept(itsStrategy);
    }

    private void emitCollection() {
        itsNextProcessor.process(new DataCollection(itsCollection));
        itsCollection.clear();
    }
}
