import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumerosRomanosTest {
    @ParameterizedTest(name = "{0} -> {1}")
    @DisplayName("testar resultados esperados")
    @CsvSource({
            "1, I",
            "2, II",
            "5, V",
            "10, X",
            "15, XV",
            "20, XX",
            "2005, MMV",
            "1998, MCMXCVIII",
            "3999, MMMCMXCIX"
    })
    void convertsBasicNumbersToRoman(int numero, String esperado) {
        assertEquals(esperado,
                NumerosRomanos.numerosParaConversao(numero));
    }
    @ParameterizedTest
    @DisplayName("números fora do intervalo devem lançar exceção")
    @ValueSource(ints = {0, -1, 4000})
    void throwsOnOutOfRange(int invalido) {
        assertThrows(IllegalArgumentException.class,
                () -> NumerosRomanos.numerosParaConversao(invalido));
    }
}