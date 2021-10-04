package com.github.giulioscattolin.data;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DataReaderServiceTest {
    Data itsData;
    DataSource itsSource;
    DataReaderSpy itsReaderSpy;

    @Before
    public void reset() {
        DataReaderService.reset();
        itsData = new DataDummy();
        itsSource = new DataSourceDummy();
        itsReaderSpy = new DataReaderSpy(itsData);
    }

    @Test(expected = IllegalStateException.class)
    public void verifyUndefinedReaderBehavior() {
        new DataReaderService().read(new DataSourceDummy());
    }

    @Test
    public void verifyServiceUsesInjectedFactory() {
        DataReaderService.inject(itsReaderSpy);

        assertThat(new DataReaderService().read(itsSource)).isEqualTo(itsData);
        itsReaderSpy.verifySourceIsEqualTo(itsSource);
    }
}