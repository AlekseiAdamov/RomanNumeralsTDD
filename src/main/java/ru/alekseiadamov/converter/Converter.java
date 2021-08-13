package ru.alekseiadamov.converter;

import java.util.HashMap;

/**
 * An exercise in TDD: <a href="https://codingdojo.org/kata/RomanNumerals/">https://codingdojo.org/kata/RomanNumerals/</a>
 */
public class Converter {

    private StringBuilder numeralBuilder;
    private final HashMap<Integer, HashMap<Integer, String>> numerals;

    public Converter() {
        numerals = getNumerals();
    }

    /**
     * Converts given integer to roman numeral.
     *
     * @param number Integer to convert.
     * @return Roman numeral for the specified integer.
     */
    public String convert(int number) {
        if (number == 0) {
            return "Cannot convert number 0";
        }

        numeralBuilder = new StringBuilder();

        appendThousands(number);
        appendHundreds(number);
        appendTens(number);
        appendOnes(number);

        return numeralBuilder.toString();
    }

    private HashMap<Integer, HashMap<Integer, String>> getNumerals() {
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

        HashMap<Integer, HashMap<Integer, String>> map = new HashMap<>();
        map.put(1, oneNumerals);
        map.put(10, tenNumerals);
        map.put(100, hundredNumerals);

        return map;
    }

    private void appendThousands(int number) {
        int thousands = thousands(number);
        if (thousands > 0) {
            numeralBuilder.append("M".repeat(thousands));
        }
    }

    private void appendHundreds(int number) {
        int hundreds = hundreds(number);
        appendNumeral(hundreds, numerals.get(100));
    }

    private void appendTens(int number) {
        int tens = tens(number);
        appendNumeral(tens, numerals.get(10));
    }

    private void appendOnes(int number) {
        int ones = ones(number);
        appendNumeral(ones, numerals.get(1));
    }

    private void appendNumeral(int number, HashMap<Integer, String> numerals) {

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
            numeralBuilder.append(numeral);
        }
    }

    private int ones(int number) {
        return Integer.signum(number) * (number % 10);
    }

    private int tens(int number) {
        return Integer.signum(number) * ((number % 100) / 10);
    }

    private int hundreds(int number) {
        return Integer.signum(number) * ((number % 1000) / 100);
    }

    private int thousands(int number) {
        return Integer.signum(number) * ((number % 100000) / 1000);
    }
}
