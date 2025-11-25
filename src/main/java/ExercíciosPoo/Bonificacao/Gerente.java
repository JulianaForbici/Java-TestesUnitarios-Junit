package ExercíciosPoo.Bonificacao;

public class Gerente extends Funcionario {

    String senha;
    int qtdGerenciados;

    public Gerente(String nome, String cpf, float salario,
                   String senha, int qtdGerenciados) {
        super(nome, cpf, salario);
        this.senha = senha;
        this.qtdGerenciados = qtdGerenciados;
    }

    // Gerente: 10% de bonificação
    @Override
    public float getBonificacao() {
        return salario * 0.10f;
    }
}