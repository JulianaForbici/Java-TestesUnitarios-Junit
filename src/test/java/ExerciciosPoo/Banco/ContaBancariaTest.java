package ExerciciosPoo.Banco;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    @ParameterizedTest
    @DisplayName("Teste do depositar, com o saldo inicial, valor do depósito, resultado esperado e saldo final esperado")
    @CsvSource({
            // saldoInicial, valorDeposito, valorEsperado, saldoEsperado
            "100.0, 50.0, true, 150.0",
            "100.0, 0.0, false, 100.0",
            "100.0, -10.0, false, 100.0",
            "20.0, 20.0, true, 40.0",
            "45.0, 9.0, true, 54.0",
            "15.0, -10.0, false, 15.0"
    })
    void depositShouldReturnNumbersExpected(double saldoInicial, double valorDeposito, boolean valorEsperado, double saldoEsperado) {
        ContaBancaria c = new ContaBancaria(1, 1, saldoInicial, TipoConta.CONTA_CORRENTE);
        assertEquals(valorEsperado, c.depositar(valorDeposito));
        assertEquals(saldoEsperado, c.getSaldo(), 0.0001);
    }

    @ParameterizedTest
    @DisplayName("Teste do sacar, com o tipo de conta, saldo inicial, valor do saque, resultado esperado, saldo final esperado")
    @CsvSource({
            // tipoConta, saldoInicial, valorSaque, valorEsperado, saldoEsperado
            "CONTA_CORRENTE, 150.0, 20.0, true, 129.5",  // 20 + 0.5 taxa
            "CONTA_CORRENTE, 20.0, 20.0, false, 20.0",   // insuficiente por causa da taxa
            "POUPANCA, 50.0, 20.0, true, 30.0",         // sem taxa
            "POUPANCA, 10.0, 20.0, false, 10.0"         // insuficiente
    })
    void withDrawBankShouldReturnNumbersExpected(TipoConta tipoConta, double saldoInicial, double valorSaque, boolean valorEsperado, double saldoEsperado) {
        ContaBancaria s = new ContaBancaria(0, 1, saldoInicial, tipoConta);
        assertEquals(valorEsperado, s.sacar(valorSaque));
        assertEquals(saldoEsperado, s.getSaldo(), 0.0001);
    }

    @Test
    @DisplayName("getters básicos retornam valores esperados")
    void basicGettersTest() {
        ContaBancaria c = new ContaBancaria(5, 10, 123.45, TipoConta.CONTA_CORRENTE);
        assertEquals(5, c.getNumero());
        assertEquals(10, c.getAgencia());
        assertEquals(123.45, c.getSaldo(), 0.0001);
        assertEquals(TipoConta.CONTA_CORRENTE, c.getTipoConta());
    }

    @Test
    @DisplayName("Tipo de conta com tipo nulo deve lançar exceção")
    void constructorWithNullTypeShouldThrow() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(1, 1, 0.0, null));
        assertEquals("O tipo da conta não pode ser vazio!", ex.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Saldo com valor negativo deve lançar exceção")
    @ValueSource(doubles = {-0.01, -1.0})
    void negativeBalanceShouldThrow(double negativeValue) {
        ContaBancaria c = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        ContaBancaria d = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        assertThrows(IllegalArgumentException.class,
                () -> c.setSaldo(negativeValue));
        assertThrows(IllegalArgumentException.class,
                () -> d.setSaldo(negativeValue));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("Valores inválidos devem lançar IllegalArgumentException")
    void setNumberInvalidShouldThrow(int numeroInvalido) {
        ContaBancaria c = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        assertThrows(IllegalArgumentException.class,
                () -> c.setNumero(numeroInvalido));
    }

    @Test
    @DisplayName("Valores válidos atualizam o número da conta")
    void setNumberValidUpdates() {
        ContaBancaria c = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        c.setNumero(0);
        assertEquals(0, c.getNumero());
        c.setNumero(42);
        assertEquals(42, c.getNumero());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -50})
    @DisplayName("Valores inválidos devem lançar exceção")
    void setAgencyInvalid_ShouldThrow(int agenciaInvalida) {
        ContaBancaria c = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        assertThrows(IllegalArgumentException.class,
                () -> c.setAgencia(agenciaInvalida));
    }

    @Test
    @DisplayName("Valores válidos atualizam a agência")
    void setAgencyValidUpdates() {
        ContaBancaria c = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        c.setAgencia(0);
        assertEquals(0, c.getAgencia());
        c.setAgencia(99);
        assertEquals(99, c.getAgencia());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -0.01})
    @DisplayName("Sacar com valores inválidos retorna false e não altera o saldo")
    void withdrawInvalidValues_ReturnsFalse(double valorInvalido) {
        ContaBancaria c = new ContaBancaria(0, 1, 100.0, TipoConta.CONTA_CORRENTE);
        double saldoAntes = c.getSaldo();
        assertFalse(c.sacar(valorInvalido));
        assertEquals(saldoAntes, c.getSaldo(), 1e-9);
    }

    @Test
    @DisplayName("toString retorna formato completo esperado")
    void toStringExactMatch() {
        ContaBancaria c = new ContaBancaria(1, 2, 100.0, TipoConta.CONTA_CORRENTE);
        String esperado = String.format(
                "Conta: %d | Agência: %d | Tipo: %s | Saldo: R$%.2f",
                c.getNumero(), c.getAgencia(), c.getTipoConta(), c.getSaldo());
        assertEquals(esperado, c.toString());
    }
}