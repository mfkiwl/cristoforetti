package com.github.giulioscattolin.data;

class UndefinedDataReader implements DataReader {
    private static final String MESSAGE = "No DataReader implementation has been injected.";

    public Data read(DataSource source) {
        throw new IllegalStateException(MESSAGE);
    }
}
