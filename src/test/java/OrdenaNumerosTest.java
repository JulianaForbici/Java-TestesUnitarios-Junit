import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdenaNumerosTest {
    @Test
    void shouldReturnNumbersInAscendingOrder() {
        String result = OrdenaNumeros.ordemCincoNumeros(5, 3, 1, 4, 2);
        assertEquals("1 2 3 4 5", result);
    }
    @Test
    void shouldHandleMinimumIntegerValue() {
        String result = OrdenaNumeros.ordemCincoNumeros(Integer.MIN_VALUE, -1, 0, 1, 2);
        assertTrue(result.startsWith(String.valueOf(Integer.MIN_VALUE)));
    }
    @Test
    void shouldHandleMaximiumIntegerValues() {
        String result = OrdenaNumeros.ordemCincoNumeros(Integer.MAX_VALUE, 1, 2, 3, 4);
        assertTrue(result.endsWith(String.valueOf(Integer.MAX_VALUE)));
    }
    @Test
    void shouldThrowExceptionForNumberTooLarge() {
        assertThrows(NumberFormatException.class,
                () -> Integer.parseInt("77777777777777777777777777777777"));
    }
    @Test
    void shouldThrowExceptionForDouble() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("1.5"));
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("1,9"));
    }
    @Test
    void shouldThrowExceptionForString() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("a"));
    }
}