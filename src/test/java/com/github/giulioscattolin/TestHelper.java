package com.github.giulioscattolin;

import com.github.giulioscattolin.data.DataFile;

public class TestHelper {
    public static DataFile asDataFile(String name) {
        return new DataFile(TestHelper.class.getClassLoader().getResource(name).getFile());
    }
}
