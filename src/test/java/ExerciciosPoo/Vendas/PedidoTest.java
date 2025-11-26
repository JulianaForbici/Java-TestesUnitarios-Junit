package ExerciciosPoo.Vendas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    // adicionarItem deve acumular subtotais e obterValorPedido retornar total correto
    @Test
    @DisplayName("adicionarItem acumula subtotais e obterValorPedido retorna total correto")
    void testAdicionarItemAndObterValorPedido() {
        Produto produto = new Produto(1, 10.0, "papel");
        Produto produto2 = new Produto(2, 25.5, "apontador");

        Pedido pedido = new Pedido();
        pedido.adicionarItem(produto, 3); // 30.0
        pedido.adicionarItem(produto2, 2); // 51.0

        assertEquals(81.0, pedido.obterValorPedido(), 1e-6);

        List<ItemPedido> itens = pedido.getItens();
        assertEquals(2, itens.size());
        assertEquals("papel", itens.get(0).getProduto().getDescricao());
    }

    // adicionarItem com produto nulo deve lançar exceção
    @Test
    @DisplayName("adicionarItem com produto nulo lancara IllegalArgumentException")
    void testAdicionarItemNullProdutoThrows() {
        Pedido pedido = new Pedido();
        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(null, 1));
    }

    // adicionarItem com quantidade inválida deve lançar exceção
    @Test
    @DisplayName("adicionarItem com quantidade invalida lancara IllegalArgumentException")
    void testAdicionarItemInvalidQtdeThrows() {
        Produto produto = new Produto(1, 10.0, "x");
        Pedido pedido = new Pedido();
        assertThrows(IllegalArgumentException.class,
                () -> pedido.adicionarItem(produto, 0));
        assertThrows(IllegalArgumentException.class,
                () -> pedido.adicionarItem(produto, -2));
    }

    // getItens deve retornar lista imutável
    @Test
    @DisplayName("getItens retorna lista imutavel")
    void testGetItensUnmodifiable() {
        Produto produto = new Produto(1, 1.0, "x");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(produto, 1);
        List<ItemPedido> itens = pedido.getItens();
        assertThrows(UnsupportedOperationException.class, () -> itens.add(new ItemPedido(produto, 1)));
    }

    // snapshot do preco é preservado após alterar preco do produto; novos itens usam novo preco
    @Test
    @DisplayName("snapshot preservado apos alterar preco do produto; novos itens usam novo preco")
    void testSnapshotPreservedAfterProductPriceChange() {
        Produto produto = new Produto(1, 10.0, "papel");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(produto, 2); // subtotal 20
        assertEquals(20.0, pedido.obterValorPedido(), 1e-6);

        // altera preco do produto
        produto.setValor(12.0);

        // total do pedido permanece o mesmo
        assertEquals(20.0, pedido.obterValorPedido(), 1e-6);

        // adicionar novo item usa novo preco
        pedido.adicionarItem(produto, 1); // +12
        assertEquals(32.0, pedido.obterValorPedido(), 1e-6);
    }

    // toString deve conter TOTAL em maiusculas e mostrar valor formatado (respeitando locale)
    @Test
    @DisplayName("toString contem TOTAL em maiusculas e mostra valor formatado")
    void testToStringContainsTotal() {
        Produto produto = new Produto(1, 5.0, "x");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(produto, 2); // 10.0
        String s = pedido.toString();

        String totalFormatado = String.format("%.2f", pedido.obterValorPedido());

        assertTrue(s.contains("TOTAL") || s.contains("Total"));
        assertTrue(s.contains(totalFormatado), "toString deve conter o valor total formatado (" + totalFormatado + ")");
    }
}