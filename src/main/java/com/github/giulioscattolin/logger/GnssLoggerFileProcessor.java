package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.*;

public class GnssLoggerFileProcessor implements DataProcessor, DataFileVisitor {
    private final DataProcessor itsNextProcessor;

    public GnssLoggerFileProcessor(DataProcessor collector) {
        itsNextProcessor = collector;
    }

    public void process(Data data) {
        data.accept(this);
    }

    public void visit(DataFile dataFile) {
        if (dataFile.getName().startsWith("gnss_log") && dataFile.isFile())
            if (dataFile.getName().endsWith(".txt"))
                itsNextProcessor.process(new FileAsData(dataFile));
    }
}


