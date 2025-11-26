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
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, saldoInicial, TipoConta.CONTA_CORRENTE);
        assertEquals(valorEsperado, contabancaria1.depositar(valorDeposito));
        assertEquals(saldoEsperado, contabancaria1.getSaldo(), 0.0001);
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
        ContaBancaria contabancaria1 = new ContaBancaria(0, 1, saldoInicial, tipoConta);
        assertEquals(valorEsperado, contabancaria1.sacar(valorSaque));
        assertEquals(saldoEsperado, contabancaria1.getSaldo(), 0.0001);
    }

    @Test
    @DisplayName("getters básicos retornam valores esperados")
    void basicGettersTest() {
        ContaBancaria contabancaria1 = new ContaBancaria(5, 10, 123.45, TipoConta.CONTA_CORRENTE);
        assertEquals(5, contabancaria1.getNumero());
        assertEquals(10, contabancaria1.getAgencia());
        assertEquals(123.45, contabancaria1.getSaldo(), 0.0001);
        assertEquals(TipoConta.CONTA_CORRENTE, contabancaria1.getTipoConta());
    }

    @Test
    @DisplayName("Tipo de conta vqzia deve lançar exceção")
    void constructorWithNullTypeShouldThrow() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(1, 1, 0.0, null));
        assertEquals("O tipo da conta não pode ser vazio!", ex.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Saldo com valor negativo deve lançar exceção")
    @ValueSource(doubles = {-0.01, -1.0})
    void negativeBalanceShouldThrow(double negativeValue) {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        ContaBancaria contabancaria2 = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        assertThrows(IllegalArgumentException.class,
                () -> contabancaria1.setSaldo(negativeValue));
        assertThrows(IllegalArgumentException.class,
                () -> contabancaria2.setSaldo(negativeValue));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("Valores inválidos devem lançar exceção")
    void setNumberInvalidShouldThrow(int numeroInvalido) {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        assertThrows(IllegalArgumentException.class,
                () -> contabancaria1.setNumero(numeroInvalido));
    }

    @Test
    @DisplayName("Valores válidos atualizam o número da conta")
    void setNumberValidUpdates() {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, 10.0, TipoConta.POUPANCA);
        contabancaria1.setNumero(0);
        assertEquals(0, contabancaria1.getNumero());
        contabancaria1.setNumero(42);
        assertEquals(42, contabancaria1.getNumero());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -50})
    @DisplayName("Valores inválidos devem lançar exceção")
    void setAgencyInvalid_ShouldThrow(int agenciaInvalida) {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        assertThrows(IllegalArgumentException.class,
                () -> contabancaria1.setAgencia(agenciaInvalida));
    }

    @Test
    @DisplayName("Valores válidos atualizam a agência")
    void setAgencyValidUpdates() {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 1, 10.0, TipoConta.CONTA_CORRENTE);
        contabancaria1.setAgencia(0);
        assertEquals(0, contabancaria1.getAgencia());
        contabancaria1.setAgencia(99);
        assertEquals(99, contabancaria1.getAgencia());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -0.01})
    @DisplayName("Sacar com valores inválidos retorna false e não altera o saldo")
    void withdrawInvalidValues_ReturnsFalse(double valorInvalido) {
        ContaBancaria contabancaria1 = new ContaBancaria(0, 1, 100.0, TipoConta.CONTA_CORRENTE);
        double saldoAntes = contabancaria1.getSaldo();
        assertFalse(contabancaria1.sacar(valorInvalido));
        assertEquals(saldoAntes, contabancaria1.getSaldo(), 1e-9);
    }

    @Test
    @DisplayName("toString retorna formato completo esperado")
    void toStringExactMatch() {
        ContaBancaria contabancaria1 = new ContaBancaria(1, 2, 100.0, TipoConta.CONTA_CORRENTE);
        String esperado = String.format(
                "Conta: %d | Agência: %d | Tipo: %s | Saldo: R$%.2f",
                contabancaria1.getNumero(), contabancaria1.getAgencia(), contabancaria1.getTipoConta(), contabancaria1.getSaldo());
        assertEquals(esperado, contabancaria1.toString());
    }
}