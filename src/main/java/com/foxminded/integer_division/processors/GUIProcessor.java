package com.foxminded.integer_division.processors;
import java.util.Scanner;

public class GUIProcessor {
    private int dividend ;
    private int divider;
    private Scanner scanner = new Scanner(System.in);
    private IntegerDivisionProcessor integerDivisionProcessor = new IntegerDivisionProcessor();

    public void process(){
        getDataFromUser();
        integerDivisionProcessor.process(dividend, divider);
        getExitOrRestartChoice();
    }

    private void getDataFromUser(){
        try {
            System.out.println("Enter the dividend please");
            dividend = scanner.nextInt();

            System.out.println("Enter the divider please");
            divider = scanner.nextInt();

            if(dividend == 0 || divider == 0){
                getWrongInputMessage();
            }
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
    }

    private void getExitOrRestartChoice(){
        System.out.println("Restart - 1");
        System.out.println("Exit    - Something else");

        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("1")){
            getDataFromUser();
        }
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }


}
