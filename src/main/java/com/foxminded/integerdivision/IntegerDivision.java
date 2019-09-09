package com.foxminded.integerdivision;

import com.foxminded.integerdivision.processors.DivisionProcessor;

public class IntegerDivision {
    public static void main(String[] args) {
        DivisionProcessor divisionProcessor = new DivisionProcessor();
        System.out.println(divisionProcessor.process(3, 3));
    }
}

