package com.github.giulioscattolin.data;

public interface IterableDataVisitor extends DataVisitor {
    void visit(IterableData iterableData);
}
