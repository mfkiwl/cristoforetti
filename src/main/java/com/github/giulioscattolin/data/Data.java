package com.github.giulioscattolin.data;

public interface Data {
    void accept(DataVisitor visitor);
}
