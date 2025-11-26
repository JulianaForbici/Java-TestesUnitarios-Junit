package ExerciciosPoo.Carro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    @ParameterizedTest
    @DisplayName("Getters retornam os valores esperados")
    @CsvSource({
            "Juliana F, 111.111.111-11",
            "Lara E, 000.000.000-00",
            "Matheus T, 222.222.222-22"
    })
    void testGetters(String nome, String cpf) {
        Pessoa pessoa = new Pessoa(nome, cpf);
        assertEquals(nome, pessoa.getNome());
        assertEquals(cpf, pessoa.getCpf());
    }
    @ParameterizedTest
    @DisplayName("toString retorna formato 'nome (cpf)'")
    @CsvSource({
            "Juliana F, 111.567.111-11",
            "Ana Maria, 000.000.000-00",
            "João, 123.456.789-00"
    })
    void testToString(String nome, String cpf) {
        Pessoa pessoa = new Pessoa(nome, cpf);
        assertEquals(nome + " (" + cpf + ")", pessoa.toString());
    }
}