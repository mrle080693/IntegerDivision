package com.foxminded.integerdivision.processors;

public class DivisionProcessor {
    public String process(Integer dividend, Integer divider) {
        String result = "";
        try {
            String header = getHeader(dividend, divider);
            String body = getBody(dividend, divider);

            result = header + body;
        } catch (Exception e) {
            result = getExceptionMessage();
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
        String secondLine = getInputXTimes("-", separatorsAmountForSecondLine);
        String thirdLine = " " + getInputXTimes("*", dividendAsString.length()) + "|" + divisionResult;

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
        int amountSeparators;
        StringBuilder body = new StringBuilder();

        if (Math.abs(dividend) >= Math.abs(divider)) {
            for (int i = 0; !absDividendAsString.equals(""); i++) {
                if (Integer.valueOf(absDividendAsString) < divider) {
                    absDividendAsString = "";
                }
                String biggerThanDivider = getBiggerThanDivider(absDividendAsString, absDividerAsString);
                String biggerThanDividerWithoutResidue = getBiggerThanDividerWithoutResidue(divider, biggerThanDivider);
                String residue = getResidue(biggerThanDivider, biggerThanDividerWithoutResidue);
                absDividendAsString = rewriteAbsDividendAsString(absDividendAsString, residue, biggerThanDivider);

                if (!biggerThanDivider.equals("0")) {
                    amountSeparators = dividendAsString.length() - absDividendAsString.length() - 3;
                    body.append(getInputXTimes(" ", amountSeparators)).append("_").append(biggerThanDivider).append("\n");
                    body.append(getInputXTimes(" ", amountSeparators)).append(" ").append(biggerThanDividerWithoutResidue).append("\n");
                }
            }
        }

        amountSeparators = dividendAsString.length() - finalResidue.length();
        body.append(getInputXTimes(" ", amountSeparators)).append(finalResidue);

        return body.toString();
    }

    private String getInputXTimes(String input, int amount) {
        String result = "";

        for (int i = 1; i <= amount; i++) {
            result = result + input;
        }
        return result;
    }

    private String getBiggerThanDivider(String absDividendAsString, String absDividerAsString) {
        String biggerThanDivider = "0";
        if (absDividendAsString.length() >= absDividerAsString.length()) {
            biggerThanDivider = absDividendAsString.substring(0, absDividerAsString.length());
        }
        if (Integer.valueOf(biggerThanDivider) < Integer.valueOf(absDividerAsString) &&
                absDividerAsString.length() < absDividendAsString.length()) {
            biggerThanDivider = absDividendAsString.substring(0, absDividerAsString.length() + 1);
        }
        return biggerThanDivider;
    }

    private String getBiggerThanDividerWithoutResidue(int divider, String chosenNumber) {
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

    public String getExceptionMessage() {
        String message = "Somthing Wrong!!!" + "\n" +
                "1) Divider must not to be 0" + "\n" +
                "2) Input must not be null" + "\n" +
                "3) Input have to be in the range of int" + "\n" +
                "4) Input must not be a letter";

        return message;
    }
}
