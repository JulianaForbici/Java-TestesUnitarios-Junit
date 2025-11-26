package ExerciciosPoo.Vendas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final List<ItemPedido> itens = new ArrayList<>();
    private double valorTotal = 0.0;

    public Pedido() {
        // construtor simples; nenhum setter necessario aqui
    }

    // adiciona item criando ItemPedido (construtor chama os setters)
    public void adicionarItem(Produto p, int qtde) {
        if (p == null) {
            throw new IllegalArgumentException("produto nao pode ser nulo");
        }
        if (qtde <= 0) {
            throw new IllegalArgumentException("quantidade deve ser maior que zero");
        }

        ItemPedido item = new ItemPedido(p, qtde); // construtor chama setters
        itens.add(item);
        valorTotal += item.obterValorItemPedido();
    }

    public double obterValorPedido() {
        return valorTotal;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemPedido i : itens) {
            sb.append(i.toString()).append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", obterValorPedido()));
        return sb.toString();
    }

    public static void main(String[] args) {
        // criação dos produtos
        Produto produto1 = new Produto(1, 10.0, "Papel");
        Produto produto2 = new Produto(2, 25.5, "Apontador");

        // criação do pedido e inclusão dos itens
        Pedido pedido = new Pedido();
        pedido.adicionarItem(produto1, 3); // 3 * 10.0 = 30.0
        pedido.adicionarItem(produto2, 2); // 2 * 25.5 = 51.0

        System.out.println("Pedido inicial:");
        System.out.println(pedido);
        System.out.printf("Valor total do pedido: R$ %.2f%n", pedido.obterValorPedido());

        // altera preço do produto1 depois de já ter sido incluído no pedido
        produto1.setValor(12.0); // novo preço > 12.0

        System.out.println("\nApós alterar o preço do Produto 1 para 12.0:");
        System.out.println(pedido); // subtotal anterior não muda (snapshot)

        // Adiciona mais um item do mesmo produto com a nova quantidade/preço
        pedido.adicionarItem(produto1, 1);

        System.out.println("\nApós adicionar mais 1 unidade do Produto 1 com o novo preço:");
        System.out.println(pedido);
        System.out.printf("Valor total final do pedido: R$ %.2f%n", pedido.obterValorPedido());
    }
}