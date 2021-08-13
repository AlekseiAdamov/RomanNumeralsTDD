import org.junit.jupiter.api.Test;
import ru.alekseiadamov.converter.Converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTests {

    Converter converter = new Converter();

    @Test
    void convertZero() {
        String roman = converter.convert(0);
        assertEquals("Cannot convert number 0", roman);
    }

    @Test
    void convertRomanOnes() {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III", converter.convert(3));
        assertEquals("IV", converter.convert(4));
        assertEquals("V", converter.convert(5));
        assertEquals("VI", converter.convert(6));
        assertEquals("VII", converter.convert(7));
        assertEquals("VIII", converter.convert(8));
        assertEquals("IX", converter.convert(9));
    }

    @Test
    void convertRomanTens() {
        assertEquals("X", converter.convert(10));
        assertEquals("XX", converter.convert(20));
        assertEquals("XXX", converter.convert(30));
        assertEquals("XL", converter.convert(40));
        assertEquals("L", converter.convert(50));
        assertEquals("LX", converter.convert(60));
        assertEquals("LXX", converter.convert(70));
        assertEquals("LXXX", converter.convert(80));
        assertEquals("XC", converter.convert(90));
        assertEquals("L", converter.convert(-50));
    }

    @Test
    void convertRomanHundreds() {
        assertEquals("C", converter.convert(100));
        assertEquals("CC", converter.convert(200));
        assertEquals("CCC", converter.convert(300));
        assertEquals("CD", converter.convert(400));
        assertEquals("D", converter.convert(500));
        assertEquals("DC", converter.convert(600));
        assertEquals("DCC", converter.convert(700));
        assertEquals("DCCC", converter.convert(800));
        assertEquals("CM", converter.convert(900));
    }

    @Test
    void convertRomanThousands() {
        assertEquals("M", converter.convert(1000));
        assertEquals("MM", converter.convert(2000));
        assertEquals("MMM", converter.convert(3000));
        assertEquals("MMM", converter.convert(-3000));
    }

    @Test
    void convertNumbers() {
        assertEquals("DCCLIV", converter.convert(754));
        assertEquals("CMXXV", converter.convert(925));
        assertEquals("CDXCVI", converter.convert(496));
        assertEquals("MCLXXXI", converter.convert(1181));
        assertEquals("MMMCCXLIII", converter.convert(3243));
        assertEquals("LXXXI", converter.convert(81));
        assertEquals("MMCMLVII", converter.convert(-2957));
        assertEquals("CCXXXII", converter.convert(232));
    }
}
