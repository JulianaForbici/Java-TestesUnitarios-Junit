import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class SomaDoisNumerosPTest {
    @ParameterizedTest
    @DisplayName("testar casos esperados e o caso base")
    @CsvSource({
            "1, 0",
            "2, 2",
            "3, 2",
            "4, 6",
            "5, 6",
            "6, 12",
            "10, 30"
    })
    void knownValues(int numeroDigitado, int esperado) {
        assertEquals(esperado, SomaDoisNumerosP.soma(numeroDigitado));
    }
    @ParameterizedTest
    @DisplayName("números negativos e zero devem lançar exceção")
    @ValueSource(ints = {-5, 0, 1})
    void zeroOrNegativeReturnsZero(int numeroDigitado) {
        assertEquals(0, SomaDoisNumerosP.soma(numeroDigitado));
    }
}