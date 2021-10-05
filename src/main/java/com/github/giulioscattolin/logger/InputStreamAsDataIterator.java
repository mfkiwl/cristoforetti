package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.iterator.CloseableIterator;

import java.io.InputStream;

class InputStreamAsDataIterator {
    public static CloseableIterator<Data> from(InputStream inputStream) {
        return
            new GnssLoggerRecordIteratorAsDataIterator(
                new InputStreamAsGnssLoggerRecordIterator(inputStream));
    }
}
