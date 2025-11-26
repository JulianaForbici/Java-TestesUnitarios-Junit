package ExerciciosPoo.Vendas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    // construtor deve capturar snapshot do preco e calcular subtotal corretamente
    @Test
    @DisplayName("construtor captura snapshot do preco e calcula subtotal corretamente")
    void testConstructorCapturesSnapshotAndSubtotal() {
        Produto produto = new Produto(1, 15.0, "caneta");
        ItemPedido item = new ItemPedido(produto, 3);

        assertSame(produto, item.getProduto());
        assertEquals(3, item.getQtde());
        assertEquals(15.0, item.getValorProduto(), 1e-6);
        assertEquals(45.0, item.obterValorItemPedido(), 1e-6);
    }

    // construtor com produto nulo deve lançar exceção
    @Test
    @DisplayName("construtor com produto nulo lancara IllegalArgumentException")
    void testConstructorNullProdutoThrows() {
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(null, 1));
    }

    // construtor com quantidade inválida deve lançar exceção
    @ParameterizedTest
    @DisplayName("construtor com quantidade invalida lancara IllegalArgumentException")
    @ValueSource(ints = {0, -1, -5})
    void testConstructorInvalidQtdeThrows(int invalidQtde) {
        Produto produto = new Produto(1, 10.0, "x");
        assertThrows(IllegalArgumentException.class,
                () -> new ItemPedido(produto, invalidQtde));
    }

    // setProduto deve atualizar o snapshot do preco e o subtotal refletir a mudança
    @Test
    @DisplayName("setProduto atualiza snapshot do preco e alterar subtotal")
    void testSetProdutoUpdatesSnapshot() {
        Produto produto1 = new Produto(1, 10.0, "p1");
        Produto produto2 = new Produto(2, 20.0, "p2");

        ItemPedido item = new ItemPedido(produto1, 2);
        assertEquals(10.0, item.getValorProduto(), 1e-6);
        assertEquals(20.0, item.obterValorItemPedido(), 1e-6); // 2 * 10

        // troca o produto e verifica que valorProduto foi atualizado para o novo preco
        item.setProduto(produto2);
        assertSame(produto2, item.getProduto());
        assertEquals(20.0, item.getValorProduto(), 1e-6);
        assertEquals(40.0, item.obterValorItemPedido(), 1e-6); // 2 * 20
    }

    // setQtde com valor inválido deve lançar exceção
    @Test
    @DisplayName("setQtde com valor invalido lancara IllegalArgumentException")
    void testSetQtdeInvalidThrows() {
        Produto produto = new Produto(1, 5.0, "x");
        ItemPedido item = new ItemPedido(produto, 1);
        assertThrows(IllegalArgumentException.class,
                () -> item.setQtde(0));
        assertThrows(IllegalArgumentException.class,
                () -> item.setQtde(-3));
    }

    // toString deve conter descricao, qtde e subtotal formatado (respeitando locale)
    @Test
    @DisplayName("toString contem descricao, qtde e subtotal formatado")
    void testToStringContainsInfo() {
        Produto produto = new Produto(1, 7.5, "Lapis");
        ItemPedido item = new ItemPedido(produto, 4);
        String s = item.toString();

        String subtotalFormatado = String.format("%.2f", item.obterValorItemPedido());

        assertTrue(s.contains("Lapis"));
        assertTrue(s.contains(String.valueOf(item.getQtde())), "toString deve conter a quantidade");
        assertTrue(s.contains(subtotalFormatado), "toString deve conter o subtotal formatado (" + subtotalFormatado + ")");
    }
}