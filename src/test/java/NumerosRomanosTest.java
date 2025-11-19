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
        String r1 = NumerosRomanos.numerosParaConversao(20);
            assertEquals("XX", r1);
        assertEquals(2, r1.length());
        String r2 = NumerosRomanos.numerosParaConversao(2005);
        assertEquals("MMV", r2);
        assertEquals(3, r2.length());
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
                () -> NumerosRomanos.numerosParaConversao(-1));
    }
    @Test
    void shouldThrowExceptionForNumberTooLarge() {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(4000));
    }
}