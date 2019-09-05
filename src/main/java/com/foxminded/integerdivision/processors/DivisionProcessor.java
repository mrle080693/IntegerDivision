package com.foxminded.integerdivision.processors;

import java.util.LinkedList;

public class DivisionProcessor {
    public LinkedList<String> process(Integer dividend, Integer divider) {
        LinkedList<String> header = getHeader(dividend, divider);

        LinkedList<String> result = getBody(header, dividend, divider);

        return result;
    }

    private LinkedList<String> getHeader(int dividend, int divider) {
        String dividendAsString = String.valueOf(dividend);
        String dividerAsString = String.valueOf(divider);
        String divisionResult = String.valueOf(dividend / divider);
        LinkedList<String> header = new LinkedList<>();

        String firstLine = " " + dividendAsString + "|" + dividerAsString;
        String thirdLine = returnInput("*", dividendAsString.length()) + "|" + divisionResult;
        String secondLine = returnInput("-", thirdLine.length());

        header.add(firstLine);
        header.add(secondLine);
        header.add(thirdLine);

        return header;
    }

    private LinkedList<String> getBody(LinkedList<String> header, int dividend, int divider) {
        String dividendAsString = String.valueOf(dividend);
        String dividerAsString = String.valueOf(divider);
        String absDividendAsString = String.valueOf(Math.abs(dividend));
        String absDividerAsString = String.valueOf(Math.abs(divider));
        String finalResidue = String.valueOf(dividend % divider);
        int amountSeparators = 0;
        LinkedList<String> result = header;

        if (Math.abs(dividend) >= Math.abs(divider)) {
            for (int i = 0; !absDividendAsString.equals(""); i++) {
                String chosenNumber = getChosenNumber(absDividendAsString, absDividerAsString);
                String chosenNumberWithoutResidue = getChosenNumberWithoutResidue(divider, chosenNumber);
                String residue = getResidue(chosenNumber, chosenNumberWithoutResidue);
                absDividendAsString = rewriteAbsDividendAsString(absDividendAsString, residue, chosenNumber);

                if (!chosenNumber.equals("0")) {
                    amountSeparators = dividendAsString.length() - absDividendAsString.length() - 2;
                    result.add(returnInput(" ", amountSeparators) + "_" + chosenNumber);
                    result.add(returnInput(" ", amountSeparators) + " " + chosenNumberWithoutResidue);
                }
            }
        }

        amountSeparators = dividendAsString.length() - finalResidue.length();
        result.add(returnInput(" ", amountSeparators) + finalResidue);

        return result;
    }

    private String returnInput(String input, int amount) {
        String result = "";

        for (int i = 1; i <= amount; i++) {
            result = result + input;
        }
        return result;
    }

    private String getChosenNumber(String absDividendAsString, String absDividerAsString) {
        String chosenNumber = "0";
        if (absDividendAsString.length() >= absDividerAsString.length()) {
            chosenNumber = absDividendAsString.substring(0, absDividerAsString.length());
        }
        if (Integer.valueOf(chosenNumber) < Integer.valueOf(absDividerAsString) &&
                absDividerAsString.length() < absDividendAsString.length()) {
            chosenNumber = absDividendAsString.substring(0, absDividerAsString.length() + 1);
        }
        return chosenNumber;
    }

    private String getChosenNumberWithoutResidue(int divider, String chosenNumber) {
        return String.valueOf(Integer.valueOf(chosenNumber) / divider * divider);
    }

    private String getResidue(String chosenNumber, String chosenNumberWithoutResidue) {
        String residue = String.valueOf(Integer.valueOf(chosenNumber) - Integer.valueOf(chosenNumberWithoutResidue));
        if (residue.equals("0")) {
            residue = "";
        }
        return residue;
    }

    private String rewriteAbsDividendAsString(String absDividendAsString, String residue, String chosenNumber) {
        String result = residue + absDividendAsString.substring(chosenNumber.length());
        return result;
    }
}
