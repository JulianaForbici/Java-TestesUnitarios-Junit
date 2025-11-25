package ExerciciosPoo.Bonificacao;

public class ControleDeBonificacoes {
    private double totalBonificacao = 0.0;

    public void registrar(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo");
        }
        // getBonificacao retorna float mas soma em double
        totalBonificacao += funcionario.getBonificacao();
    }
    public double getTotalBonificacoes() {
        return totalBonificacao;
    }
    public static void main(String[] args) {
        ControleDeBonificacoes controle = new ControleDeBonificacoes();

        Funcionario funcionario1 = new Funcionario("Juliana", "111.111.111-11", 3000.0f);   // 5% -> 150.0
        Gerente gerente1 = new Gerente("Lara", "444.444.444-44", 8000.0f, "pwd1", 2);  // 5% -> 225.0

        // registra todos
        controle.registrar(funcionario1);
        controle.registrar(gerente1);

        // imprime bonificações individuais
        System.out.printf("%s || bonificação de: R$ %.2f%n", funcionario1.getNome(), (double) funcionario1.getBonificacao());
        System.out.printf("%s || bonificação de: R$ %.2f%n", gerente1.getNome(), (double) gerente1.getBonificacao());

        System.out.println("-------------------------------------");
        System.out.printf("Total das bonificações: R$ %.2f%n", controle.getTotalBonificacoes());
    }
}