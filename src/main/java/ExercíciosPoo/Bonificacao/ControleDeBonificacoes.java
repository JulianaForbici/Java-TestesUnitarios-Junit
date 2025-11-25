package ExercíciosPoo.Bonificacao;

public class ControleDeBonificacoes {

    double totalBonificacoes;

    public void registrar(Funcionario f) {
        totalBonificacoes += f.getBonificacao();
    }

    public double getTotalBonificacoes() {
        return totalBonificacoes;
    }
}
