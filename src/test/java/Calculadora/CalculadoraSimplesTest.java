package Calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class CalculadoraSimplesTest {
    @Test
    void shouldAdd() {
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("5");
        assertEquals(new BigDecimal("10"), a.add(b));
    }
    @Test
    void shouldSubtract() {
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("5");
        assertEquals(new BigDecimal("0"), a.subtract(b));
    }
    @Test
    void shouldMultiply() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("9");
        assertEquals(new BigDecimal("90"), a.multiply(b));
    }
    // dividindo e mostrando o resultado em escala (9 / 3 = 3 e a escala > 3.000)
    @Test
    void shouldDivide()
    {
        BigDecimal a = new BigDecimal("9");
        BigDecimal b = new BigDecimal("3");
        BigDecimal resultado = a.divide(b, 3, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("3.000"), resultado);
    }
    @Test
    void shouldThrowExceptionForZero()
    {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = BigDecimal.ZERO;
        assertThrows(ArithmeticException.class,
                () -> {
            a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        });
    }
    @Test
    void shouldMultiplyWithMaxInteger() {
        BigDecimal a = new BigDecimal(Integer.MAX_VALUE); // 2147483647
        BigDecimal b = new BigDecimal("2");
        BigDecimal expected = new BigDecimal("4294967294");
        assertEquals(expected, a.multiply(b));
    }
}