package com.foxminded.integer_division.processors;

public class DrawDivisionProcessor {
    private int dividend;
    private int divider;
    private String dividendAsString = "";
    private String dividerAsString = "";
    private String chosenNumber = "";
    private String chosenNumberWithoutResidue = "";
    private int howMuchSeparators = 1;
    private int result;
    private int finalResidue;

    public void process(int dividend, int divider){
        this.dividend = dividend;
        this.divider = divider;
        if (Math.abs(dividend) < Math.abs(divider)){
            drawFirstDivisionStep();
            finalResidue = dividend;
            System.out.println(" " + finalResidue);
        }

        else {
            result = dividend / divider;
            dividendAsString = String.valueOf(Math.abs(dividend));
            dividerAsString = String.valueOf(Math.abs(divider));
            finalResidue = dividend % divider;

            divisionStep();
            drawFirstDivisionStep();

            for (int i = 0; dividendAsString.length() > 0 && Integer.valueOf(dividendAsString) >
                    Integer.valueOf(dividerAsString); i++) {
                divisionStep();
                drawDivisionStep();
            }
            System.out.println(drawSeparators(howMuchSeparators + 1) + finalResidue);
        }
    }

    private void divisionStep(){
        chosenNumber = dividendAsString.substring(0, dividerAsString.length());
        if (Integer.valueOf(chosenNumber) < Integer.valueOf(dividerAsString)) {
            chosenNumber = dividendAsString.substring(0, dividerAsString.length() + 1);
        }
        chosenNumberWithoutResidue = String.valueOf(Integer.valueOf(chosenNumber) / Integer.valueOf(dividerAsString) *
                Integer.valueOf(dividerAsString));
        String residue = String.valueOf(Integer.valueOf(chosenNumber) - Integer.valueOf(chosenNumberWithoutResidue));

        if (residue.equals("0")) {
            residue = "";
        }

        dividendAsString = residue + dividendAsString.substring(chosenNumber.length());
    }

    private void drawFirstDivisionStep(){
        System.out.println("_" + dividend + " | " + divider);
        System.out.println(" " + chosenNumberWithoutResidue + drawSeparators(dividendAsString.length() -
                chosenNumberWithoutResidue.length()) +
                " |-----");
        System.out.println(" - " + drawSeparators(dividerAsString.length() - 1) + " | " + result);
    }

    private void drawDivisionStep(){
        howMuchSeparators = String.valueOf(dividend).length() - dividendAsString.length();
        System.out.println(drawSeparators(howMuchSeparators) + "_" + chosenNumber);
        System.out.println(drawSeparators(howMuchSeparators + 1) + chosenNumberWithoutResidue);
        System.out.println(drawSeparators(howMuchSeparators + 1) + "--");
    }

    private String drawSeparators(int separatorsQuantity){
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= separatorsQuantity; i++){
            result.append(" ");
        }
        return result.toString();
    }

    public int getResult() {
        return result;
    }

    public int getFinalResidue() {
        return finalResidue;
    }
}
