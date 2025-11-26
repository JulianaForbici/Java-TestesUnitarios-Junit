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
        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        assertEquals(nome, funcionario.getNome());
        assertEquals(cpf, funcionario.getCpf());
        assertEquals(salario, funcionario.getSalario(), 1e-6f);
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
        Funcionario funcionario = new Funcionario("Teste", "000.000.000-00", salary);
        assertEquals(expectedBonus, funcionario.getBonificacao(), 1e-6f);
    }

    // testa que setSalario com valores negativos lancara excecao
    @ParameterizedTest
    @DisplayName("SetSalario com valores negativos lancara excecao")
    @ValueSource(floats = { -0.01f, -100.0f, -Float.MIN_VALUE })
    void testSetSalaryNegativeThrowsParameterized(float invalidSalary) {
        Funcionario funcionario = new Funcionario("Juliana Teste", "000.000.000-00", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setSalario(invalidSalary));
    }

    // testa que toString contem nome e cpf para verificacao basica de formatacao
    @ParameterizedTest
    @DisplayName("ToString contem nome  e cpf")
    @CsvSource({
            "Juliana, 111.111.111-11, 2000.0",
            "Ana, 999.999.999-99, 1234.56"
    })
    void testToStringContainsNameAndCpfParameterized(String nome, String cpf, float salario) {
        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        String s = funcionario.toString();
        assertTrue(s.contains(nome), "toString should contain the name");
        assertTrue(s.contains(cpf), "toString should contain the cpf");
    }

    // testa que setNome lancara excecao quando receber null
    @Test
    @DisplayName("SetNome null lancara excecao")
    void testSetNomeNullThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setNome(null));
    }

    // testa que setNome lancara excecao quando receber string vazia
    @Test
    @DisplayName("SetNome vazio lancara excecao")
    void testSetNomeEmptyThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setNome(""));
    }

    // testa que setNome lancara excecao quando receber apenas espacos
    @Test
    @DisplayName("SetNome em branco lancara excecao")
    void testSetNomeBlankThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setNome("   "));
    }

    // testa que setCpf lancara excecao quando receber null
    @Test
    @DisplayName("SetCpf null lancara excecao")
    void testSetCpfNullThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setCpf(null));
    }

    // testa que setCpf lancara excecao quando receber string vazia
    @Test
    @DisplayName("SetCpf vazio lancara excecao")
    void testSetCpfEmptyThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setCpf(""));
    }

    // testa que setCpf lancara excecao quando receber apenas espacos
    @Test
    @DisplayName("SetCpf em branco lancara excecao")
    void testSetCpfBlankThrows() {
        Funcionario funcionario = new Funcionario("Fulaninho", "111.111.111-11", 1000.0f);
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setCpf("   "));
    }

    // testa que setters validos alteram os valores corretamente
    @Test
    @DisplayName("SetNome e SetCpf aceitam valores validos")
    void testSetNomeAndCpfAcceptValidValues() {
        Funcionario funcionario = new Funcionario("silva", "000.000.000-00", 1000.0f);
        funcionario.setNome("Fulano da silva");
        funcionario.setCpf("123.456.789-00");
        assertEquals("Fulano da silva", funcionario.getNome());
        assertEquals("123.456.789-00", funcionario.getCpf());
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