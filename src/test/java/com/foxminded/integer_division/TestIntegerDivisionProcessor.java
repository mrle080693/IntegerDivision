package com.foxminded.integer_division;

import com.foxminded.integer_division.processors.DrawDivisionProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestIntegerDivisionProcessor {
    private DrawDivisionProcessor drawDivisionProcessor = new DrawDivisionProcessor();
    private int expected;
    private int actual;

    @Test
    void resultHaveToBe3WhenDividendIs9AndDividerIs3(){
        drawDivisionProcessor.process(3, 0);
        expected = 0;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe0WhenDividendIs9AndDividerIs3(){
        drawDivisionProcessor.process(9, 3);
        expected = 0;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBeMinus3WhenDividendIsMinus9AndDividerIs3(){
        drawDivisionProcessor.process(-9, 3);
        expected = -3;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe0WhenDividendIsMinus9AndDividerIs3(){
        drawDivisionProcessor.process(-9, 3);
        expected = 0;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBeMinus3WhenDividendIs9AndDividerIsMinus3(){
        drawDivisionProcessor.process(9, -3);
        expected = -3;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe0WhenDividendIs9AndDividerIsMinus3(){
        drawDivisionProcessor.process(9, -3);
        expected = 0;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBe3WhenDividendIsMinus9AndDividerIsMinus3(){
        drawDivisionProcessor.process(-9, -3);
        expected = 3;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe0WhenDividendIsMinus9AndDividerIsMinus3(){
        drawDivisionProcessor.process(-9, -3);
        expected = 0;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBe3WhenDividendIs10AndDividerIs3(){
        drawDivisionProcessor.process(10, 3);
        expected = 3;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe1WhenDividendIs10AndDividerIs3(){
        drawDivisionProcessor.process(10, 3);
        expected = 1;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBe1001001WhenDividendIs987987987AndDividerIs987(){
        drawDivisionProcessor.process(987987987, 987);
        expected = 1001001;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe0WhenDividendIs987987987AndDividerIs987(){
        drawDivisionProcessor.process(987987987, 987);
        expected = 0;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }

    @Test
    void resultHaveToBe1001001WhenDividendIs987987989AndDividerIs987(){
        drawDivisionProcessor.process(987987989, 987);
        expected = 1001001;
        actual = drawDivisionProcessor.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void residueHaveToBe2WhenDividendIs987987989AndDividerIs987(){
        drawDivisionProcessor.process(987987989, 987);
        expected = 2;
        actual = drawDivisionProcessor.getFinalResidue();
        assertEquals(expected, actual);
    }
}
