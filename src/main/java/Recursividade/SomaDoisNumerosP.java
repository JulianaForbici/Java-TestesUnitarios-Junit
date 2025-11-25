package Recursividade;
import java.util.Scanner;

public class SomaDoisNumerosP {
    public static int somaPares(int numero) {
        // caso base || quando o numero for 1 ou menor, não tem par pra somar
        if (numero <= 1) {
            return 0;
        }
        // se for ímpar vai ignorar esse número e chamar o anterior
        if (numero % 2 != 0) {
            return somaPares(numero - 1);
        }
        // se for par, soma o próprio número com a soma dos pares até numero - 2
        return numero + somaPares(numero - 2);
    }
    public static void main(String[] args) {
        Scanner leTerminal = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        if (!leTerminal.hasNextInt()) {
            System.out.println("Você deve digitar um número inteiro!");
            leTerminal.close();
            return;
        }
        int numero = leTerminal.nextInt();
        // aqui eu garanto que a entrada do usuário é positiva
        if (numero < 1) {
            System.out.println("O número deve ser maior ou igual a 1!");
            leTerminal.close();
            return;
        }
        int resultado = somaPares(numero);
        System.out.println("Soma dos números pares de 1 até " + numero + " é " + resultado);
        leTerminal.close();
    }
}
