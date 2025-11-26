package ExerciciosPoo.Vendas;

public class Produto {
    private int codigo;
    private double valor;
    private String descricao;

    public Produto(int codigo, double valor, String descricao) {
        // chama setters para centralizar validacoes
        setCodigo(codigo);
        setValor(valor);
        setDescricao(descricao);
    }

    // getters
    public int getCodigo() {
        return codigo;
    }
    public double getValor() {
        return valor;
    }
    public String getDescricao() {
        return descricao;
    }

    // setters com validacao
    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("codigo nao pode ser negativo");
        }
        this.codigo = codigo;
    }
    public void setValor(double valor) {
        if (valor < 0.0) {
            throw new IllegalArgumentException("valor nao pode ser negativo");
        }
        this.valor = valor;
    }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("descricao nao pode ser nula ou vazia");
        }
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao + " (cod: " + codigo + ") R$ " + String.format("%.2f", valor);
    }
}