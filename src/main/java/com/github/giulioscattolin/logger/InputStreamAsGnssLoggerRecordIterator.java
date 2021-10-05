package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.iterator.CloseableIterator;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

import static com.github.giulioscattolin.iterator.InputStreamAsLineIterator.asLineIterator;

class InputStreamAsGnssLoggerRecordIterator implements CloseableIterator<GnssLoggerRecord> {
    private final CloseableIterator<String> itsLineIterator;
    private final Queue<GnssLoggerRecord> itsBuffer = new LinkedList<>();

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
        RawGnssMeasurementRecordReader.read(line, itsBuffer::add);
    }

    public GnssLoggerRecord next() {
        return itsBuffer.remove();
    }

    public void close() throws Exception {
        itsLineIterator.close();
    }
}
