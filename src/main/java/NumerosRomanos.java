import java.util.Scanner;

public class NumerosRomanos {

    // Fiz um método que recebe um número int e devolve ele em número romano (mas como *STRING*)
    public static String numerosParaConversao(int numeroEmRomano) {
        // Aqui eu confiro se o número está no intervalo permitido e se for menor que 1 ou maior que 3999, jogo um erro no terminal
        if (numeroEmRomano < 1 || numeroEmRomano > 3999) {
            throw new IllegalArgumentException("O número digitado deve ser entre 1 e 3999");
        }
        // Esses são os valores inteiros que vou usar para montar as sequências dos números romanos
        int[] valores = {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,  1};
        // Esses são os símbolos romanos que correspondem aos valores acima, *na mesma ordem*
        String[] simbolos ={"M",  "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        // Aqui vou guardar o resultado final em romano
        String resultado = "";
        // Esse “restante” vai diminuindo até chegar em zero
        int restante = numeroEmRomano;
        // Passo por todos os valores do maior para o menor
        for (int r = 0; r < valores.length; r++) {
            // Enquanto o número que sobrou ainda for maior ou igual ao valor atual, eu adiciono o símbolo romano correspondente e diminuo o restante
            while (restante >= valores[r]) {
                resultado += simbolos[r];
                restante -= valores[r];
            }
        }
        // Quando o restante chegar em 0, o resultado fica pronto
        return resultado;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Loop principal do programa
        while (true) {
            System.out.println("------------------------------------------");
            System.out.print("Digite um inteiro entre 1 e 3999 || Ou digite 0 para sair: ");
            // Aqui no if eu confiro se o que o usuário digitou é int
            if (!sc.hasNextInt()) {
                System.out.println("Você deve digitar um número inteiro!");
                sc.next(); // descarto o que ele digitou, porque não é número
                continue;  // volto pro começo do while
            }
            // se chegou aqui já sei que é um inteiro
            int numeroEmRomano = sc.nextInt();
            // Se o número for 0, eu uso isso como comando para encerrar o programa
            if (numeroEmRomano == 0) {
                System.out.println("Programa encerrado.");
                break;
            }
            try {
                // Chamo o método que converte o número para romano nessa linha
                String romano = numerosParaConversao(numeroEmRomano);
                System.out.println("Número em romano: " + romano);
            } catch (IllegalArgumentException e) {
                // Se o número estiver fora do intervalo 1–3999, cai aqui
                System.out.println("Erro! " + e.getMessage());
            }
            System.out.println("------------------------------------------");
        }
        sc.close();
    }
}