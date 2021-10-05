package com.github.giulioscattolin.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class InputStreamAsLineIterator implements CloseableIterator<String> {
    private final BufferedReader itsBufferedReader;
    private final Queue<String> itsLineBuffer = new LinkedList<>();

    public InputStreamAsLineIterator(InputStream inputStream) {
        itsBufferedReader =
            new BufferedReader(
                new InputStreamReader(inputStream));
    }

    public static CloseableIterator<String> asLineIterator(InputStream inputStream) {
        return new InputStreamAsLineIterator(inputStream);
    }

    public boolean hasNext() {
        if (!itsLineBuffer.isEmpty())
            return true;
        tryBufferLine();
        return !itsLineBuffer.isEmpty();
    }

    private void tryBufferLine() {
        String line = getLine();
        if (line != null)
            itsLineBuffer.add(line);
    }

    public void close() throws Exception {
        itsBufferedReader.close();
    }

    private String getLine() {
        try {
            return tryGetLine();
        } catch (IOException e) {
            return null;
        }
    }

    private String tryGetLine() throws IOException {
        return itsBufferedReader.readLine();
    }

    public String next() {
        return itsLineBuffer.remove();
    }
}
