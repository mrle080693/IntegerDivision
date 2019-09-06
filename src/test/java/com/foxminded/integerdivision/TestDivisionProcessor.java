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

    @Test
    void processMustReturnCorrectResultWhenDividendIsBig() {
        expected = new LinkedList<>();
        expected.add(" 9999999|9");
        expected.add("---------------");
        expected.add("*******|1111111");
        expected.add("_9");
        expected.add(" 9");
        expected.add("_9");
        expected.add(" 9");
        expected.add(" _9");
        expected.add("  9");
        expected.add("  _9");
        expected.add("   9");
        expected.add("   _9");
        expected.add("    9");
        expected.add("    _9");
        expected.add("     9");
        expected.add("     _9");
        expected.add("      9");
        expected.add("      0");
        actual = divisionProcessor.process(9999999, 9);
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendIsLessThanDivider() {
        expected = new LinkedList<>();
        expected.add(" 2|3");
        expected.add("---");
        expected.add("*|0");
        expected.add("2");
        actual = divisionProcessor.process(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendIsLessThanZero() {
        expected = new LinkedList<>();
        expected.add(" -6|3");
        expected.add("-----");
        expected.add("**|-2");
        expected.add("_6");
        expected.add(" 6");
        expected.add(" 0");
        actual = divisionProcessor.process(-6, 3);
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendAndDividerAreLessThanZero() {
        expected = new LinkedList<>();
        expected.add(" -6|-3");
        expected.add("----");
        expected.add("**|2");
        expected.add("_6");
        expected.add(" 6");
        expected.add(" 0");
        actual = divisionProcessor.process(-6, -3);
        assertEquals(expected, actual);
    }
}
