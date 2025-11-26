package ExerciciosPoo.Carro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import java.time.Year;
import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    // testa os getters básicos do objeto carro
    @ParameterizedTest
    @DisplayName("getters retornam os valores esperados corretamente")
    @CsvSource({
            "Volkswagen, Fusca, Azul, 2015, 60000.0",
            "Fiat, Uno, Branco, 2000, 15000.5",
            "Toyota, Corolla, Prata, 2020, 90000.99"
    })
    void testGetters(String fabricante, String modelo, String cor, int anoFabricacao, double precoCompra) {
        // cria um carro com proprietario null para validar getters simples
        Carro carro = new Carro(fabricante, modelo, cor, anoFabricacao, precoCompra, null);
        // verifica se os getters retornam exatamente os valores passados no construtor
        assertEquals(fabricante, carro.getFabricante());
        assertEquals(modelo, carro.getModelo());
        assertEquals(cor, carro.getCor());
        assertEquals(anoFabricacao, carro.getAnoFabricacao());
        // para double usamos uma tolerancia por causa da imprecisao de ponto flutuante
        assertEquals(precoCompra, carro.getPrecoCompra(), 1e-6);
        // como foi passado null no proprietario o getter deve retornar null aqui tambem
        assertNull(carro.getProprietario());
    }

    // testa que o proprietario retornado é exatamente a mesma instância passada
    @Test
    @DisplayName("GetProprietario retorna a mesma instância passada")
    void testGetProprietarioIdentity() {
        Pessoa p = new Pessoa("Laura", "000.000.000-00");
        Carro carro = new Carro("Volvo", "M30", "Prateado", 2018, 30000.0, p);
        // assertSame valida que é a mesma referência não só equals
        assertSame(p, carro.getProprietario());
    }

    // testa o formato da representacao textual do carro toString
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

    // testa calcularTempoDeUsoEmAnos para varios cenarios
    // yearsAgo representa quantos anos atrás foi fabricado
    // a expectativa normaliza para 0 quando ano de fabricacao é no futuro pq pode dar erro
    @DisplayName("Calcula anos corretamente")
    @ValueSource(ints = {0, 1, 5, 20})
    void testCalculateUsageYears(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        Carro carro = new Carro("X", "Y", "Z", anoFabricacao, 10000.0, null);
        int anos = currentYear - anoFabricacao;
        if (anos < 0) anos = 0;
        assertEquals(anos, carro.calcularTempoDeUsoEmAnos());
    }

    // caso explicito ano de fabricacao no futuro deve retornar 0
    @Test
    @DisplayName("CalcularTempoDeUsoEmAnos: ano futuro retorna 0")
    void testCalculateUsageYearsFuture() {
        int currentYear = Year.now().getValue();
        Carro carro = new Carro("X", "Y", "Z", currentYear + 1, 10000.0, null);
        // valida comportamento de normalizacao para 0 quando anoFabricacao > anoAtual
        assertEquals(0, carro.calcularTempoDeUsoEmAnos());
    }

    // testa calcularValorRevenda aplicando deprecicao de 5% ao ano usando multiplicacao iterativa
    // se anos >= 20 o valor de revenda é 0
    @ParameterizedTest
    @DisplayName("CalcularValorRevenda: aplica depreciação 0.95^anos; 0 se anos >= 20")
    @ValueSource(ints = {0, 1, 5, 19, 20})
    void testCalculateResaleValue(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        double preco = 50000.0;
        Carro carro = new Carro("M", "N", "C", anoFabricacao, preco, null);

        double expected;
        int anos = currentYear - anoFabricacao;
        if (anos < 0) anos = 0;

        if (anos >= 20) {
            // regra do exercicio vida util 20 anos sem valor de revenda
            expected = 0.0;
        } else {
            // calculo iterativo do fator 0.95^anos
            double fator = 1.0;
            for (int i = 0; i < anos; i++) {
                fator = fator * 0.95;
            }
            expected = preco * fator;
            if (expected < 0.0) expected = 0.0;
        }

        // valida o valor calculado pelo metodo com tolerancia para double
        assertEquals(expected, carro.calcularValorRevenda(), 1e-6);
    }

    // se o preco de compra for negativo o valor de revenda deve ser 0.0
    @Test
    @DisplayName("CalcularValorRevenda: preço negativo devolve 0.0")
    void testCalculateResaleValueNegativePrice() {
        int currentYear = Year.now().getValue();
        Carro carro = new Carro("M", "N", "C", currentYear - 1, -10000.0, null);

        // confirma que preco negativo produz revenda 0
        assertEquals(0.0, carro.calcularValorRevenda(), 1e-6);
    }

    // testa calculo do ipva
    // ipva = 4% do valor de revenda
    // carros com mais de 10 anos sao isentos
    @ParameterizedTest
    @DisplayName("CalcularIpva: 4% do valor de revenda, ou 0 se anos > 10")
    @ValueSource(ints = {0, 1, 5, 10, 11})
    void testCalculateIpva(int yearsAgo) {
        int currentYear = Year.now().getValue();
        int anoFabricacao = currentYear - yearsAgo;
        double preco = 40000.0;
        Carro carro = new Carro("M", "N", "C", anoFabricacao, preco, null);

        int anos = currentYear - anoFabricacao;
        if (anos < 0) anos = 0;

        double expectedIpva;
        if (anos > 10) {
            // regra isencao de ipva para mais de 10 anos
            expectedIpva = 0.0;
        } else {
            double valorRevenda;
            if (anos >= 20) {
                valorRevenda = 0.0;
            } else {
                // calculo iterativo do fator 0.95^anos para evitar math.pow
                double fator = 1.0;
                for (int i = 0; i < anos; i++) {
                    fator = fator * 0.95;
                }
                valorRevenda = preco * fator;
            }
            expectedIpva = valorRevenda * 0.04;
        }

        // compara o ipva esperado com o valor retornado pelo metodo
        assertEquals(expectedIpva, carro.calcularIpva(), 1e-6);
    }
}