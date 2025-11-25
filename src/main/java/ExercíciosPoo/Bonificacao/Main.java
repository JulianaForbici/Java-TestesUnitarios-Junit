package ExercíciosPoo.Bonificacao;

public class Main {
    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario("Juliana", "1111111111", 2000f);
        Gerente gerente1 = new Gerente("Fulana", "333.333.333-33", 4000f, "1234", 5);

        ControleDeBonificacoes controle = new ControleDeBonificacoes();

        System.out.println("Bonificação da funcionária " + funcionario1.nome +
                ": R$ " + funcionario1.getBonificacao());

        System.out.println("Bonificação da gerente " + gerente1.nome +
                ": R$ " + gerente1.getBonificacao());

        controle.registrar(funcionario1);
        controle.registrar(gerente1);

        // Total
        System.out.println("Total de bonificações é R$: " +
                controle.getTotalBonificacoes());
    }
}