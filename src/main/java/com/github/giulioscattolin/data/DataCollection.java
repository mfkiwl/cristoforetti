package com.github.giulioscattolin.data;

import com.github.giulioscattolin.collection.CollectionProxy;

import java.util.ArrayList;
import java.util.Collection;

public class DataCollection extends CollectionProxy<Data> implements Data {
    private final Collection<Data> itsDataCollection;

    public DataCollection(Collection<Data> dataCollection) {
        itsDataCollection = new ArrayList<>(dataCollection);
    }

    public void accept(DataVisitor visitor) {
        if (visitor instanceof DataCollectionVisitor)
            ((DataCollectionVisitor) visitor).visit(this);
    }

    protected Collection<Data> getCollection() {
        return itsDataCollection;
    }
}
