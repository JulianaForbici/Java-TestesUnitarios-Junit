package ExerciciosLogica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OrdenaNumerosTest {
    @Test
    void shouldReturnNumbersInAscendingOrder() {
        String result = OrdenaNumeros.ordenarNumeros(5, 3, 1, 4, 2);
        assertEquals("1 2 3 4 5", result);
    }
    @Test
    void shouldHandleMinimumIntegerValue() {
        String result = OrdenaNumeros.ordenarNumeros(Integer.MIN_VALUE, -1, 0, 1, 2);
        // aqui eu espero a string completa já ordenada
        assertEquals(Integer.MIN_VALUE + " -1 0 1 2", result);
    }
    @Test
    void shouldHandleMaximumIntegerValue() {
        String result = OrdenaNumeros.ordenarNumeros(Integer.MAX_VALUE, 1, 2, 3, 4);
        // e aqui também comparo tudo certinho
        assertEquals("1 2 3 4 " + Integer.MAX_VALUE, result);
    }
    @Test
    void shouldReturnNumbersInAscendingOrderWithDuplicates() {
        String result = OrdenaNumeros.ordenarNumeros(3, 1, 3, 2, 1);
        assertEquals("1 1 2 3 3", result);
    }
    @Test
    void shouldReturnNumbersInAscendingOrderWithNegativeValues() {
        String result = OrdenaNumeros.ordenarNumeros(-5, -1, 0, 10, 3);
        assertEquals("-5 -1 0 3 10", result);
    }
    @ParameterizedTest
    @CsvSource({
            "10,9,8,7,6,'6 7 8 9 10'",
            "100,-100,0,50,-50,'-100 -50 0 50 100'",
            "-2,-1,-1,0,0,'-2 -1 -1 0 0'",
            "42,42,7,7,42,'7 7 42 42 42'",
            "2147483647,-2147483648,0,-1,1,'-2147483648 -1 0 1 2147483647'"
    })
    void sortsFiveNumberswithExpected(int a, int b, int c, int d, int e, String esperado) {
        String resultado = OrdenaNumeros.ordenarNumeros(a, b, c, d, e);
        System.out.println("esperado: '" + esperado + "'");
        System.out.println("resultado: '" + resultado + "'");
        assertEquals(esperado.trim(), resultado.trim());
    }
}