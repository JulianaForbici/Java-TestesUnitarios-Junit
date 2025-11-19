package ExemplosTestes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplierTest {
    @Test
    void twoMultiplierTwoShouldReturnFour(){
        var multiplier = new Multiplier();
        int result = multiplier.multiply(2, 2);
        Assertions.assertEquals(4, result);
    }
    @Test
    void zeroMultiplierShouldReturnZero(){
        var multiplier = new Multiplier();
        int result = multiplier.multiply(0, 2);
        Assertions.assertEquals(0, result);
    }
    @Test
    void negativeMultiplierShouldReturnNegative(){
        var multiplier = new Multiplier();
        int result = multiplier.multiply(-1, 3);
        Assertions.assertEquals(-3, result);
    }
}