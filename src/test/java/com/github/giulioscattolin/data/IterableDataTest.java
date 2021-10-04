package com.github.giulioscattolin.data;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static com.google.common.truth.Truth.assertThat;

public class IterableDataTest extends IterableData implements IterableDataVisitor {
    private IterableData itsIterableData;

    @Before
    public void reset() {
        itsIterableData = null;
    }

    public void visit(IterableData iterableData) {
        itsIterableData = iterableData;
    }

    @Test
    public void verifyItImplementsIterable() {
        assertThat(this).isInstanceOf(Iterable.class);
    }

    @Test
    public void verifyDynamicDispatch() {
        accept(this);

        assertThat(itsIterableData).isEqualTo(this);
    }

    public Iterator<Data> iterator() {
        return null;
    }
}