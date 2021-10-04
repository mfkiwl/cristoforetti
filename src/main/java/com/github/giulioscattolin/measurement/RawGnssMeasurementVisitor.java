package com.github.giulioscattolin.measurement;

import com.github.giulioscattolin.data.Data;
import com.github.giulioscattolin.data.DataVisitor;

public interface RawGnssMeasurementVisitor extends DataVisitor {
    void visit(RawGnssMeasurement rawGnssMeasurement);
}
