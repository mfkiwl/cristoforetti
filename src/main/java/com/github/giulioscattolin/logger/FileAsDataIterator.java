package com.github.giulioscattolin.logger;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.iterator.CloseableIterator;
import com.github.giulioscattolin.iterator.EmptyCloseableIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class FileAsDataIterator {
    public static CloseableIterator<Data> from(File file) {
        try {
            return InputStreamAsDataIterator.from(new FileInputStream(file));
        } catch (IOException ioException) {
            return new EmptyCloseableIterator<>();
        }
    }
}
