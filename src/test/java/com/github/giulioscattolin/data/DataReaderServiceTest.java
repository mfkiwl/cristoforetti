package com.github.giulioscattolin.data;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static com.google.common.truth.Truth.assertThat;

public class DataReaderServiceTest {
    Data itsData;
    DataSource itsSource;
    DataReaderSpy itsReaderSpy;
    Collection<Data> itsDataCollection;

    @Before
    public void reset() {
        DataReaderService.reset();
        itsData = new DataDummy();
        itsSource = new DataSourceDummy();
        itsReaderSpy = new DataReaderSpy(itsData);
        itsDataCollection = new LinkedList<>();
    }

    @Test(expected = IllegalStateException.class)
    public void verifyUndefinedReaderBehavior() {
        new DataReaderService().read(new DataSourceDummy(), new DataCollectorDummy());
    }

    @Test
    public void verifyServiceUsesInjectedFactory() {
        DataReaderService.inject(itsReaderSpy);

        new DataReaderService().read(itsSource, itsDataCollection::add);

        assertThat(itsDataCollection).contains(itsData);
        itsReaderSpy.verifySourceIsEqualTo(itsSource);
    }
}