package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;

import java.io.InputStream;
import java.util.Iterator;

class InputStreamAsDataIterator implements Iterator<Data> {
    private final Iterator<Data> itsIterator;

    public InputStreamAsDataIterator(InputStream inputStream) {
        itsIterator =
            new GnssLoggerRecordIteratorAsDataIterator(
                new InputStreamAsGnssLoggerRecordIterator(inputStream));
    }

    public boolean hasNext() {
        return itsIterator.hasNext();
    }

    public Data next() {
        return itsIterator.next();
    }
}
