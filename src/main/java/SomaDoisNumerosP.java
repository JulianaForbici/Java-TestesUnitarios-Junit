import java.util.Scanner;

public class SomaDoisNumerosP {
    // método recursivo que soma os números pares
    public static int soma(int numeroDigitado) {
        // caso base || quando numeroDigitado for 1 ou menor, não tem mais par pra somar
        if (numeroDigitado <= 1) {
            return 0;
        }
        // se for ímpar, ignora esse número e chama para o anterior
        if (numeroDigitado % 2 != 0) {
            return soma(numeroDigitado - 1);
        }
        // se for par, soma o próprio número com a soma dos pares até numeroDigitado - 2
        return numeroDigitado + soma(numeroDigitado - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você deve digitar um número inteiro!");
            sc.close();
            return;
        }
        int numeroDigitado = sc.nextInt();
        // aqui eu garanto que a entrada do usuário é positiva
        if (numeroDigitado < 1) {
            System.out.println("O número deve ser maior ou igual a 1.");
            sc.close();
            return;
        }
        int resultado = soma(numeroDigitado);
        System.out.println("Soma dos números pares de 1 até " + numeroDigitado + " = " + resultado);
        sc.close();
    }
}