package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.*;

public class GnssLoggerFileReader implements DataReader {
    public void read(DataSource source, DataCollector collector) {
        if (source instanceof DataFile)
            read((DataFile) source, collector);
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


