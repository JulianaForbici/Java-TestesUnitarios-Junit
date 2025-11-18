import java.util.Scanner;

public class NumerosRomanos {
    private static final int[] VALORES = {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,  1};
    private static final String[] SIMBOLOS ={"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
    public static String toRoman(int numero)
    {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Erro! Deve ser entre 1 e 3999");
        }
        StringBuilder sb = new StringBuilder();
        int restante = numero;
        for (int i = 0; i < VALORES.length; i++) {
            while (restante >= VALORES[i]) {
                sb.append(SIMBOLOS[i]);
                restante -= VALORES[i];
            }
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite um inteiro entre 1 e 3999: ");
            if (!sc.hasNextInt()) {
                System.err.println("Erro! Digite um número inteiro");
                return;
            }
            int n = sc.nextInt();
            System.out.println("Número em forma Romana: " + toRoman(n));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro!!! " + e.getMessage());
        }
    }
}