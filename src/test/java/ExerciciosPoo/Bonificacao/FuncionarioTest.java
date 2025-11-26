package ExerciciosPoo.Bonificacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Funcionario")
class FuncionarioTest {

    // testa o construtor e os getters com varios conjuntos de dados
    @ParameterizedTest
    @DisplayName("Getters retornam os valores esperados")
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
    // testa que a bonificacao padrao e 5 por cento do salario
    @ParameterizedTest
    @DisplayName("GetBonificacao retorna 5% do salario")
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

    // testa que setSalario com valores negativos lancara excecao
    @ParameterizedTest
    @DisplayName("SetSalario com valores negativos lancara excecao")
    @ValueSource(floats = { -0.01f, -100.0f, -Float.MIN_VALUE })
    void testSetSalaryNegativeThrowsParameterized(float invalidSalary) {
        Funcionario f = new Funcionario("Juliana Teste", "000.000.000-00", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> f.setSalario(invalidSalary));
    }

    // testa que toString contem nome e cpf para verificacao basica de formatacao
    @ParameterizedTest
    @DisplayName("ToString contem nome  e cpf")
    @CsvSource({
            "Juliana, 111.111.111-11, 2000.0",
            "Ana, 999.999.999-99, 1234.56"
    })
    void testToStringContainsNameAndCpfParameterized(String nome, String cpf, float salario) {
        Funcionario f = new Funcionario(nome, cpf, salario);
        String s = f.toString();
        assertTrue(s.contains(nome), "toString should contain the name");
        assertTrue(s.contains(cpf), "toString should contain the cpf");
    }

    // testa que setNome lancara excecao quando receber null
    @Test
    @DisplayName("SetNome null lancara excecao")
    void testSetNomeNullThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setNome(null));
    }

    // testa que setNome lancara excecao quando receber string vazia
    @Test
    @DisplayName("SetNome vazio lancara excecao")
    void testSetNomeEmptyThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setNome(""));
    }

    // testa que setNome lancara excecao quando receber apenas espacos
    @Test
    @DisplayName("SetNome em branco lancara excecao")
    void testSetNomeBlankThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setNome("   "));
    }

    // testa que setCpf lancara excecao quando receber null
    @Test
    @DisplayName("SetCpf null lancara excecao")
    void testSetCpfNullThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setCpf(null));
    }

    // testa que setCpf lancara excecao quando receber string vazia
    @Test
    @DisplayName("SetCpf vazio lancara excecao")
    void testSetCpfEmptyThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setCpf(""));
    }

    // testa que setCpf lancara excecao quando receber apenas espacos
    @Test
    @DisplayName("SetCpf em branco lancara excecao")
    void testSetCpfBlankThrows() {
        Funcionario f = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class, () -> f.setCpf("   "));
    }

    // testa que setters validos alteram os valores corretamente
    @Test
    @DisplayName("SetNome e SetCpf aceitam valores validos")
    void testSetNomeAndCpfAcceptValidValues() {
        Funcionario f = new Funcionario("silva", "000.000.000-00", 1000.0f);
        f.setNome("Fulano da silva");
        f.setCpf("123.456.789-00");
        assertEquals("Fulano da silva", f.getNome());
        assertEquals("123.456.789-00", f.getCpf());
    }

    // testa que o construtor tambem valida nome e cpf via setters e lancara excecao se invalidos
    @Test
    @DisplayName("Construtor lancara excecao para nome nulo")
    void testConstructorThrowsOnNullName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Funcionario(null, "111.111.111-11", 1000.0f));
    }

    @Test
    @DisplayName("Construtor lancara excecao para cpf nulo")
    void testConstructorThrowsOnNullCpf() {
        assertThrows(IllegalArgumentException.class,
                () -> new Funcionario("Abraao", null, 1000.0f));
    }
}