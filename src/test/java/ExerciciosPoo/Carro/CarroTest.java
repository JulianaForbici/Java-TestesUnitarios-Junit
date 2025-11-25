package ExerciciosPoo.Carro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import java.time.Year;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("testes simplificados da classe carro")
class CarroTest {
    @ParameterizedTest
    @DisplayName("getters retornam os valores esperados corretamente")
    @CsvSource({
            "Volkswagen, Fusca, Azul, 2015, 60000.0",
            "Fiat, Uno, Branco, 2000, 15000.5",
            "Toyota, Corolla, Prata, 2020, 90000.99"
    })
    void testGetters(String fabricante, String modelo, String cor, int anoFabricacao, double precoCompra) {
        Carro carro = new Carro(fabricante, modelo, cor, anoFabricacao, precoCompra, null);
        assertEquals(fabricante, carro.getFabricante());
        assertEquals(modelo, carro.getModelo());
        assertEquals(cor, carro.getCor());
        assertEquals(anoFabricacao, carro.getAnoFabricacao());
        // para double foi usado um delta para tolerância de ponto flutuante
        assertEquals(precoCompra, carro.getPrecoCompra(), 1e-6);
        // proprietario foi criado como null no construtor do teste
        assertNull(carro.getProprietario());
    }
    @Test
    @DisplayName("getProprietario retorna a mesma instância passada")
    void testGetProprietarioIdentity() {
        Pessoa p = new Pessoa("Laura", "000.000.000-00");
        Carro carro = new Carro("Volvo", "M30", "Prateado", 2018, 30000.0, p);
        assertSame(p, carro.getProprietario());
    }
    // testa o formato retornado por toString() -> deve seguir "Fabricante Modelo (Ano) || Cor".
    @ParameterizedTest
    @DisplayName("toString produz o formato esperado")
    @CsvSource({
            "Volkswagen, Fusca, Azul, 2015",
            "Fiat, Uno, Branco, 2000"
    })
    void testToString(String fabricante, String modelo, String cor, int ano) {
        Carro carro = new Carro(fabricante, modelo, cor, ano, 10000.0, null);
        String expected = fabricante + " " + modelo + " (" + ano + ") || " + cor;
        assertEquals(expected, carro.toString());
    }
    @ParameterizedTest
    @DisplayName("calcularTempoDeUsoEmAnos: calcula anos corretamente (0 se fabricado no futuro)")
    @ValueSource(ints = {0, 1, 5, 20})
    void testCalculateUsageYears(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        Carro carro = new Carro("X", "Y", "Z", anoFabricacao, 10000.0, null);
        assertEquals(Math.max(0, yearsAgo), carro.calcularTempoDeUsoEmAnos());
    }
    @Test
    @DisplayName("calcularTempoDeUsoEmAnos: ano futuro retorna 0")
    void testCalculateUsageYearsFuture() {
        int currentYear = Year.now().getValue();
        Carro carro = new Carro("X", "Y", "Z", currentYear + 1, 10000.0, null);
        assertEquals(0, carro.calcularTempoDeUsoEmAnos());
    }
    @ParameterizedTest
    @DisplayName("calcularValorRevenda: aplica depreciação 0.95^anos; 0 se anos >= 20")
    @ValueSource(ints = {0, 1, 5, 19, 20})
    void testCalculateResaleValue(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        double preco = 50000.0;
        Carro carro = new Carro("M", "N", "C", anoFabricacao, preco, null);
        double expected;
        int anos = Math.max(0, yearsAgo);
        if (anos >= 20) {
            expected = 0.0;
        } else {
            expected = preco * Math.pow(0.95, anos);
            if (expected < 0.0) expected = 0.0;
        }
        assertEquals(expected, carro.calcularValorRevenda(), 1e-6);
    }
    @Test
    @DisplayName("calcularValorRevenda: preço negativo devolve 0.0")
    void testCalculateResaleValueNegativePrice() {
        int currentYear = Year.now().getValue();
        Carro carro = new Carro("M", "N", "C", currentYear - 1, -10000.0, null);
        assertEquals(0.0, carro.calcularValorRevenda(), 1e-6);
    }
    @ParameterizedTest
    @DisplayName("calcularIpva: 4% do valor de revenda, ou 0 se anos > 10")
    @ValueSource(ints = {0, 1, 5, 10, 11})
    void testCalculateIpva(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        double preco = 40000.0;
        Carro carro = new Carro("M", "N", "C", anoFabricacao, preco, null);
        int anos = Math.max(0, yearsAgo);
        double expectedIpva;
        if (anos > 10) {
            expectedIpva = 0.0;
        } else {
            double valorRevenda = (anos >= 20) ? 0.0 : preco * Math.pow(0.95, anos);
            expectedIpva = valorRevenda * 0.04;
        }
        assertEquals(expectedIpva, carro.calcularIpva(), 1e-6);
    }
}