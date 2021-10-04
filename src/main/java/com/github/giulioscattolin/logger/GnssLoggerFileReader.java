package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.*;

public class GnssLoggerFileReader implements DataReader {
    public Data read(DataSource source) {
        if (source instanceof DataFile)
            return read((DataFile) source);
        else
            return null;
    }

    public void read(DataSource source, DataCollector collector) {
        if (source instanceof DataFile)
            read((DataFile) source, collector);
    }

    protected Data read(DataFile dataFile) {
        if (isGnssLoggerPlainFile(dataFile))
            return new FileAsData(dataFile);
        else
            return null;
    }

    private void read(DataFile dataFile, DataCollector collector) {
        if (isGnssLoggerPlainFile(dataFile))
            collector.accept(new FileAsData(dataFile));
    }

    private boolean isGnssLoggerPlainFile(DataFile dataFile) {
        return
            dataFile.getName().startsWith("gnss_log")
                && dataFile.getName().endsWith(".txt")
                && dataFile.isFile();
    }
}


