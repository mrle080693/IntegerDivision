package com.foxminded.integer_division.processors;

public class DrawingProcessor {
    public void process(int dividend, int divider){
        int result = dividend / divider;
        int finalResidue = dividend % divider;
        String dividendAsString = String.valueOf(Math.abs(dividend));
        String dividerAsString = String.valueOf(Math.abs(divider));
        if(Math.abs(dividend) < Math.abs(divider)){
            drawAll(dividend, divider, result, finalResidue);
        } else {
            String chosenNumber = getChosenNumber(dividendAsString, dividerAsString);
            String chosenNumberWithoutResidue = getChosenNumberWithoutResidue(dividerAsString, chosenNumber);
            String residue = getResidue(chosenNumber, chosenNumberWithoutResidue);
            drawHeader(dividend, divider, result, chosenNumberWithoutResidue);
            dividendAsString = rewriteDividendAsString(dividendAsString, residue, chosenNumber);
            drawBody(dividendAsString, dividerAsString, finalResidue);
        }
    }

    private void drawHeader(int dividend, int divider, int result, String chosenNumberWithoutResidue){
        System.out.println("_" + dividend + "|" + divider);
        int amount = String.valueOf(dividend).length() - chosenNumberWithoutResidue.length();
        int amount2 = String.valueOf(result).length();
        if(dividend > 0) {
            System.out.println(" " + chosenNumberWithoutResidue + drawInput(" ", amount) + "|" + drawInput("-", amount2));
            amount = chosenNumberWithoutResidue.length();
            amount2 = String.valueOf(dividend).length() - amount;
            System.out.println(" " + drawInput("-", amount) + drawInput(" ", amount2) + "|" + result);
        } else {
            System.out.println("  " + chosenNumberWithoutResidue + drawInput(" ", amount -1) + "|" + drawInput("-", amount2));
            amount = chosenNumberWithoutResidue.length();
            amount2 = String.valueOf(dividend).length() - amount;
            System.out.println("  " + drawInput("-", amount) + drawInput(" ", amount2 - 1) + "|" + result);
        }
    }

    private void drawBody(String dividendAsString, String dividerAsString, int finalResidue){
        String localDividend = dividendAsString;
        String residue = "";
        int amount = dividendAsString.length() - localDividend.length() + 1;
        for(int i = 0; !localDividend.equals(""); i++) {
            String chosenNumber = getChosenNumber(localDividend, dividerAsString);
            String chosenNumberWithoutResidue = getChosenNumberWithoutResidue(dividerAsString, chosenNumber);
            residue = getResidue(chosenNumber, chosenNumberWithoutResidue);

            if(!chosenNumber.equals("0") && !chosenNumberWithoutResidue.equals("0")) {
                System.out.println(drawInput(" ", amount) + "_" + chosenNumber);
                System.out.println(drawInput(" ", amount + 1) + chosenNumberWithoutResidue);
                System.out.println(drawInput(" ", amount + 1) + drawInput("-", chosenNumberWithoutResidue.length()));
            }
            localDividend = rewriteDividendAsString(localDividend, residue, chosenNumber);

            if(chosenNumberWithoutResidue.equals("0")){
                localDividend = "";
            }
        }
        System.out.println(drawInput(" ", amount + 1) + finalResidue);
    }

    private void drawAll(int dividend, int divider, int result, int finalResidue){
        System.out.println("_" + dividend + "|" + divider);
        if(Math.abs(dividend) < Math.abs(divider)){
            int amount = String.valueOf(dividend).length() - 1;
            int amount2 = String.valueOf(result).length();
            System.out.println(" 0" + drawInput(" ", amount) + "|" + drawInput("-", amount2));
            System.out.println(" -" + drawInput(" ", amount) + "|" + result);
            System.out.println(" " + dividend);
        }

    }

    private String getChosenNumber(String dividendAsString, String dividerAsString){
        String chosenNumber = "0";
        if(dividendAsString.length() >= dividerAsString.length()) {
            chosenNumber = dividendAsString.substring(0, dividerAsString.length());
        }
        if (Integer.valueOf(chosenNumber) < Integer.valueOf(dividerAsString) &&
                dividerAsString.length() < dividendAsString.length()) {
            chosenNumber = dividendAsString.substring(0, dividerAsString.length() + 1);
        }
        return chosenNumber;
    }

    private String getChosenNumberWithoutResidue(String dividerAsString, String chosenNumber){
        return String.valueOf(Integer.valueOf(chosenNumber) / Integer.valueOf(dividerAsString) *
                Integer.valueOf(dividerAsString));
    }

    private String getResidue(String chosenNumber, String chosenNumberWithoutResidue){
        String residue = String.valueOf(Integer.valueOf(chosenNumber) - Integer.valueOf(chosenNumberWithoutResidue));
        if(residue.equals("0")){
            residue = "";
        }
        return residue;
    }

    private String rewriteDividendAsString(String dividendAsString ,String residue, String chosenNumber){
        String result = residue + dividendAsString.substring(chosenNumber.length());
        return result;
    }

    private String drawInput(String input, int amount){
        String result = "";

        for (int i = 1; i <= amount; i++){
            result = result + input;
        }
        return result;
    }
}
