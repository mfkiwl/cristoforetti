package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import static java.util.Collections.emptyIterator;

class FileAsDataIterator implements Iterator<Data> {
    private final Iterator<Data> itsIterator;

    FileAsDataIterator(DataFile dataFile) {
        itsIterator = getIterator(dataFile);
    }

    private Iterator<Data> getIterator(DataFile dataFile) {
        try {
            return tryGetIterator(dataFile);
        } catch (IOException ioException) {
            return emptyIterator();
        }
    }

    private Iterator<Data> tryGetIterator(DataFile dataFile) throws IOException {
        return new InputStreamAsDataIterator(new FileInputStream(dataFile));
    }

    public boolean hasNext() {
        return itsIterator.hasNext();
    }

    public Data next() {
        return itsIterator.next();
    }
}
