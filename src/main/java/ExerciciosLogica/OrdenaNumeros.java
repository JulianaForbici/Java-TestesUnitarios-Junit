package ExerciciosLogica;

import java.util.Scanner;

public class OrdenaNumeros {
    public static int lerNumeroInt(Scanner leTerminal, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String line = leTerminal.nextLine();
            try {
                // tenta converter a string em um int
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número inteiro!");
            }
        }
    }
    // coloca o menor em a, depois o menor dos restantes em b, e assim por diante
    public static String ordenarNumeros(int a, int b, int c, int d, int e) {
        int numero;
        // guarda o valor de a em uma variável temporária e verifica se o valor de b é menor que o valor de a
        if (b < a) {
            numero = a;
            a = b;
            b = numero;
        }

        if (c < a) { numero = a; a = c; c = numero; }
        if (d < a) { numero = a; a = d; d = numero; }
        if (e < a) { numero = a; a = e; e = numero; }

        // colocar o menor entre (b, c, d, e) em b
        if (c < b) { numero = b; b = c; c = numero; }
        if (d < b) { numero = b; b = d; d = numero; }
        if (e < b) { numero = b; b = e; e = numero; }

        // colocar o menor entre (c, d, e) em c
        if (d < c) { numero = c; c = d; d = numero; }
        if (e < c) { numero = c; c = e; e = numero; }

        // colocar o menor entre (d, e) em d
        if (e < d) { numero = d; d = e; e = numero; }

        return a + " " + b + " " + c + " " + d + " " + e;
    }
    public static void main(String[] args) {
        Scanner leTerminal = new Scanner(System.in);
        int a = lerNumeroInt(leTerminal, "**-----Digite o primeiro valor-----**: ");
        int b = lerNumeroInt(leTerminal, "**-----Digite o segundo valor-----**: ");
        int c = lerNumeroInt(leTerminal, "**-----Digite o terceiro valor-----**: ");
        int d = lerNumeroInt(leTerminal, "**-----Digite o quarto valor-----**: ");
        int e = lerNumeroInt(leTerminal, "**-----Digite o quinto valor-----**: ");
        String ordenados = ordenarNumeros(a, b, c, d, e);
        System.out.println("Cinco valores ordenados (menor para o maior): " + ordenados);
        leTerminal.close();
    }
}