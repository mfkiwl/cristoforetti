package com.github.giulioscattolin.data;

import com.github.giulioscattolin.iterator.CloseableIterator;

import java.util.Iterator;

public interface EagerIterableDataVisitor extends IterableDataVisitor {
    default void visit(IterableData iterableData) {
        Iterator<Data> iterator = iterableData.iterator();
        if (iterator instanceof CloseableIterator)
            visit((CloseableIterator<Data>) iterator);
        else
            visit(iterator);
    }

    default void visit(CloseableIterator<Data> theIterator) {
        try (CloseableIterator<Data> iterator = theIterator) {
            visit((Iterator<Data>) iterator);
        } catch (Exception ignored) {
        }
    }

    default void visit(Iterator<Data> iterator) {
        while (iterator.hasNext())
            iterator.next().accept(this);
    }
}
