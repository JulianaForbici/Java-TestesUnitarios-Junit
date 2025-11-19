package Recursividade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SomaDoisNumerosPTest {
    @Test
    void shouldReturnZeroForOne() {
        int result = SomaDoisNumerosP.sumEven(1);
        assertEquals(0, result);
    }
    @Test
    void shouldReturnTwoForTwo() {
        int result = SomaDoisNumerosP.sumEven(2); // só o 2 é par, então vai constar o resultado somente do 2
        assertEquals(2, result);
    }
    @Test
    void shouldReturnSumForEvenX() {
        int result = SomaDoisNumerosP.sumEven(6); // 2 + 4 + 6 = 12
        assertEquals(12, result);
    }
    @Test
    void shouldReturnSameSumForOddX() {
        int result = SomaDoisNumerosP.sumEven(7); // 2 + 4 + 6 = 12
        assertEquals(12, result);
    }
    @Test
    void shouldReturnCorrectSumForThirty() {
        int result = SomaDoisNumerosP.sumEven(30);
        assertEquals(240, result);
    }
}