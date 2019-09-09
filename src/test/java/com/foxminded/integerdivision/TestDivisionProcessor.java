package com.foxminded.integerdivision;

import com.foxminded.integerdivision.processors.DivisionProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestDivisionProcessor {
    private DivisionProcessor divisionProcessor = new DivisionProcessor();

    @Test
    void processMustReturnNullIfInputIsNull() {
        assertNull(divisionProcessor.process(1, null));
    }

    @Test
    void processMustReturnIllegalArgumentExceptionWhenDividerIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            divisionProcessor.process(2, 0);
        });
    }

    @Test
    void processMustReturnNumberFormatExceptionWhenInputIsLetter() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            divisionProcessor.process(Integer.valueOf("asd"), 2);
        });
    }

    @Test
    void processMustReturnCorrectResult() {
        String expected = " 9|3\n" +
                "---\n" +
                " *|3\n" +
                "_9\n" +
                " 9\n" +
                "0";
        String actual = divisionProcessor.process(9, 3);

        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendIsLessThanDivider() {
        String expected = " 1|2\n" +
                "---\n" +
                " *|0\n" +
                "1";
        String actual = divisionProcessor.process(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendIsBig() {
        String expected = " 1231231231|2\n" +
                "--------------------\n" +
                " **********|615615615\n" +
                "_12\n" +
                " 12\n" +
                "_3\n" +
                " 2\n" +
                "_11\n" +
                " 10\n" +
                "  _12\n" +
                "   12\n" +
                "  _3\n" +
                "   2\n" +
                "   _11\n" +
                "    10\n" +
                "     _12\n" +
                "      12\n" +
                "     _3\n" +
                "      2\n" +
                "      _11\n" +
                "       10\n" +
                "         1";
        String actual = divisionProcessor.process(1231231231, 2);

        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendIsLessThanZero() {
        String expected = " -99999|3\n" +
                "-------------\n" +
                " ******|-33333\n" +
                "_9\n" +
                " 9\n" +
                "_9\n" +
                " 9\n" +
                " _9\n" +
                "  9\n" +
                "  _9\n" +
                "   9\n" +
                "   _9\n" +
                "    9\n" +
                "     0";
        String actual = divisionProcessor.process(-99999, 3);

        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenDividendAndDividerAreLessThanZero() {
        String expected = " -7897789|-234\n" +
                "--------------\n" +
                " ********|33751\n" +
                "_789\n" +
                " 702\n" +
                "_877\n" +
                " 702\n" +
                "_1757\n" +
                " 1638\n" +
                "  _1198\n" +
                "   1170\n" +
                "   _289\n" +
                "    234\n" +
                "     -55";
        String actual = divisionProcessor.process(-7897789, -234);

        assertEquals(expected, actual);
    }
}
