package com.github.giulioscattolin.data;

public interface DataSource {
    void accept(DataSourceVisitor visitor);
}
