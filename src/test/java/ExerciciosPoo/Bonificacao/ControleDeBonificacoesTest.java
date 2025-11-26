package ExerciciosPoo.Bonificacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControleDeBonificacoesTest {
    // testa registrar funcionarios e gerente e total acumulado das bonificacoes
    @Test
    @DisplayName("registrar acumula bonificacoes corretamente")
    void testRegisterAndTotalBonificacoes() {
        ControleDeBonificacoes controle = new ControleDeBonificacoes();

        Funcionario funcionario = new Funcionario("Juliana", "111.111.111-11", 3000.0f); // 5% -> 150.0
        Gerente gerente = new Gerente("Lara", "222.222.222-22", 8000.0f, "pwd", 2);  // 10% -> 800.0

        controle.registrar(funcionario);
        controle.registrar(gerente);

        double expected = (double) funcionario.getBonificacao() + (double) gerente.getBonificacao();
        assertEquals(expected, controle.getTotalBonificacoes(), 1e-6);
    }

    // testa que registrar nulo lancara excecao
    @Test
    @DisplayName("registrar nulo lancara excecao")
    void testRegisterNullThrows() {
        ControleDeBonificacoes controle = new ControleDeBonificacoes();
        assertThrows(IllegalArgumentException.class,
                () -> controle.registrar(null));
    }

    // testa acumulacao em multiplas chamadas para garantir soma correta
    @Test
    @DisplayName("registrar multiplos funcionarios acumula corretamente")
    void testMultipleRegistrationsAccumulate(){
        ControleDeBonificacoes controle = new ControleDeBonificacoes();

            Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f); // 50.0
        Funcionario funcionario2 = new Funcionario("Formiga", "222.222.222-22", 2000.0f); // 100.0
        Gerente gerente = new Gerente("Adriano", "333.333.333-33", 5000.0f, "s", 1); // 500.0

        controle.registrar(funcionario);
        controle.registrar(funcionario2);
        controle.registrar(gerente);

        double expected = (double) funcionario.getBonificacao() + (double) funcionario2.getBonificacao() +
                (double) gerente.getBonificacao();
        assertEquals(expected, controle.getTotalBonificacoes(), 1e-6);
    }
}