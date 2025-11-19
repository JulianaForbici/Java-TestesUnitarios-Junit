package ExercíciosFeitos.Recursividade;
import java.util.Scanner;

public class SomaDoisNumerosP {
    // método recursivo que soma os números pares de 1 até x
    public static int sumEven(int x) {
        // quando x for 1 ou menor, não tem mais par pra somar (2 já passou)
        // então eu paro a recursão e retorno 0 || Caso base
        if (x <= 1) {
            return 0;
        }
        // se x for ímpar, eu ignoro esse x e chamo a função pro número anterior || Caso recursivo
        if (x % 2 != 0) {
            return sumEven(x - 1);
        }
        // se x for par, eu somo o próprio x com a soma dos pares até x - 2 || Caso recursivo
        return x + sumEven(x - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você deve digitar um número inteiro!");
            sc.close();
            return;
        }
        int x = sc.nextInt();
        // aqui eu garanto que a entrada do usuário é positiva
        if (x < 1) {
            System.out.println("O número deve ser maior ou igual a 1.");
            sc.close();
            return;
        }
        int resultado = sumEven(x);
        System.out.println("Soma dos números pares de 1 até " + x + " = " + resultado);
        sc.close();
    }
}
