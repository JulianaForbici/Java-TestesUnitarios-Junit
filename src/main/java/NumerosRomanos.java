import java.util.Scanner;

public class NumerosRomanos {

    // fiz um método que recebe um número int e devolve ele em número romano (mas como *STRING*)
    public static String numerosParaConversao(int numero) {
        // aqui eu confiro se o número está no intervalo permitido e se for menor que 1 ou maior que 3999, jogo um erro no terminal
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("O número digitado deve ser entre 1 e 3999");
        }
        int[] valores   = {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,  1};
        String[] simbolos = {"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        // aqui vou guardar o resultado final em romano
        String resultado = "";
        // esse restante vai diminuindo até chegar em zero
        int restante = numero;
        // passo por todos os valores do maior para o menor
        for (int r = 0; r < valores.length; r++) {
            // enquanto o número que sobrou ainda for maior ou igual ao valor atual, eu adiciono o símbolo romano correspondente e diminuo o restante
            while (restante >= valores[r]) {
                resultado += simbolos[r];
                restante -= valores[r];
            }
        }
        // quando o restante chegar em 0, o resultado fica pronto
        return resultado;
    }
    public static void main(String[] args) {
        Scanner leTerminal = new Scanner(System.in);
        // loop principal do programa
        while (true) {
            System.out.println("------------------------------------------");
            System.out.print("Digite um inteiro entre 1 e 3999: ");
            // aqui no if eu confiro se o que o usuário digitou é int
            if (!leTerminal.hasNextInt()) {
                System.out.println("Você deve digitar um número inteiro!");
                leTerminal.next(); // descarto o que ele digitou, porque não é número
                continue;  // volto pro começo do while
            }
            // se chegou aqui já sei que é um inteiro
            int numero = leTerminal.nextInt();
            try {
                // chamo o método que converte o número para romano nessa linha
                String romano = numerosParaConversao(numero);
                System.out.println("Número em romano: " + romano);
            } catch (IllegalArgumentException e) {
                // se o número estiver fora do intervalo 1–3999 (inclui 0), cai aqui
                System.out.println("Erro! " + e.getMessage());
            }
            System.out.println();
        }
    }
}
