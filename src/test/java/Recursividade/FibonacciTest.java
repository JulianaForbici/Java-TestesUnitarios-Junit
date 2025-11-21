package Recursividade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    @ParameterizedTest
    @DisplayName("testar casos bases")
    @ValueSource(ints = {0, 1})
    void baseCases(int fibonacci) {
        BigInteger esperado = BigInteger.valueOf(fibonacci);
        BigInteger resultado = Fibonacci.fibonacci(fibonacci);
        assertEquals(esperado, resultado);
    }
    @ParameterizedTest
    @DisplayName("testar resultados esperados")
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "10, 55"
    })
        // esperado como string para suportar valores maiores
    void knownValues(int fibonacci, String valoresMaiores) {
        BigInteger esperado = new BigInteger(valoresMaiores);
        BigInteger resultado = Fibonacci.fibonacci(fibonacci);
        assertEquals(esperado, resultado);
    }
    @ParameterizedTest
    @DisplayName("números negativos devem lançar exceção")
    @ValueSource(ints = {-1, -5})
    void negativeNumbersShouldThrow(int fibonacci) {
        assertThrows(IllegalArgumentException.class,
                () -> Fibonacci.fibonacci(fibonacci));
    }
}