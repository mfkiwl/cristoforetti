package com.github.giulioscattolin.logger;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class GnssLoggerReaderServiceTest {
    GnssLoggerData itsData;
    GnssLoggerSource itsSource;
    GnssLoggerReaderSpy itsReaderSpy;

    @Before
    public void reset() {
        GnssLoggerReaderService.reset();
        itsData = new GnssLoggerDataDummy();
        itsSource = new GnssLoggerSourceDummy();
        itsReaderSpy = new GnssLoggerReaderSpy(itsData);
    }

    @Test(expected = IllegalStateException.class)
    public void verifyUndefinedReaderBehavior() {
        new GnssLoggerReaderService().read(new GnssLoggerSourceDummy());
    }

    @Test
    public void verifyServiceUsesInjectedFactory() {
        GnssLoggerReaderService.inject(itsReaderSpy);

        assertThat(new GnssLoggerReaderService().read(itsSource)).isEqualTo(itsData);
        itsReaderSpy.verifySourceIsEqualTo(itsSource);
    }
}