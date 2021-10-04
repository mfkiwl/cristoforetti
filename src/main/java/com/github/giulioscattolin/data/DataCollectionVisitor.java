package com.github.giulioscattolin.data;

public interface DataCollectionVisitor extends DataVisitor {
    void visit(DataCollection dataCollection);
}
