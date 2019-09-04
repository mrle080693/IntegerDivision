package com.foxminded.integerdivision;

import com.foxminded.integerdivision.processors.DrawingProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestDrawingProcessor {
    private DrawingProcessor drawingProcessor = new DrawingProcessor();

    @Test
    void processMustReturnArithmeticExceptionWhenDividerIsZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            drawingProcessor.process(2, 0);
        });
    }
}

