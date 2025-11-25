package ExercíciosPoo.Vendas;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto(1, 10.0, "Caneta");
        Produto p2 = new Produto(2, 5.5, "Lápis");
        Produto p3 = new Produto(3, 20.0, "Caderno");

        Pedido pedido = new Pedido();

        pedido.adicionarItem(p1, 2); // 2 canetas
        pedido.adicionarItem(p2, 3); // 3 lápis
        pedido.adicionarItem(p3, 1); // 1 caderno

        System.out.println("Valor total do pedido: R$ " +
                pedido.obterValorPedido());
    }
}
