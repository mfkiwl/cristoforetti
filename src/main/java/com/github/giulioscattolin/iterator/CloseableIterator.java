package com.github.giulioscattolin.iterator;

import java.util.Iterator;

public interface CloseableIterator<T> extends Iterator<T>, AutoCloseable {
}
