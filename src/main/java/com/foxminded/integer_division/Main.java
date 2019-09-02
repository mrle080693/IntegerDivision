package com.foxminded.integer_division;

import com.foxminded.integer_division.processors.DrawDivisionProcessor;
import com.foxminded.integer_division.processors.TestingProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the dividend");
            int dividend = scanner.nextInt();
            System.out.println("Enter the divider");
            int divider = scanner.nextInt();

            //DrawDivisionProcessor drawDivisionProcessor = new DrawDivisionProcessor();
            //drawDivisionProcessor.process(dividend, divider);
            TestingProcessor testingProcessor = new TestingProcessor();
            testingProcessor.process(dividend, divider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
