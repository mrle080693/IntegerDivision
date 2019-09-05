package com.foxminded.integerdivision;

import com.foxminded.integerdivision.processors.DivisionProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDivisionProcessor {
    private DivisionProcessor divisionProcessor = new DivisionProcessor();
    private LinkedList<String> expected;
    private LinkedList<String> actual;

    @Test
    void processMustReturnNullPointerExceptionWhenInputIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            divisionProcessor.process(null, 2);
        });
    }

    @Test
    void processMustReturnArithmeticExceptionWhenDividerIsZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            divisionProcessor.process(2, 0);
        });
    }

    @Test
    void processMustReturnCorrectResult() {
        expected = new LinkedList<>();
        expected.add(" 22|2");
        expected.add("-----");
        expected.add("**|11");
        expected.add("_2");
        expected.add(" 2");
        expected.add("_2");
        expected.add(" 2");
        expected.add(" 0");
        actual = divisionProcessor.process(22, 2);
        assertEquals(expected, actual);

    }
}
