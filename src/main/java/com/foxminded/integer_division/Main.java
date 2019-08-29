package com.foxminded.integer_division;

import com.foxminded.integer_division.processors.DrawDivisionProcessor;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private DrawDivisionProcessor drawDivisionProcessor = new DrawDivisionProcessor();

    public static void main(String[] args) {
        Main main = new Main();
        main.process();
    }

    private void process(){
        try {
            System.out.println("Enter the dividend please");
            int dividend = scanner.nextInt();

            System.out.println("Enter the divider please");
            int divider = scanner.nextInt();

            drawDivisionProcessor.process(dividend, divider);
            getExitOrRestartChoice();
        } catch (Exception e){
            getWrongInputMessage();
            getExitOrRestartChoice();
        }
    }

    private void getWrongInputMessage(){
        System.err.println("    SOMETHING WRONG !!!");
        System.err.println("1) Input have to be a number");
        System.err.println("2) Input must not be a fraction");
        System.err.println("3) Input must not be a zero");
        System.err.println("4) Input must be from -2147483648 till 2147483647");
    }

    private void getExitOrRestartChoice(){
        System.out.println("Restart - 1");
        System.out.println("Exit    - Something else");

        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("1")){
            process();
        }
    }

}
