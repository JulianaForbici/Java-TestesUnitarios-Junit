package ExercíciosFeitos;

import java.util.Scanner;

public class NumerosRomanos {

    public static String numerosParaConversao(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("O número digitado deve ser entre 1 e 3999");
        }
        int[] valores   = {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,  1};
        String[] romanos = {"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        // aqui vou guardar o resultado final em romano
        String resultado = "";
        // esse restante vai diminuindo até chegar em romano
        int restante = numero;
        // aqui eu passo todos os números, do maior para o menor
        for (int r = 0; r < valores.length; r++) {
            // enquanto o número que sobrou ainda for maior ou igual ao valor atual,
            // eu adiciono o símbolo romano correspondente e diminuo o restante
            while (restante >= valores[r]) {
                resultado += romanos[r];
                restante -= valores[r];
            }
        }
        // quando o restante chegar em 0, o resultado fica pronto
        return resultado;
    }
    public static void main(String[] args) {
        Scanner leTerminal = new Scanner(System.in);
        // loop principal
        while (true) {
            System.out.println("------------------------------------------");
            System.out.print("Digite um inteiro entre 1 e 3999: ");
            if (!leTerminal.hasNextInt()) {
                System.out.println("Você deve digitar um número inteiro!");
                leTerminal.next();
                continue;
            }
            int numero = leTerminal.nextInt();
            try {
                // chamo o método que converte o número para romano nessa linha
                String romano = numerosParaConversao(numero);
                System.out.println("Número em romano: " + romano);
                // se o número estiver fora do intervalo 1–3999 (inclui 0), cai aqui no catch
            } catch (IllegalArgumentException e) {
                System.out.println("Erro! " + e.getMessage());
            }
            System.out.println();
        }
    }
}