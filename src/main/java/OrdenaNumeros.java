import java.util.Scanner;

public class OrdenaNumeros {
    public static int lerNumeroInt(Scanner sc, String textoTerminal) {
        while (true) {
            System.out.print(textoTerminal);
            String line = sc.nextLine();
            try {
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
        Scanner sc = new Scanner(System.in);
        int a = lerNumeroInt(sc, "**-----Digite o primeiro valor-----**: ");
        int b = lerNumeroInt(sc, "**-----Digite o segundo valor-----**: ");
        int c = lerNumeroInt(sc, "**-----Digite o terceiro valor-----**: ");
        int d = lerNumeroInt(sc, "**-----Digite o quarto valor-----**: ");
        int e = lerNumeroInt(sc, "**-----Digite o quinto valor-----**: ");
        String ordenados = ordenarNumeros(a, b, c, d, e);
        System.out.println("Cinco valores ordenados (menor para o maior): " + ordenados);
        sc.close();
    }
}