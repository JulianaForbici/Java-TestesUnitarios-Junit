package Recursividade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FatorialTest {
    @ParameterizedTest
    @DisplayName("testar casos bases")
    @ValueSource(ints = {0, 1})
    void shouldReturnOneForZeroAndOne(int numeroDigitado) {
        BigInteger resultado = Fatorial.fatorial(numeroDigitado);
        assertEquals(BigInteger.ONE, resultado, numeroDigitado + "! deve ser 1");
    }
    @ParameterizedTest
    @DisplayName("testar resultados fatoriais")
    @CsvSource({
            "2, 2",
            "3, 6",
            "5, 120",
            "20, 2432902008176640000",
            "21, 51090942171709440000",
            "30, 265252859812191058636308480000000"
    })
    void smallFactorials(int numeroDigitado, String bigIntEsperado) {
        BigInteger esperado = new BigInteger(bigIntEsperado);
        BigInteger resultado = Fatorial.fatorial(numeroDigitado);
        assertEquals(esperado, resultado);
    }
    @ParameterizedTest
    @DisplayName("números negativos devem lançar exceção")
    @ValueSource(ints = {-1, -2})
    void negativeShouldThrowIllegalArgumentException(int fatorial) {
        assertThrows(IllegalArgumentException.class,
                () -> Fatorial.fatorial(fatorial));
    }
}