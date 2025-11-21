package Recursividade;
import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fibonacci(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("O número digitado deve ser maior ou igual a zero!");
        }
        // se for 0, por definição o resultado é 0
        if (numero == 0) {
            return BigInteger.ZERO;
        }
        // se for 1, por definição o resultado é 1
        if (numero == 1) {
            return BigInteger.ONE;
        }
        // F(f) = F(f - 1) + F(f - 2)
        return fibonacci(numero - 1).add(fibonacci(numero - 2));
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(20));
    }
}