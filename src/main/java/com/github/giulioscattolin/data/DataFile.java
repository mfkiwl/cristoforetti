package com.github.giulioscattolin.data;

import java.io.File;
import java.net.URI;

public class DataFile extends File implements DataSource {
    public DataFile(String pathname) {
        super(pathname);
    }

    public DataFile(String parent, String child) {
        super(parent, child);
    }

    public DataFile(File parent, String child) {
        super(parent, child);
    }

    public DataFile(URI uri) {
        super(uri);
    }

    public void accept(DataSourceVisitor visitor) {
        if (visitor instanceof DataFileVisitor)
            ((DataFileVisitor) visitor).visit(this);
    }
}
