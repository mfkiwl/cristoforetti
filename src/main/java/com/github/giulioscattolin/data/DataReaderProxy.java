package com.github.giulioscattolin.data;

abstract class DataReaderProxy implements DataReader {
    public Data read(DataSource source) {
        return getReader().read(source);
    }

    protected abstract DataReader getReader();
}
