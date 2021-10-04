package com.github.giulioscattolin.data;

public interface DataFileVisitor extends DataSource {
    void visit(DataFile dataFile);
}
