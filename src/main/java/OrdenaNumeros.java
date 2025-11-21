import java.util.Scanner;

public class OrdenaNumeros {

    private static int readFiveNumbers(Scanner leTerminal, String texto) {
        while (true) {
            System.out.print(texto);
            String row = leTerminal.nextLine();
            try {
                // tento transformar o que a pessoa digitou num int e dá erro se n for int
                return Integer.parseInt(row.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número inteiro!");
            }
        }
    }
    // recebe 5 números e devolve eles em ordem crescente, tudo em string
    public static String sortFiveNumbers(int a, int b, int c, int d, int e) {
        int numbertemp;
        // como são só 5 números, 4 loopings já resolvem
        for (int i = 0; i < 4; i++) {
            if (a > b) { numbertemp = a; a = b; b = numbertemp; }
            if (b > c) { numbertemp = b; b = c; c = numbertemp; }
            if (c > d) { numbertemp = c; c = d; d = numbertemp; }
            if (d > e) { numbertemp = d; d = e; e = numbertemp; }
        }
        // no final a <= b <= c <= d <= e
        return a + " " + b + " " + c + " " + d + " " + e;
    }
    public static void main(String[] args) {
        Scanner leTerminal = new Scanner(System.in);
        // aqui eu só vou pedindo os 5 valores um por um
        int a = readFiveNumbers(leTerminal, "**-----Digite o primeiro valor-----**: ");
        int b = readFiveNumbers(leTerminal, "**-----Digite o segundo valor-----**: ");
        int c = readFiveNumbers(leTerminal, "**-----Digite o terceiro valor-----**: ");
        int d = readFiveNumbers(leTerminal, "**-----Digite o quarto valor-----**: ");
        int e = readFiveNumbers(leTerminal, "**-----Digite o quinto valor-----**: ");
        // chamo o método que realmente ordena
        String ordered = sortFiveNumbers(a, b, c, d, e);
        System.out.println("Cinco valores ordenados (menor para o maior): " + ordered);
        leTerminal.close();
    }
}