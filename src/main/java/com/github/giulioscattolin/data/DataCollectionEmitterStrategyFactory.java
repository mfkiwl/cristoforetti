package com.github.giulioscattolin.data;

import java.util.Collection;

public interface DataCollectionEmitterStrategyFactory {
    DataCollectionEmitterStrategy makeStrategy(Collection<Data> collection, Runnable emitter);
}
