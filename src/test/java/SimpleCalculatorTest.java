import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorTest {
    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(2, 2);
        Assertions.assertEquals(4, result);
    }
    @Test
    void threePlusSevenShouldEqualTen() {
        SimpleCalculator calculator = new SimpleCalculator();
        Assertions.assertEquals(10, calculator.add(3, 7));
    }
    @Test
    void twoDivideTwoShouldEqualOne() {
        SimpleCalculator calculator = new SimpleCalculator();
        Assertions.assertEquals(1, calculator.divide(2, 2));
    }
    @Test
    void divideByZeroShouldThrowException() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(5, 0));
    }
}