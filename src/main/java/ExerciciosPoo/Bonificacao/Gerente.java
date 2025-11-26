package ExerciciosPoo.Bonificacao;

public class Gerente extends Funcionario {
    private String senha;
    private int qtdGerenciados;

    public Gerente(String nome, String cpf, float salario, String senha, int qtdGerenciados) {
        super(nome, cpf, salario);
        setSenha(senha);
        setQtdGerenciados(qtdGerenciados);
    }
    // getters
    public String getSenha() {
        return senha;
    }
    public int getQtdGerenciados() {
        return qtdGerenciados;
    }
    // setters
    public void setSenha( String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia!");
        }
        this.senha = senha;
    }
    public void setQtdGerenciados(int qtdGerenciados){
        if (qtdGerenciados < 0) {
            throw new IllegalArgumentException("Quantidade de gerenciados deve ser maior ou igual a zero!");
        }
        this.qtdGerenciados = qtdGerenciados;
    }
    // gerente recebe bonificacao maior de 10% do salário (retorna float)
    @Override
    public float getBonificacao() {
        return getSalario() * 0.10f;
    }

    @Override
    public String toString() {
        return String.format("Gerente: %s - gerencia %d", super.toString(), qtdGerenciados);
    }
}