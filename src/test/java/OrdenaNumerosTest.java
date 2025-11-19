import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdenaNumerosTest {
    @Test
    void shouldReturnNumbersInAscendingOrder() {
        String result = OrdenaNumeros.sortFiveNumbers(5, 3, 1, 4, 2);
        assertEquals("1 2 3 4 5", result);
    }
    @Test
    void shouldHandleMinimumIntegerValue() {
        String result = OrdenaNumeros.sortFiveNumbers(Integer.MIN_VALUE, -1, 0, 1, 2);
        // aqui eu espero a string completa já ordenada
        assertEquals(Integer.MIN_VALUE + " -1 0 1 2", result);
    }
    @Test
    void shouldHandleMaximumIntegerValue() {
        String result = OrdenaNumeros.sortFiveNumbers(Integer.MAX_VALUE, 1, 2, 3, 4);
        // e aqui também comparo tudo certinho
        assertEquals("1 2 3 4 " + Integer.MAX_VALUE, result);
    }
    @Test
    void shouldReturnNumbersInAscendingOrderWithDuplicates() {
        String result = OrdenaNumeros.sortFiveNumbers(3, 1, 3, 2, 1);
        assertEquals("1 1 2 3 3", result);
    }
    @Test
    void shouldReturnNumbersInAscendingOrderWithNegativeValues() {
        String result = OrdenaNumeros.sortFiveNumbers(-5, -1, 0, 10, 3);
        assertEquals("-5 -1 0 3 10", result);
    }
}