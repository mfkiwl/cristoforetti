package com.github.giulioscattolin.iterator;

import java.util.NoSuchElementException;

public class EmptyCloseableIterator<E> implements CloseableIterator<E> {
    public void close() {
    }

    public boolean hasNext() {
        return false;
    }

    public E next() {
        throw new NoSuchElementException();
    }
}
