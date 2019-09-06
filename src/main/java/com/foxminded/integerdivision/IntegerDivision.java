package com.foxminded.integerdivision;

import com.foxminded.integerdivision.processors.DivisionProcessor;

import java.util.LinkedList;

public class IntegerDivision {
    public static void main(String[] args) {
        DivisionProcessor divisionProcessor = new DivisionProcessor();
        LinkedList<String> result = divisionProcessor.process(696, 3);
        for (int i = 0; i <= result.size() - 1; i++) {
            System.out.println(result.get(i));
        }
    }
}

