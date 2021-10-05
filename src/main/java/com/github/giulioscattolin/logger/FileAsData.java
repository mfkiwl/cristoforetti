package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataFile;
import com.github.giulioscattolin.data.IterableData;

import java.util.Iterator;

class FileAsData extends IterableData {
    private final DataFile itsDataFile;

    public FileAsData(DataFile dataFile) {
        itsDataFile = dataFile;
    }

    public Iterator<Data> iterator() {
        return FileAsDataIterator.from(itsDataFile);
    }
}
