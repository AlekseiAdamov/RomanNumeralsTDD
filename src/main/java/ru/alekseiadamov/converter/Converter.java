package ru.alekseiadamov.converter;

import java.util.HashMap;

/**
 * An exercise in TDD: https://codingdojo.org/kata/RomanNumerals/
 */
public class Converter {

    private Converter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Converts given integer to roman numeral.
     *
     * @param number Integer to convert.
     * @return Roman numeral for the specified integer.
     */
    public static String convert(int number) {
        if (number == 0) {
            return "Cannot convert number 0";
        }

        StringBuilder sb = new StringBuilder();

        int thousands = thousands(number);
        if (thousands > 0) {
            sb.append("M".repeat(thousands));
        }

        final HashMap<Integer, HashMap<Integer, String>> numerals = getNumerals();

        int hundreds = hundreds(number);
        appendNumeral(sb, hundreds, numerals.get(100));

        int tens = tens(number);
        appendNumeral(sb, tens, numerals.get(10));

        int ones = ones(number);
        appendNumeral(sb, ones, numerals.get(1));

        return sb.toString();
    }

    private static HashMap<Integer, HashMap<Integer, String>> getNumerals() {
        HashMap<Integer, String> oneNumerals = new HashMap<>();
        oneNumerals.put(1, "I");
        oneNumerals.put(5, "V");
        oneNumerals.put(10, "X");

        HashMap<Integer, String> tenNumerals = new HashMap<>();
        tenNumerals.put(1, "X");
        tenNumerals.put(5, "L");
        tenNumerals.put(10, "C");

        HashMap<Integer, String> hundredNumerals = new HashMap<>();
        hundredNumerals.put(1, "C");
        hundredNumerals.put(5, "D");
        hundredNumerals.put(10, "M");

        HashMap<Integer, HashMap<Integer, String>> numerals = new HashMap<>();
        numerals.put(1, oneNumerals);
        numerals.put(10, tenNumerals);
        numerals.put(100, hundredNumerals);

        return numerals;
    }

    private static void appendNumeral(StringBuilder sb, int number, HashMap<Integer, String> numerals) {

        String oneNumeral = numerals.get(1);
        String fiveNumeral = numerals.get(5);
        String tenNumeral = numerals.get(10);

        String numeral;
        if (number > 0) {
            if (number == 5) {
                numeral = fiveNumeral;
            } else if (number == 4) {
                numeral = oneNumeral + fiveNumeral;
            } else if (number < 4) {
                numeral = oneNumeral.repeat(number);
            } else if (number == 9) {
                numeral = oneNumeral + tenNumeral;
            } else {
                numeral = fiveNumeral + oneNumeral.repeat(number - 5);
            }
            sb.append(numeral);
        }
    }

    public static int ones(int number) {
        return Integer.signum(number) * (number % 10);
    }

    public static int tens(int number) {
        return Integer.signum(number) * ((number % 100) / 10);
    }

    public static int hundreds(int number) {
        return Integer.signum(number) * ((number % 1000) / 100);
    }

    public static int thousands(int number) {
        return Integer.signum(number) * ((number % 100000) / 1000);
    }
}
