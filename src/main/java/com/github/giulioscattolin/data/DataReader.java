package com.github.giulioscattolin.data;

public interface DataReader {
    void read(DataSource source, DataCollector collector);
}
