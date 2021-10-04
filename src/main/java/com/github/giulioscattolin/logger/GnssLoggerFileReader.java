package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataFile;
import com.github.giulioscattolin.data.DataReader;
import com.github.giulioscattolin.data.DataSource;

public class GnssLoggerFileReader implements DataReader {
    public Data read(DataSource source) {
        if (source instanceof DataFile)
            return read((DataFile) source);
        else
            return null;
    }

    protected Data read(DataFile dataFile) {
        if (isGnssLoggerPlainFile(dataFile))
            return new FileAsData(dataFile);
        else
            return null;
    }

    private boolean isGnssLoggerPlainFile(DataFile dataFile) {
        return
            dataFile.getName().startsWith("gnss_log")
                && dataFile.getName().endsWith(".txt")
                && dataFile.isFile();
    }
}


