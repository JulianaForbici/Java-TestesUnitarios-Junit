package ExerciciosPoo.Carro;

public class Pessoa {

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }
   // getters
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
  // setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return nome + " (" + cpf + ")";
    }
}