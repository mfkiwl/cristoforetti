package com.github.giulioscattolin.data;

abstract class DataReaderProxy implements DataReader {
    public void read(DataSource source, DataCollector collector) {
        getReader().read(source, collector);
    }

    protected abstract DataReader getReader();
}
