package ExerciciosPoo.Vendas;

public class ItemPedido {
    private Produto produto;
    private int qtde;
    // snapshot do valor unitario no momento do pedido
    private double valorProduto;

    // construtor completo que chama os setters
    public ItemPedido(Produto produto, int qtde) {
        setProduto(produto);
        setQtde(qtde);
        // setProduto ja popula o snapshot do preco
    }

    // getters
    public Produto getProduto() {
        return produto;
    }

    public int getQtde() {
        return qtde;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    // setters com validacao

    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("produto nao pode ser nulo");
        }
        this.produto = produto;
        // captura snapshot do preco no momento da associacao
        this.valorProduto = produto.getValor();
    }

    public void setQtde(int qtde) {
        if (qtde <= 0) {
            throw new IllegalArgumentException("quantidade deve ser maior que zero");
        }
        this.qtde = qtde;
    }

    // calcula subtotal do item (qtde * valorProduto)
    public double obterValorItemPedido() {
        return qtde * valorProduto;
    }

    @Override
    public String toString() {
        return produto.getDescricao() + " x" + qtde + " -> R$ " + String.format("%.2f", obterValorItemPedido());
    }
}