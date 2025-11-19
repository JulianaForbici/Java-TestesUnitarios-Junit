import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumerosRomanosTest {
    @Test
    void shouldReturnLengthForNumberOne() {
        String result = NumerosRomanos.numerosParaConversao(1);
        assertEquals("I", result);
        assertEquals(1, result.length());
    }
    @Test
    void shouldReturnLengthForNumberTwo() {
        String result = NumerosRomanos.numerosParaConversao(2);
        assertEquals("II", result);
        assertEquals(2, result.length());
    }
    @Test
    void shouldReturnLengthNineForNumber3999() {
        String result = NumerosRomanos.numerosParaConversao(3999);
        assertEquals("MMMCMXCIX", result);
        assertEquals(9, result.length());
    }
    @Test
    void shouldReturnCorrectLengthForIntermediateValues() {
        // 58 = LVIII
        String r1 = NumerosRomanos.numerosParaConversao(58);
        assertEquals("LVIII", r1);
        assertEquals(5, r1.length());
        // 1994 = MCMXCIV
        String r2 = NumerosRomanos.numerosParaConversao(1994);
        assertEquals("MCMXCIV", r2);
        assertEquals(7, r2.length());
    }
    @Test
    void shouldConvertLowerLimitValue() {
        assertEquals("I", NumerosRomanos.numerosParaConversao(1));
    }
    @Test
    void shouldConvertUpperLimitValue() {
        assertEquals("MMMCMXCIX", NumerosRomanos.numerosParaConversao(3999));
    }
    @Test
    void shouldThrowExceptionForNumberTooSmall() {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(0));
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(-5));
    }
    @Test
    void shouldThrowExceptionForNumberTooLarge() {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(4000));
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(5000));
    }
}