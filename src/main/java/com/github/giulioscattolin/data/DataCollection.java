package com.github.giulioscattolin.data;

import java.util.Collection;

public abstract class DataCollection implements Data, Collection<Data> {
    public void accept(DataVisitor visitor) {
        if (visitor instanceof DataCollectionVisitor)
            ((DataCollectionVisitor) visitor).visit(this);
    }
}
