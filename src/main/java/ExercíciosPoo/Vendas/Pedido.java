package ExercíciosPoo.Vendas;

import java.util.ArrayList;

public class Pedido {

    double valorTotal;
    ArrayList<ItemPedido> itens = new ArrayList<>();

    // adiciona um item novo ao pedido
    public void adicionarItem(Produto p, int qtde) {
        ItemPedido item = new ItemPedido(p, qtde);
        itens.add(item);
    }

    // soma o valor de todos os itens
    public double obterValorPedido() {
        valorTotal = 0; // zera antes de recalcular

        for (ItemPedido item : itens) {
            valorTotal += item.obterValorItemPedido();
        }

        return valorTotal;
    }
}