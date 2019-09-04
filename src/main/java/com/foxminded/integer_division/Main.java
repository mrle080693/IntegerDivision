package com.foxminded.integer_division;

import com.foxminded.integer_division.processors.DrawingProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the dividend");
            int dividend = scanner.nextInt();
            System.out.println("Enter the divider");
            int divider = scanner.nextInt();

            DrawingProcessor drawingProcessor = new DrawingProcessor();
            drawingProcessor.process(dividend, divider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
