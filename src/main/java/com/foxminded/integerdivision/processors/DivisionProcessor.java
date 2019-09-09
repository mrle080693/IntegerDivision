package com.foxminded.integerdivision.processors;

public class DivisionProcessor {

    public String process(Integer dividend, Integer divider) {
        String result = null;
        try {
            String header = getHeader(dividend, divider);
            String body = getBody(dividend, divider);

            result = header + body;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Divider can not be zero!");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input have to be Integer!");
        } catch (NullPointerException e) {
            result = null;
        }

        return result;
    }

    private String getHeader(int dividend, int divider) {
        String dividendAsString = String.valueOf(dividend);
        String dividerAsString = String.valueOf(divider);
        String divisionResult = String.valueOf(dividend / divider);
        StringBuilder header = new StringBuilder();

        String firstLine = " " + dividendAsString + "|" + dividerAsString;
        int separatorsAmountForSecondLine = dividendAsString.length() + String.valueOf(dividend / divider).length() + 1;
        String secondLine = getMultipleInput("-", separatorsAmountForSecondLine);
        String thirdLine = " " + getMultipleInput("*", dividendAsString.length()) + "|" + divisionResult;

        header.append(firstLine).append("\n");
        header.append(secondLine).append("\n");
        header.append(thirdLine).append("\n");

        return header.toString();
    }

    private String getBody(int dividend, int divider) {
        String dividendAsString = String.valueOf(dividend);
        String absDividendAsString = String.valueOf(Math.abs(dividend));
        String absDividerAsString = String.valueOf(Math.abs(divider));
        String finalResidue = String.valueOf(dividend % divider);
        int amount;
        StringBuilder body = new StringBuilder();

        if (Math.abs(dividend) >= Math.abs(divider)) {
            for (int i = 0; !absDividendAsString.equals(""); i++) {
                if (Integer.valueOf(absDividendAsString) < divider) {
                    absDividendAsString = "";
                }
                String incompletePrivate = getIncompletePrivate(absDividendAsString, absDividerAsString);
                String nearToIncompletePrivate = getNearToIncompletePrivate(divider, incompletePrivate);
                String residue = getResidue(incompletePrivate, nearToIncompletePrivate);
                absDividendAsString = rewriteAbsDividendAsString(absDividendAsString, residue, incompletePrivate);

                if (!incompletePrivate.equals("0")) {
                    amount = dividendAsString.length() - absDividendAsString.length() - 3;
                    body.append(getMultipleInput(" ", amount)).append("_").append(incompletePrivate).append("\n");
                    body.append(getMultipleInput(" ", amount)).append(" ").append(nearToIncompletePrivate).append("\n");
                }
            }
        }

        amount = dividendAsString.length() - finalResidue.length();
        body.append(getMultipleInput(" ", amount)).append(finalResidue);

        return body.toString();
    }

    private String getMultipleInput(String input, int amount) {
        String result = "";

        for (int i = 1; i <= amount; i++) {
            result = result + input;
        }
        return result;
    }

    private String getIncompletePrivate(String absDividendAsString, String absDividerAsString) {
        String incompletePrivate = "0";
        if (absDividendAsString.length() >= absDividerAsString.length()) {
            incompletePrivate = absDividendAsString.substring(0, absDividerAsString.length());
        }
        if (Integer.valueOf(incompletePrivate) < Integer.valueOf(absDividerAsString) &&
                absDividerAsString.length() < absDividendAsString.length()) {
            incompletePrivate = absDividendAsString.substring(0, absDividerAsString.length() + 1);
        }
        return incompletePrivate;
    }

    private String getNearToIncompletePrivate(int divider, String chosenNumber) {
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
        String result = residue + absDividendAsString;
        if (absDividendAsString.length() >= chosenNumber.length()) {
            result = residue + absDividendAsString.substring(chosenNumber.length());
        }
        return result;
    }
}
