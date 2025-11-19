import static org.junit.jupiter.api.Assertions.*;

class NumerosRomanosTest {

    @Test
    void shouldReturnLengthForNumberOne() {
        String result = NumerosRomanos.toRoman(1);
        assertEquals("I", result);
        assertEquals(1, result.length());
    }
    @Test
    void shouldReturnLengthForNumberTwo() {
        String result = NumerosRomanos.toRoman(2);
        assertEquals("II", result);
        assertEquals(2, result.length());
    }
    @Test
    void shouldReturnLengthNineForNumber3999() {
        String result = NumerosRomanos.toRoman(3999);
        assertEquals("MMMCMXCIX", result);
        assertEquals(9, result.length());
    }
    @Test
    void shouldReturnCorrectLengthForIntermediateValues() {
        assertEquals(5, NumerosRomanos.toRoman(58).length());
        assertEquals(7, NumerosRomanos.toRoman(1994).length());
    }
    @Test
    void shouldThrowExceptionForNumberTooSmall() {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.toRoman(0));
    }
    @Test
    void shouldThrowExceptionForNumberTooLarge() {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.toRoman(4000));
    }
}