package Calculadora;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner leScanner = new Scanner(System.in);
        BigDecimal a = lerNumero(leScanner, "Digite o primeiro número: ");
        BigDecimal b = lerNumero(leScanner, "Digite o segundo número: ");
        System.out.println("Resultado da soma: " + a.add(b));
        System.out.println("Resultado da sutração: " + a.subtract(b));
        System.out.println("Resultado da multiplicação: " + a.multiply(b));
        System.out.println("Resultado da divisão: " + dividir(a, b));
        leScanner.close();
    }
    // Metódo lerNumero do scanner
    private static BigDecimal lerNumero(Scanner leScanner, String texto) {
        while (true) {
            System.out.print(texto);
            try {
                return new BigDecimal(leScanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Erro! Número digitado inválido!");
            }
        }
    }
    // Verifica se b é zero. Se sim, lança exceção e se não ele arredonda com 2 casas decimais:
    private static BigDecimal dividir(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Divisão por zero não permitida!");
        }
        return a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
    }
}