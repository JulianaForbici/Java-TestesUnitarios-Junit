package ExerciciosPoo.Bonificacao;

public class Funcionario {
    private String nome;
    private String cpf;
    private float salario;

    // construtor chama os setters (validação centralizada)
    public Funcionario(String nome, String cpf, float salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    // getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public float getSalario() {
        return salario;
    }

    // setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        this.cpf = cpf;
    }

    public void setSalario(float salario) {
        if (salario < 0f) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.salario = salario;
    }

    // bonificação padrão: 5% do salário (retorna float)
    public float getBonificacao() {
        return this.salario * 0.05f;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - R$ %.2f", nome, cpf, salario);
    }
}
