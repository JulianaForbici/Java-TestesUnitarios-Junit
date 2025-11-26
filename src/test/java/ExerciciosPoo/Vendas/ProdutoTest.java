package ExerciciosPoo.Vendas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ProdutoTest {

    // testa construtor e getters com valores válidos
    @ParameterizedTest
    @org.junit.jupiter.api.DisplayName("construtor e getters retornam os valores esperados")
    @CsvSource({
            "0, 0.0, caneta",
            "1, 10.5, caderno",
            "42, 199.99, jogo"
    })
    void testConstructorAndGetters(int codigo, double valor, String descricao) {
        Produto p = new Produto(codigo, valor, descricao);
        assertEquals(codigo, p.getCodigo());
        assertEquals(valor, p.getValor(), 1e-6);
        assertEquals(descricao, p.getDescricao());
    }

    // valida que descricao nula no construtor lança excecao
    @Test
    @org.junit.jupiter.api.DisplayName("construtor com descricao nula lancara IllegalArgumentException")
    void testConstructorNullDescricaoThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(1, 10.0, null));
    }

    // valida que descricao vazia ou em branco no construtor lança excecao
    @Test
    @org.junit.jupiter.api.DisplayName("construtor com descricao vazia ou em branco lancara IllegalArgumentException")
    void testConstructorEmptyOrBlankDescricaoThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(1, 10.0, ""));
        assertThrows(IllegalArgumentException.class, () -> new Produto(1, 10.0, "   "));
    }

    // valida que setCodigo nao aceita valores negativos
    @Test
    @org.junit.jupiter.api.DisplayName("setCodigo negativo lancara IllegalArgumentException")
    void testSetCodigoNegativeThrows() {
        Produto p = new Produto(0, 0.0, "x");
        assertThrows(IllegalArgumentException.class, () -> p.setCodigo(-1));
    }

    // valida que setValor nao aceita valores negativos
    @Test
    @org.junit.jupiter.api.DisplayName("setValor negativo lancara IllegalArgumentException")
    void testSetValorNegativeThrows() {
        Produto p = new Produto(0, 0.0, "x");
        assertThrows(IllegalArgumentException.class, () -> p.setValor(-0.01));
    }

    // valida que setDescricao nao aceita string vazia ou em branco
    @Test
    @org.junit.jupiter.api.DisplayName("setDescricao vazio ou em branco lancara IllegalArgumentException")
    void testSetDescricaoEmptyOrBlankThrows() {
        Produto p = new Produto(0, 1.0, "ok");
        assertThrows(IllegalArgumentException.class, () -> p.setDescricao(""));
        assertThrows(IllegalArgumentException.class, () -> p.setDescricao("   "));
    }

    // toString deve conter descricao, codigo e valor formatado (respeitando o locale da JVM)
    @Test
    @org.junit.jupiter.api.DisplayName("toString contem descricao, codigo e valor formatado")
    void testToStringContainsInfo() {
        Produto p = new Produto(7, 12.5, "Borracha");
        String s = p.toString();

        // valor formatado usando o mesmo formato utilizado pela classe (respeita locale)
        String valorFormatado = String.format("%.2f", p.getValor());

        assertTrue(s.contains(p.getDescricao()), "toString deve conter a descricao");
        assertTrue(s.contains(String.valueOf(p.getCodigo())), "toString deve conter o codigo");
        assertTrue(s.contains(valorFormatado), "toString deve conter o valor formatado (" + valorFormatado + ")");
    }
}