package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class GnssLoggerRecordIteratorAsDataIterator implements Iterator<Data> {
    private final Iterator<GnssLoggerRecord> itsGnssLoggerRecordIterator;
    private final Queue<Data> itsDataBuffer = new LinkedList<>();
    private final RawGnssMeasurementCollector itsRawGnssMeasurementCollector = new RawGnssMeasurementCollector(itsDataBuffer::add);

    public GnssLoggerRecordIteratorAsDataIterator(Iterator<GnssLoggerRecord> gnssLoggerRecordIterator) {
        itsGnssLoggerRecordIterator = gnssLoggerRecordIterator;
    }

    public boolean hasNext() {
        buffer();
        return !itsDataBuffer.isEmpty();
    }

    private void buffer() {
        while (itsDataBuffer.isEmpty() && itsGnssLoggerRecordIterator.hasNext())
            buffer(itsGnssLoggerRecordIterator.next());
    }

    private void buffer(GnssLoggerRecord record) {
        record.accept(itsRawGnssMeasurementCollector);
    }

    public Data next() {
        return itsDataBuffer.remove();
    }
}
