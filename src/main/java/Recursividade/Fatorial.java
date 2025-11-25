package Recursividade;
import java.math.BigInteger;

public class Fatorial {
    public static BigInteger fatorial(int numeroFatorial) {
        // caso base
        if (numeroFatorial < 0) {
            throw new IllegalArgumentException("O número digitado deve ser maior ou igual a 0!");
        }
        // caso base
        if (numeroFatorial == 0 || numeroFatorial == 1) {
            return BigInteger.ONE;
        }
        // aqui vai cair na recursividade:
        // retorna n * fatorial(n-1) como BigInteger
        return BigInteger.valueOf(numeroFatorial).multiply(fatorial(numeroFatorial - 1));
    }
    public static void main(String[] args) {
        // fatorial de 0 e 1 são os casos bases, já que retornam 1 sem recursão
        System.out.println("0! = " + fatorial(0));
        System.out.println("1! = " + fatorial(1));
        System.out.println("2! = " + fatorial(2)); // 2 x 1 = 2
        System.out.println("3! = " + fatorial(3)); // 3 x 2 = 6
        System.out.println("4! = " + fatorial(4)); // 4 x 6 = 24
        System.out.println("5! = " + fatorial(5)); // 5 x 24 = 120
        System.out.println("20! = " + fatorial(20)); // 20! = produto de 1 até 20 = 2432902008176640000
        System.out.println("30! = " + fatorial(30));
    }
}
