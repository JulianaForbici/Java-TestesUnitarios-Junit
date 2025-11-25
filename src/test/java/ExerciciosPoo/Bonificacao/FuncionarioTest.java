package ExerciciosPoo.Bonificacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    @ParameterizedTest
    @DisplayName("Testando resultados esperados do construtor")
    @CsvSource({
            "Juliana, 111.111.111-11, 3000.0",
            "Lara, 222.222.222-22, 1500.5",
            "Fulaninha, 333.333.333-33, 0.0"
    })
    void testConstructorsGetters(String nome, String cpf, float salario) {
        Funcionario f = new Funcionario(nome, cpf, salario);
        assertEquals(nome, f.getNome());
        assertEquals(cpf, f.getCpf());
        assertEquals(salario, f.getSalario(), 1e-6f);
    }
    @ParameterizedTest
    @DisplayName("getBonificacao retorna 5% do salário")
    @CsvSource({
            "0.0, 0.0",
            "1000.0, 50.0",
            "2500.0, 125.0",
            "3000.5, 150.02501"
    })
    void bonificationPercentage(float salary, float expectedBonus) {
        Funcionario f = new Funcionario("Teste", "000.000.000-00", salary);
        assertEquals(expectedBonus, f.getBonificacao(), 1e-6f);
    }
    @ParameterizedTest
    @DisplayName("setSalario com valores negativos devem lançar exceção")
    @ValueSource(floats = { -0.01f, -100.0f, -Float.MIN_VALUE })
    void testSetSalaryNegativeThrowsParameterized(float invalidSalary) {
        Funcionario f = new Funcionario("Juliana Teste", "000.000.000-00", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> f.setSalario(invalidSalary));
    }
    @ParameterizedTest
    @CsvSource({
            "Juliana, 111.111.111-11, 2000.0",
            "Ana, 999.999.999-99, 1234.56"
    })
    @DisplayName("toString precisa retornar formatado")
    void testToStringContainsNameAndCpfParameterized(String nome, String cpf, float salario) {
        Funcionario f = new Funcionario(nome, cpf, salario);
        String s = f.toString();
        assertTrue(s.contains(nome),
                () -> "toString should contain the name: " + nome);
        assertTrue(s.contains(cpf),
                () -> "toString should contain the cpf: " + cpf);
    }
}