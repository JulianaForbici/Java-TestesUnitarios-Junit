package Recursividade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FatorialTest {
    @Test
    void shouldReturnOneForZero() {
        long result = Fatorial.factorial(0);
        assertEquals(1L, result);
    }
    @Test
    void shouldReturnOneForOne() {
        long result = Fatorial.factorial(1);
        assertEquals(1L, result);
    }
    @Test
    void shouldReturnCorrectFactorialForThree() {
        long result = Fatorial.factorial(3); // 3 * 2 * 1
        assertEquals(6L, result);
    }
    @Test
    void shouldReturnCorrectFactorialForFive() {
        long result = Fatorial.factorial(5); // 5 * 4 * 3 * 2 * 1
        assertEquals(120L, result);
    }
    @Test
    void shouldReturnCorrectFactorialForTen() {
        long result = Fatorial.factorial(10); // 10! = 3.628.800
        assertEquals(3_628_800L, result);
    }
    @Test
    void shouldThrowExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Fatorial.factorial(-1));
    }
}