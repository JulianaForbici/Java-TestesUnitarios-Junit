package ExercíciosPoo.Vendas;

public class ItemPedido {

    int qtde;
    double valorProduto;   // guarda o preço do produto no momento do pedido
    Produto prod;

    // construtor recebe o produto e a quantidade
    public ItemPedido(Produto p, int qtde) {
        this.prod = p;
        this.qtde = qtde;
        this.valorProduto = p.valor; // pega o valor do produto
    }

    // valor do item = preço do produto * quantidade
    public double obterValorItemPedido() {
        return valorProduto * qtde;
    }
}

