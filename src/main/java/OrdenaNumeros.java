import java.util.Scanner;

public class OrdenaNumeros {

    private static int ordemCincoNumeros(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine();
            try {
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número inteiro!!");
            }
        }
    }
    public static String ordemCincoNumeros(int a, int b, int c, int d, int e) {
        int numerotemp;
        for (int i = 0; i < 4; i++) {
            if (a > b) { numerotemp = a; a = b; b = numerotemp; }
            if (b > c) { numerotemp = b; b = c; c = numerotemp; }
            if (c > d) { numerotemp = c; c = d; d = numerotemp; }
            if (d > e) { numerotemp = d; d = e; e = numerotemp; }
        }
        return a + " " + b + " " + c + " " + d + " " + e;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = ordemCincoNumeros(sc, "**-----Digite o primeiro valor-----**: ");
        int b = ordemCincoNumeros(sc, "**-----Digite o segundo valor-----**: ");
        int c = ordemCincoNumeros(sc, "**-----Digite o terceiro valor-----**: ");
        int d = ordemCincoNumeros(sc, "**-----Digite o quarto valor-----**: ");
        int e = ordemCincoNumeros(sc, "**-----Digite o quinto valor-----**: ");
        String ordenados = ordemCincoNumeros(a, b, c, d, e);
        System.out.println("Cinco valores ordenados em ordem crescente (menor para o maior): " + ordenados);
        sc.close();
    }
}
