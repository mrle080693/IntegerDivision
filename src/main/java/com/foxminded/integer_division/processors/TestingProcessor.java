package com.foxminded.integer_division.processors;

public class TestingProcessor {
    public void process(int dividend, int divider){
        int result = dividend / divider;
        int finalResidue = dividend % divider;

        drawHeader(dividend, divider, result);
    }

    private void drawHeader(int dividend, int divider, int result){
        System.out.println(dividend + " | " + divider);

        int separatorsAmountForSecondLine = String.valueOf(dividend).length() + String.valueOf(divider).length() + 3;


        int separatorsAmountForThirdLine = String.valueOf(dividend).length() + 1;
        System.out.println("result equals |" + result);

    }

    private void drawBody(){}

    private void drawStep(int dividend, int divider){

    }

    private String drawInput(String input, int amount){
        String result = "";

        for (int i = 1; i <= amount; i++){
            result = result + input;
        }
        return result;
    }
}
