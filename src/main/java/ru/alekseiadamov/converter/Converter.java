package ru.alekseiadamov.converter;

import java.util.HashMap;

/**
 * An exercise in TDD: <a href="https://codingdojo.org/kata/RomanNumerals/">https://codingdojo.org/kata/RomanNumerals/</a>
 */
public class Converter {

    private final HashMap<Integer, HashMap<Integer, String>> numerals;

    public Converter() {
        numerals = getNumerals();
    }

    /**
     * Converts given integer to Roman numeral.
     *
     * @param number Integer to convert.
     * @return Roman numeral for the specified integer.
     */
    public String convert(int number) {
        if (number == 0) {
            return "Cannot convert number 0";
        }
        return getRomanNumeral(number);
    }

    private String getRomanNumeral(int number) {
        return getThousandsNumeral(number) +
                getHundredsNumeral(number) +
                getTensNumeral(number) +
                getOnesNumeral(number);
    }

    private HashMap<Integer, HashMap<Integer, String>> getNumerals() {
        HashMap<Integer, HashMap<Integer, String>> map = new HashMap<>();
        map.put(1, getOnesNumeralMap());
        map.put(10, getTensNumeralMap());
        map.put(100, getHundredsNumeralMap());
        return map;
    }

    private HashMap<Integer, String> getOnesNumeralMap() {
        HashMap<Integer, String> oneNumerals = new HashMap<>();
        oneNumerals.put(1, "I");
        oneNumerals.put(5, "V");
        oneNumerals.put(10, "X");
        return oneNumerals;
    }

    private HashMap<Integer, String> getTensNumeralMap() {
        HashMap<Integer, String> tenNumerals = new HashMap<>();
        tenNumerals.put(1, "X");
        tenNumerals.put(5, "L");
        tenNumerals.put(10, "C");
        return tenNumerals;
    }

    private HashMap<Integer, String> getHundredsNumeralMap() {
        HashMap<Integer, String> hundredNumerals = new HashMap<>();
        hundredNumerals.put(1, "C");
        hundredNumerals.put(5, "D");
        hundredNumerals.put(10, "M");
        return hundredNumerals;
    }

    private String getThousandsNumeral(int number) {
        int thousands = getThousands(number);
        if (thousands > 0) {
            return "M".repeat(thousands);
        }
        return "";
    }

    private String getHundredsNumeral(int number) {
        int hundreds = getHundreds(number);
        return getNumeral(hundreds, numerals.get(100));
    }

    private String getTensNumeral(int number) {
        int tens = getTens(number);
        return getNumeral(tens, numerals.get(10));
    }

    private String getOnesNumeral(int number) {
        int ones = getOnes(number);
        return getNumeral(ones, numerals.get(1));
    }

    private String getNumeral(int number, HashMap<Integer, String> numerals) {

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
            return numeral;
        }
        return "";
    }

    private int getOnes(int number) {
        return Integer.signum(number) * (number % 10);
    }

    private int getTens(int number) {
        return Integer.signum(number) * ((number % 100) / 10);
    }

    private int getHundreds(int number) {
        return Integer.signum(number) * ((number % 1000) / 100);
    }

    private int getThousands(int number) {
        return Integer.signum(number) * ((number % 100000) / 1000);
    }
}
