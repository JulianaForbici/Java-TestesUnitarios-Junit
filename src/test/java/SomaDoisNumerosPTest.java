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
        int result = SomaDoisNumerosP.sumEven(2); // só o 2 é par
        assertEquals(2, result);
    }
    @Test
    void shouldReturnSumForEvenX() {
        int result = SomaDoisNumerosP.sumEven(6); // 2 + 4 + 6 = 12
        assertEquals(12, result);
    }
    @Test
    void shouldReturnSameSumForOddX() {
        int result = SomaDoisNumerosP.sumEven(7); // também 2 + 4 + 6 = 12
        assertEquals(12, result);
    }
    @Test
    void shouldReturnCorrectSumForTen() {
        int result = SomaDoisNumerosP.sumEven(10); // 2+4+6+8+10 = 30
        assertEquals(30, result);
    }
}
