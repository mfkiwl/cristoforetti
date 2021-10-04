package com.github.giulioscattolin.data;

import static com.google.common.truth.Truth.assertThat;

class DataReaderSpy implements DataReader {
    private final Data itsData;
    private DataSource itsSource;

    DataReaderSpy(Data data) {
        itsData = data;
    }

    public Data read(DataSource source) {
        itsSource = source;
        return itsData;
    }

    void verifySourceIsEqualTo(DataSource expected) {
        assertThat(itsSource).isEqualTo(expected);
    }
}
