package com.github.giulioscattolin.data;

public interface EagerIterableDataVisitor extends IterableDataVisitor {
    default void visit(IterableData iterableData) {
        for (Data data: iterableData)
            data.accept(this);
    }
}
