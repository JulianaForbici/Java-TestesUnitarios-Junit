package ExercíciosPoo.Bonificacao;

public class Funcionario {

        String nome;
        String cpf;
        float salario;

        public Funcionario(String nome, String cpf, float salario) {
            this.nome = nome;
            this.cpf = cpf;
            this.salario = salario;
        }

        public float getBonificacao() {
            return salario * 0.05f;
        }

}
