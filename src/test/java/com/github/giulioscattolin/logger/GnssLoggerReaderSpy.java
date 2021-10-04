package com.github.giulioscattolin.logger;

import static com.google.common.truth.Truth.assertThat;

class GnssLoggerReaderSpy implements GnssLoggerReader {
    private final GnssLoggerData itsData;
    private GnssLoggerSource itsSource;

    GnssLoggerReaderSpy(GnssLoggerData data) {
        itsData = data;
    }

    public GnssLoggerData read(GnssLoggerSource source) {
        itsSource = source;
        return itsData;
    }

    void verifySourceIsEqualTo(GnssLoggerSource expected) {
        assertThat(itsSource).isEqualTo(expected);
    }
}
