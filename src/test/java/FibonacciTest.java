import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void shouldReturnZeroForNZero() {
        int result = Fibonacci.fibonacci(0);
        assertEquals(0, result);
    }
    @Test
    void shouldReturnOneForNOne() {
        int result = Fibonacci.fibonacci(1);
        assertEquals(1, result);
    }
    @Test
    void shouldReturnCorrectValueForSmallNumbers() {
        assertEquals(1, Fibonacci.fibonacci(2)); // 1
        assertEquals(2, Fibonacci.fibonacci(3)); // 2
        assertEquals(3, Fibonacci.fibonacci(4)); // 3
        assertEquals(5, Fibonacci.fibonacci(5)); // 5
        assertEquals(8, Fibonacci.fibonacci(6)); // 8
    }
    @Test
    void shouldReturnCorrectValueForBiggerNumber() {
        // sequência: 0,1,1,2,3,5,8,13,21,34,55
        assertEquals(55, Fibonacci.fibonacci(10));
    }
    @Test
    void shouldThrowExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Fibonacci.fibonacci(-1));
    }
}