package com.github.giulioscattolin.data;

public interface DataFileVisitor extends DataVisitor {
    void visit(DataFile dataFile);
}
