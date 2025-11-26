package ExerciciosPoo.Bonificacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

        // testa construtor e getters basicos do gerente
        @Test
        @DisplayName("getters retornam os valores esperados")
        void testConstructorAndGetters() {
            Gerente g = new Gerente("Lara", "222.222.222-22", 8000.0f, "123", 3);
            assertEquals("Lara", g.getNome());
            assertEquals("222.222.222-22", g.getCpf());
            assertEquals(8000.0f, g.getSalario(), 1e-6f);
            assertEquals("123", g.getSenha());
            assertEquals(3, g.getQtdGerenciados());
        }

        // testa que a bonificacao do gerente e 10% do salario
        @Test
        @DisplayName("getBonificacao retorna 10% do salario")
        void testBonificacaoIsTenPercent() {
            Gerente g = new Gerente("Julia", "111.111.111-11", 10000.0f, "s", 1);
            assertEquals(10000.0f * 0.10f, g.getBonificacao(), 1e-6f);
        }

        // testa que setSenha nula lancara excecao
        @Test
        @DisplayName("setSenha null lancara excecao")
        void testSetSenhaNullThrows() {
            Gerente g = new Gerente("Lara", "111.111.111-11", 1000.0f, "ok", 0);
            assertThrows(IllegalArgumentException.class, () -> g.setSenha(null));
        }

        // testa que setSenha vazia lancara excecao
        @Test
        @DisplayName("setSenha vazio lancara excecao")
        void testSetSenhaEmptyThrows() {
            Gerente g = new Gerente("Julia", "111.111.111-11", 1000.0f, "ok", 0);
            assertThrows(IllegalArgumentException.class, () -> g.setSenha(""));
        }

        // testa que setQtdGerenciados negativo lancara excecao
        @ParameterizedTest
        @DisplayName("setQtdGerenciados valores negativos lancam excecao")
        @ValueSource(ints = { -1, -5, Integer.MIN_VALUE })
        void testSetQtdGerenciadosNegativeThrows(int invalid) {
            Gerente g = new Gerente("Julia", "111.111.111-11", 1000.0f, "ok", 0);
            assertThrows(IllegalArgumentException.class, () -> g.setQtdGerenciados(invalid));
        }

        // testa toString contem informacoes basicas
        @Test
        @DisplayName("toString  contem informacoes do gerente")
        void testToStringContainsInfo() {
            Gerente g = new Gerente("Julia", "222.222.222-22", 8000.0f, "senha", 2);
            String s = g.toString();
            assertTrue(s.contains("Julia"), "toString deve conter o nome");
            assertTrue(s.contains("222.222.222-22"), "toString deve conter o cpf");
            assertTrue(s.contains("gerencia"), "toString deve indicar que e gerente");
        }

        // testa que o construtor do gerente valida nome e cpf via super e lancara excecao se invalidos
        @Test
        @DisplayName("construtor lancara excecao se nome for nulo")
        void testConstructorValidatesName() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Gerente(null, "222.222.222-22", 1000.0f, "x", 1));
        }
        @Test
        @DisplayName("construtor lancara excecao se cpf for nulo")
        void testConstructorValidatesCpf() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Gerente("Nome", null, 1000.0f, "x", 1));
        }
    }