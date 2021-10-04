package com.github.giulioscattolin.logger;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static com.github.giulioscattolin.iterator.InputStreamAsLineIterator.asLineIterator;

class InputStreamAsGnssLoggerRecordIterator implements Iterator<GnssLoggerRecord> {
    private final Iterator<String> itsLineIterator;
    private final Queue<GnssLoggerRecord> itsBuffer = new LinkedList<>();
    private final RawGnssMeasurementRecordCollector itsRawGnssMeasurementRecordCollector = new RawGnssMeasurementRecordCollector(itsBuffer::add);

    public InputStreamAsGnssLoggerRecordIterator(InputStream inputStream) {
        itsLineIterator = asLineIterator(inputStream);
    }

    public boolean hasNext() {
        buffer();
        return !itsBuffer.isEmpty();
    }

    private void buffer() {
        while (itsBuffer.isEmpty() && itsLineIterator.hasNext())
            parseLine(itsLineIterator.next());
    }

    private void parseLine(String line) {
        itsRawGnssMeasurementRecordCollector.accept(line);
    }

    public GnssLoggerRecord next() {
        return itsBuffer.remove();
    }
}
