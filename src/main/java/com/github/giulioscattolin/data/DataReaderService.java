package com.github.giulioscattolin.data;

public class DataReaderService extends DataReaderProxy {
    private static DataReader itsReader;

    static {
        reset();
    }

    public static void inject(DataReader reader) {
        itsReader = reader;
    }

    static void reset() {
        itsReader = new UndefinedDataReader();
    }

    protected DataReader getReader() {
        return itsReader;
    }
}