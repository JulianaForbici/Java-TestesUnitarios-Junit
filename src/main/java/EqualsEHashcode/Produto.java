package EqualsEHashcode;

public class Produto {

    private String sku;
    private String nome;

    public Produto(String sku, String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    // getters e setters

    @Override
    public String toString() {
        return "Produto [sku=" + sku + ", nome=" + nome + "]";
    }
}