package com.github.giulioscattolin.data;

public abstract class IterableData implements Data, Iterable<Data> {
    public void accept(DataVisitor visitor) {
        if (visitor instanceof IterableDataVisitor)
            ((IterableDataVisitor) visitor).visit(this);
    }
}
