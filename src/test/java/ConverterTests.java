import org.junit.jupiter.api.Test;
import ru.alekseiadamov.converter.Converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTests {

    @Test
    void convertZero() {
        String roman = Converter.convert(0);
        assertEquals("Cannot convert number 0", roman);
    }

    @Test
    void onesThree() {
        int ones = Converter.ones(253);
        assertEquals(3, ones);
    }

    @Test
    void onesFive() {
        int ones = Converter.ones(255);
        assertEquals(5, ones);
    }

    @Test
    void onesSeven() {
        int ones = Converter.ones(25487);
        assertEquals(7, ones);
    }

    @Test
    void onesZero() {
        int ones = Converter.ones(20);
        assertEquals(0, ones);
    }

    @Test
    void onesMinusFive() {
        int ones = Converter.ones(-255);
        assertEquals(5, ones);
    }

    @Test
    void tensOne() {
        int tens = Converter.tens(315);
        assertEquals(1, tens);
    }

    @Test
    void tensThree() {
        int tens = Converter.tens(435);
        assertEquals(3, tens);
    }

    @Test
    void tensMinusFive() {
        int tens = Converter.tens(-256);
        assertEquals(5, tens);
    }

    @Test
    void tensZero() {
        int tens = Converter.tens(-206);
        assertEquals(0, tens);
    }

    @Test
    void hundredsTwo() {
        int hundreds = Converter.hundreds(1234);
        assertEquals(2, hundreds);
    }

    @Test
    void hundredsZero() {
        int hundreds = Converter.hundreds(1024);
        assertEquals(0, hundreds);
    }

    @Test
    void hundredsMinusNine() {
        int hundreds = Converter.hundreds(-1984);
        assertEquals(9, hundreds);
    }

    @Test
    void thousandsFour() {
        int thousands = Converter.thousands(4567);
        assertEquals(4, thousands);
    }

    @Test
    void thousandsEight() {
        int thousands = Converter.thousands(8000);
        assertEquals(8, thousands);
    }

    @Test
    void thousandsNinetyNine() {
        int thousands = Converter.thousands(99000);
        assertEquals(99, thousands);
    }

    @Test
    void thousandsMinusSixteen() {
        int thousands = Converter.thousands(-16000);
        assertEquals(16, thousands);
    }

    @Test
    void thousandsMinusZero() {
        int thousands = Converter.thousands(-900);
        assertEquals(0, thousands);
    }

    @Test
    void checkFourAndNine() {
        assertEquals(4, 9 % 5);
        assertEquals(4, 4 % 5);
        assertEquals(1, 9 / 5);
        assertEquals(0, 4 / 5);
    }

    @Test
    void convertFourThousand() {
        String roman = Converter.convert(4000);
        assertEquals("MMMM", roman);
    }

    @Test
    void convertOnes() {
        assertEquals("I", Converter.convert(1));
        assertEquals("II", Converter.convert(2));
        assertEquals("III", Converter.convert(3));
        assertEquals("IV", Converter.convert(4));
        assertEquals("V", Converter.convert(5));
        assertEquals("VI", Converter.convert(6));
        assertEquals("VII", Converter.convert(7));
        assertEquals("VIII", Converter.convert(8));
        assertEquals("IX", Converter.convert(9));
    }

    @Test
    void convertRomanTens() {
        assertEquals("X", Converter.convert(10));
        assertEquals("XX", Converter.convert(20));
        assertEquals("XXX", Converter.convert(30));
        assertEquals("XL", Converter.convert(40));
        assertEquals("L", Converter.convert(50));
        assertEquals("LX", Converter.convert(60));
        assertEquals("LXX", Converter.convert(70));
        assertEquals("LXXX", Converter.convert(80));
        assertEquals("XC", Converter.convert(90));
        assertEquals("L", Converter.convert(-50));
    }

    @Test
    void convertRomanHundreds() {
        assertEquals("C", Converter.convert(100));
        assertEquals("CC", Converter.convert(200));
        assertEquals("CCC", Converter.convert(300));
        assertEquals("CD", Converter.convert(400));
        assertEquals("D", Converter.convert(500));
        assertEquals("DC", Converter.convert(600));
        assertEquals("DCC", Converter.convert(700));
        assertEquals("DCCC", Converter.convert(800));
        assertEquals("CM", Converter.convert(900));
    }

    @Test
    void convertRomanThousands() {
        assertEquals("M", Converter.convert(1000));
        assertEquals("MM", Converter.convert(2000));
        assertEquals("MMM", Converter.convert(3000));
        assertEquals("MMM", Converter.convert(-3000));
    }

    @Test
    void convertNumbers() {
        assertEquals("DCCLIV", Converter.convert(754));
        assertEquals("CMXXV", Converter.convert(925));
        assertEquals("CDXCVI", Converter.convert(496));
        assertEquals("MCLXXXI", Converter.convert(1181));
        assertEquals("MMMCCXLIII", Converter.convert(3243));
        assertEquals("LXXXI", Converter.convert(81));
        assertEquals("MMCMLVII", Converter.convert(-2957));
        assertEquals("CCXXXII", Converter.convert(232));
    }
}
